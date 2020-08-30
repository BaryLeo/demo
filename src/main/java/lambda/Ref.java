package lambda;

public class Ref {

    public Ref() {
    }

    public Ref(String s) {
        System.out.println("构造方法: "+s);
    }

    public String get(String s){
        System.out.println("有参方法函数 "+s);
        return "有参方法函数"+s;
    }

    public String get(){
        System.out.println("无参方法函数");
        return "无参方法函数";
    }

}
