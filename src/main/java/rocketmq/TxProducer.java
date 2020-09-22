package rocketmq;

import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;

/**
 * 事务消息
 */
public class TxProducer {

    public static void main(String[] args) throws MQClientException {
        TransactionMQProducer producer = new TransactionMQProducer("tx");

        producer.setNamesrvAddr("localhost:9876");

        producer.setTransactionListener(new TransactionListener() {
            int succ = 0;

            @Override
            public LocalTransactionState executeLocalTransaction(Message message, Object o) {
                //0正在执行，1执行成功，2执行失败
                //这里执行local事务，这里的方法同步执行
                System.out.println("----- execute-------");
                System.out.println("msgID: "+message.getTransactionId());
                System.out.println("msg: "+new String(message.getBody()));

                succ = 1;

                if (succ == 1){
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else{
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }
            }

            @Override
            public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
                System.out.println("被回调了");
                //broker回调检查事务执行状况
                if (succ == 1){
                    //执行成功
                    return LocalTransactionState.COMMIT_MESSAGE;
                }else if (succ==2){
                    //执行失败，需要回滚
                    return LocalTransactionState.ROLLBACK_MESSAGE;
                }else {
                    //正在执行，请继续等待
                    return LocalTransactionState.UNKNOW;
                }
            }
        });
        producer.start();

        TransactionSendResult sendResult = producer.sendMessageInTransaction(new Message("topicA","tx msg".getBytes()),null);

        System.out.println("发送后回执："+sendResult.toString());
    }

}
