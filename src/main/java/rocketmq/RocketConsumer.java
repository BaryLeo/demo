package rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyContext;
import org.apache.rocketmq.client.consumer.listener.ConsumeConcurrentlyStatus;
import org.apache.rocketmq.client.consumer.listener.MessageListenerConcurrently;
import org.apache.rocketmq.common.message.MessageExt;
import org.apache.rocketmq.common.protocol.heartbeat.MessageModel;

import java.util.List;

public class RocketConsumer {

    public static void main(String[] args) throws Exception {
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("java");

        consumer.setNamesrvAddr("localhost:9876");

        consumer.subscribe("topicA","*");

        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                for (MessageExt msg :list){
                    System.out.println(new String(msg.getBody()));
                }

                //将会回调服务器api，告诉服务收到信息了，默认p2p消息
                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
            }
        });

        /**
         * 同一个topic下的所有消费者模式，需要一致，否则出毛病
         */
        //集群模式，消息只能消费一次
        consumer.setMessageModel(MessageModel.CLUSTERING);

        //广播模式，同一个topic的消费者都能接收到这个消息
        //consumer.setMessageModel(MessageModel.BROADCASTING);
        consumer.start();

        System.out.println("---- listening ----");
    }



}
