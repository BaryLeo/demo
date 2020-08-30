package design.decorator;

public class BoBaNaiDecorator implements Tea{
    //持有被装饰者
    private Tea tea;

    private int price = 1;

    private String name = "波霸";

    public BoBaNaiDecorator(Tea tea) {
        this.tea = tea;
    }

    @Override
    public void show() {
        System.out.println(getName() + " 价格：" + getPrice());
    }

    @Override
    public int getPrice() {
        return price + tea.getPrice();
    }

    @Override
    public String getName() {
        return name+tea.getName();
    }
}
