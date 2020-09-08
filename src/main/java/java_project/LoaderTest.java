package java_project;

/**
 * 证明，遇到了，才加载
 * 加载时，会执行双亲委派模型
 */
public class LoaderTest {
    public static Kafka kafka;
    public static void main(String[] arg) throws InterruptedException {
        System.out.println("sleep");
        Thread.sleep(1000);
        System.out.println("await to load kafka");
        Kafka kafka = new Kafka();
        System.out.println("loading over");
    }
}


class Kafka{
    static {
        System.out.println("kafka:i am loading");
    }
}
