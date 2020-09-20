package activite_mq_demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MsgProvider {
    public static void main(String[] args) throws JMSException {
        //获取连接工厂
        ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory(
                ActiveMQConnectionFactory.DEFAULT_USER,
                ActiveMQConnectionFactory.DEFAULT_PASSWORD,
                "tcp://localhost:61616"
        );

        //获取链接,jms的connection
        Connection connection =connectionFactory.createConnection();
        //获取session
        Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);
        //创建一个queue，这是一个目的地，这里可以选择创建的是queue还是topic，如果是temporaly，则是临时的。
        Queue queue = session.createQueue("user");
        //创建生产者并设置目的地
        MessageProducer messageProducer = session.createProducer(queue);

        //向目的地发送消息
        TextMessage textMessage = session.createTextMessage("hello");
        for (int i =0;i<100;i++){
            messageProducer.send(textMessage);
        }
        //完事了就close，可以保持，当需要经常发送的时候
        connection.close();
    }


}
