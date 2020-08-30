package design.singleton;

public class Context {
    public void test(){
        SingletonH singletonH = SingletonH.getInstance(this);
        //省略业务逻辑
    }
}
