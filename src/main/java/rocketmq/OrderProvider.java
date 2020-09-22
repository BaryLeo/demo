package rocketmq;

import org.apache.rocketmq.client.exception.MQBrokerException;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.DefaultMQProducer;
import org.apache.rocketmq.client.producer.MessageQueueSelector;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByHash;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByMachineRoom;
import org.apache.rocketmq.client.producer.selector.SelectMessageQueueByRandom;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageQueue;
import org.apache.rocketmq.remoting.exception.RemotingException;

import java.util.List;

/**
 * 顺序消费的生产者，主要是选择queue
 * @author BaryLeo
 * @version 1.0
 * @date 2020/9/22 20:34
 */
public class OrderProvider {
    public static void main(String[] args) throws MQClientException, RemotingException, InterruptedException, MQBrokerException {
        //设置producer的分组
        DefaultMQProducer producer = new DefaultMQProducer("order");

        //设置nameserver地址，要带端口号
        producer.setNamesrvAddr("localhost:9876");

        producer.start();


        for (int i = 0;i<100;i++){
            //选择queue
            producer.send(new Message("o1", ("hi+"+i).getBytes()), new MessageQueueSelector() {
                /**
                 *
                 * @param list 存的是queue列表
                 * @param message 消息本体
                 * @param o，传入的arg
                 * @return
                 */
                @Override
                public MessageQueue select(List<MessageQueue> list, Message message, Object o) {
                    return list.get(0);
                }
            },"1",1000);
        }


        /**
         * 还有其他selector，但是无法做到定点投放，需要自定义一个selector才可以
         */
//        producer.send(new Message("o1", "hi".getBytes()), new SelectMessageQueueByHash(),"1",1000);
//        producer.send(new Message("o1", "hi".getBytes()), new SelectMessageQueueByMachineRoom(),"1",1000);
//        producer.send(new Message("o1", "hi".getBytes()), new SelectMessageQueueByRandom(),"1",1000);
    }
}
