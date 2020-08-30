package design.singleton;

/**
 * 懒汉式
 * 按需初始化，但是线程不安全
 */
public class SingletonB {
    private static  SingletonB INSTANCE;

    //这是单例的保证，也是关键,保证该类的对象不会被其他类new出来,只能被自己的创建实例
    private SingletonB(){};

    public static SingletonB getInstance(){
        //这样，就能在第一次调用getInstance时调用
        if (INSTANCE==null){
            INSTANCE = new SingletonB();
        }
        return INSTANCE;
    }
}
