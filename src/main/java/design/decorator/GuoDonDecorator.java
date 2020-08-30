package design.decorator;

public class GuoDonDecorator implements Tea{
    //持有被装饰者
    private Tea tea;

    private int price = 1;

    private String name = "果冻";

    public GuoDonDecorator(Tea tea) {
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
