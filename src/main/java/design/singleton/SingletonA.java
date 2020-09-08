package design.singleton;

/**
 * 饿汉式
 * 类夹在到内存后，马上实例化一个单例，JVM保证线程安全
 * JVM保证线程安全，是因为，JVM会保证class指挥load到内存一次，而static变量在class loading的时候马上进行实例化，而构造器是私有的，所以能保证只初始化一次
 * 简单实用
 * 唯一缺点就是，不管用到与否，都会实例化（PS：一般能装载的，会不用嘛？不用的话，装载来干嘛）
 */
public class SingletonA {
    //该类自己持有一个对象，保持强引用
    private static final SingletonA INSTANCE = new SingletonA();

    //这是单例的保证，也是关键,保证该类的对象不会被其他类new出来
    private SingletonA(){};

    //获取类持有的实例
    public static SingletonA getInstance(){
        return INSTANCE;
    }

    //以下省略各种业务方法
}
