package gc;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * jvm参数x
 * -Xms200M -Xmx200M -XX:+PrintGC
 */
public class Main {

    private static ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(
            50,new ThreadPoolExecutor.DiscardOldestPolicy()
    );

    public static void main(String[] args) throws InterruptedException {
        executor.setMaximumPoolSize(50);
        for (;;){
            modelFit();
            Thread.sleep(100);
        }
    }

    private static  void  modelFit(){
        List<CardInfo> list = getAllCardInfo();
        list.forEach(cardInfo -> {
            executor.scheduleWithFixedDelay(()->{
                cardInfo.m();
            },2,3, TimeUnit.SECONDS);
        });
    }
    private static  List<CardInfo> getAllCardInfo(){
        List<CardInfo> list = new ArrayList<>();
        for (int i = 0;i<5;i++){
            list.add(new CardInfo());
        }
        return list;
    }
}

class CardInfo{
    BigDecimal price = new BigDecimal(0.0);
    String name = "张三";
    int age = 5;
    Date b = new Date();

    public void  m(){};
}