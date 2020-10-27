package rocketmq;

import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;

import java.util.List;

/**
 * 顺序消费
 * @author BaryLeo
 * @version 1.0
 * @date 2020/9/22 20:31
 */
public class OrderConsumer {
    public static void main(String[] args) throws MQClientException {
        //consumer的group和provider的不能一样
        DefaultMQPushConsumer consumer = new DefaultMQPushConsumer("order1");

        consumer.setNamesrvAddr("localhost:9876");

        consumer.subscribe("o1","*");


        //MessageListenerConcurrently()这个是并发式消费消息，所以不能使用这个
//        consumer.registerMessageListener(new MessageListenerConcurrently() {
//            @Override
//            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
//                for (MessageExt msg :list){
//                    System.out.println(new String(msg.getBody()));
//                }
//
//                //将会回调服务器api，告诉服务收到信息了，默认p2p消息
//                return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
//            }
//        });

        // 最大开启消费线程数
        consumer.setConsumeThreadMax(1);
        //  最小线程数
        consumer.setConsumeThreadMin(1);

        consumer.registerMessageListener(new MessageListenerOrderly() {
            @Override
            public ConsumeOrderlyStatus consumeMessage(List<MessageExt> list, ConsumeOrderlyContext consumeOrderlyContext) {
                for (MessageExt msg :list){
                    System.out.println(new String(msg.getBody()));
                }

                //将会回调服务器api，告诉服务收到信息了，默认p2p消息
                return ConsumeOrderlyStatus.SUCCESS;
            }
        });

        consumer.start();
    }
}
