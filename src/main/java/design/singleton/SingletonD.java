package design.singleton;

/**
 * 懒汉式升级版的削弱版
 * 线程不安全，效率也会降低
 */
public class SingletonD {
    private static  SingletonD INSTANCE;

    //这是单例的保证，也是关键,保证该类的对象不会被其他类new出来,只能被自己的创建实例
    private SingletonD(){};

    public static SingletonD getInstance(){
        if (INSTANCE==null){
            //当同一时刻有很多个线程聚集在该锁前，就是很多线程都判断为null的时候，线程不安全
            //有一说一，这种方法很费资源
            synchronized (SingletonD.class){
                //判断为null的线程将会排队获取锁，排队new对象（线程不安全）
                INSTANCE = new SingletonD();
                //BB一句，浪费那么多资源居然线程不安全！！
            }
        }
        return INSTANCE;
    }
}
