package design.singleton;

/**
 * 懒汉式升级版的削弱版的加强版
 * 线程安全，效率降更低
 */
public class SingletonE {
    private static  SingletonE INSTANCE;

    //这是单例的保证，也是关键,保证该类的对象不会被其他类new出来,只能被自己的创建实例
    private SingletonE(){};

    public static SingletonE getInstance(){
        if (INSTANCE==null){
            //第一次判断是避免多次上锁的开销
            synchronized (SingletonE.class){
                //进来之后再判断一次（还是很浪费资源，以速度换内存）
               if (INSTANCE==null){
                   INSTANCE = new SingletonE();
               }
            }
        }
        return INSTANCE;
    }
}
