package java_project;

/**
 * 输出
 * Redis-B：i am created !
 * Redis-A：null
 * Redis-B：java_project.Redis@6d6f6e28
 * Redis-C：i am created !
 */
public class CreateObjTest {
    public static Redis redis_a;

    public static Redis redis_b = new Redis("Redis-B");

    public Redis redis_c = new Redis("Redis-C");

    static {
        System.out.println("Redis-A："+redis_a);
        System.out.println("Redis-B："+redis_b);
    }

    public static void main(String[] arg) throws InterruptedException {
        CreateObjTest createObjTest = new CreateObjTest();
    }
}

class Redis{
    public Redis(String a){
        System.out.println(a+"：i am created !");
    }
}