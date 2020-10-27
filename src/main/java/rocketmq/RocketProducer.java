package rocketmq;

import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.SendCallback;
import org.apache.rocketmq.client.producer.SendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.support.ManagedList;

import java.util.ArrayList;

public class RocketProducer {
    public static void main(String[] args) throws Exception{
        //设置producer的分组
        DefaultMQProducer producer = new DefaultMQProducer("java");

        //设置nameserver地址，要带端口号
        producer.setNamesrvAddr("localhost:9876");

        //启动producer
        producer.start();

        //设置topic和消息内容
        String topic = "topicA";
        String content = "hello";

        //设置消息
        Message message = new Message(topic,content.getBytes());

        /**
         * 发送单条消息，默认同步，发送后等待broker回送ack后才会走下一步
         */
        producer.send(message);

        /**
         * 另外 还有一种情况，要连续发送多条消息的时候，可以用一个list，就不需要一个个地发送，每次都阻塞
         * 一次性发送多条消息
         */
        Message message1 = new Message(topic,"a".getBytes());
        Message message2 = new Message(topic,"b".getBytes());
        Message message3 = new Message(topic,"c".getBytes());

        ArrayList<Message> list = new ManagedList<>();
        list.add(message1);
        list.add(message2);
        list.add(message3);

        producer.send(list);

        /**
         * 发送异步的可靠消息
         * 不阻塞消息，等待broker的确认
         * 采用事件监听的方法接受broker返回的确认
         */

        producer.send(message, new SendCallback() {
            @Override
            public void onSuccess(SendResult sendResult) {
                System.out.println("消息发送成功");
            }

            @Override
            public void onException(Throwable throwable) {
                //发生异常后，可以选择重发那或者调整业务逻辑
                System.out.println("消息发送出错");
            }
        });

        /**
         * 发送消息，不可靠，类似UDP，不需要broker回收确认
         */
        producer.sendOneway(message);

        //异步执行的，先不能执行shutdown
        //producer.shutdown();

        System.out.println("结束");
    }
}
