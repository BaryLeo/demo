package design.decorator;

public class NaiCha implements Tea{
    private int price = 5;

    private String name = "奶茶";

    public void show(){
        System.out.println(name+" 价格:"+price+"元");
    }

    public int getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }
}
