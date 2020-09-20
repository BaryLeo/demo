package activite_mq_demo;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

public class MsgConsumer {
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
        //创建一个Destination，这是一个目的地
        Destination queue = session.createQueue("user?consumer.exclusive=true");
        //创建生产者并设置获取消息的目的地
        MessageConsumer consumer = session.createConsumer(queue);
        //异步接收信息
        consumer.setMessageListener(new MessageListener() {
            @Override
            public void onMessage(Message message) {
                System.out.println("-----  listener -----");
                if (message instanceof TextMessage){
                    TextMessage textMessage = (TextMessage)message;
                    try {
                        System.out.println(textMessage.getText());
                    } catch (JMSException e) {
                        e.printStackTrace();
                    }
                }else if (message instanceof ObjectMessage){

                }else if (message instanceof MapMessage){

                }else if (message instanceof BytesMessage){

                }else if (message instanceof StreamMessage){

                }
            }
        });
        //然后设置开始接收消息，很重要，和生产者不同
        connection.start();
        while (true){
            try {
                Thread.sleep(100);
                System.out.println("main doing other");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //完事了就close，可以保持，当需要经常接收的时候
        //connection.close();
    }
}
