package multi_threading;

import java.util.concurrent.locks.Lock;

public class RW {
    private static int num = 1;

    public void read(Lock lock){
        try {
            lock.lock();
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getId()+" read："+num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public void write(Lock lock,int value){
        try {
            lock.lock();
            Thread.sleep(1000);
            num = value;
            System.out.println(Thread.currentThread().getId()+" write："+num);
        }catch (InterruptedException e){
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }
}
