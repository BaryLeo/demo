package design.singleton;

/**
 * 懒汉式升级版
 * 线程安全，但是效率会降低
 */
public class SingletonC {
    private static  SingletonC INSTANCE;

    //这是单例的保证，也是关键,保证该类的对象不会被其他类new出来,只能被自己的创建实例
    private SingletonC(){};

    //synchronized 加上该悲观锁，因为方法是static，该锁锁定的对象是Singleton类
    public static synchronized SingletonC getInstance(){
        //也不要妄想通过减小同步代码块的代码量来解决问题，没用
        //这样，就能在第一次调用getInstance时调用
        if (INSTANCE==null){
            INSTANCE = new SingletonC();
        }
        return INSTANCE;
    }
}
