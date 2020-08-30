package design.singleton;

/**
 * 静态内部类方式
 * JVM保证单例
 * 加载外部类的时候不会加载内部类
 * 线程安全，实现懒加载。效率高
 *
 */
public class SingletonF {
    //依旧私有化构造器
    private SingletonF(){};

    //当外部类加载的时候，内部类是不会加载的
    //只有在第一次调用内部类的时候，内部类才会加载
    private static class SingletonHolder{
        private final static SingletonF INSTANCE = new SingletonF();
    }

    public static SingletonF getInstance(){
        return SingletonHolder.INSTANCE;
    }
}
