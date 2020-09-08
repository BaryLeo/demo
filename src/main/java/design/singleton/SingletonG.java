package design.singleton;

/**
 * 枚举单例，最完美的单例
 * 解决线程以及效率问题，还能防止反序列化
 * Java规范中规定，每一个枚举类型极其定义的枚举变量在JVM中都是唯一的，因此在枚举类型的序列化和反序列化上，Java做了特殊的规定。
 * 在序列化的时候Java仅仅是将枚举对象的name属性输出到结果中，反序列化的时候则是通过 java.lang.Enum 的 valueOf() 方法来根据名字查找枚举对象。
 */
public class SingletonG {

    private SingletonG(){};

    //定义一个静态枚举类
    private static enum SingletonEnum{
        //创建一个枚举对象，该对象天生为单例
        INSTANCE;

        private SingletonG instance;
        //私有化枚举的构造函数
        private SingletonEnum(){
            instance = new SingletonG();
        }

        public SingletonG getInstance(){
            return instance;
        }
    }

    //对外暴露一个获取User对象的静态方法
    public static SingletonG getInstance(){
        return SingletonEnum.INSTANCE.getInstance();
    }
}
