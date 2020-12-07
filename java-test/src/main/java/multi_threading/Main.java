package multi_threading;

import java.util.Random;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.*;

public class Main {
    static Random random = new Random();
    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        //两线程交替打印
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();
        char[] aI = "1234567".toCharArray();
        char[] aC = "ABCDEFG".toCharArray();

        Thread t1 = new Thread(()->{
            try {
                //需要获得锁才可以使用condition
                reentrantLock.lock();
                for (char c:aI){
                    System.out.println(c);
                    //唤醒等待队列中的一个线程,队列是FIFO的，唤醒的队列由于没有锁，是阻塞的
                    condition.signal();
                    //将当前线程加入等待队列,并且会释放锁，唤醒的队列获取了锁，才开始执行
                    condition.await();
                }
                //结束后唤醒其他队列，自身退出
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }
        });

        Thread t2 = new Thread(()->{
            try {
                reentrantLock.lock();
                for (char c:aC){
                    System.out.println(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                reentrantLock.unlock();
            }

        });

        t1.start();
        t2.start();

        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testPhaser(){
        MarriagePhaser marriagePhaser = new MarriagePhaser();
        //限定多少人才可以下一阶段
        marriagePhaser.bulkRegister(7);

        for (int i=0;i<5;i++){
            new Thread(new Person("p"+i,marriagePhaser)).start();
        }
        new Thread(new Person("新郎",marriagePhaser)).start();
        new Thread(new Person("新娘",marriagePhaser)).start();
    }

    public static void testBarrier(){
        Thread[] threads = new Thread[20];
        CyclicBarrier cyclicBarrier = new CyclicBarrier(5, ()->System.out.println("人满发车"));

        for (int i =0;i<threads.length;i++){
             new Thread(()->{
                 try {
                     System.out.println(Thread.currentThread().getName()+"来到门前等待其他线程完成");
                     //设置栅栏
                     cyclicBarrier.await();
                 }catch (Exception e){
                     e.printStackTrace();
                 }
            }).start();
        }

    }
    public static void testLatch(){
        Thread[] threads = new Thread[6];
        CountDownLatch countDownLatch = new CountDownLatch(threads.length);

        for (int i =0;i<threads.length;i++){
            threads[i] = new Thread(()->{
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"任务完成");
                countDownLatch.countDown();
            });
        }

        for (int i =0;i<threads.length;i++){

            threads[i].start();
        }

        try {
            System.out.println(Thread.currentThread().getName()+"来到门前等待其他线程完成");
            countDownLatch.await();
        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("门栓已释放");
    }

    public void testJoin(){
        Thread t1 = new Thread(()->{
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------t1--------");
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("----------t2--------");
        });
        t1.start();
        t2.start();
    }
}
