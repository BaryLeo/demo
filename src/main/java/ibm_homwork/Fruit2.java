package ibm_homwork;

public class Fruit2 {

    public static void main(String[] args) {
        Fruit2 p = new Fruit2(1,"p",12d);
        Fruit2 c = new Fruit2(2,"c",14d);

        System.out.println(p);
        System.out.println(c);
    }

    int id;
    String name;
    double price;

    public Fruit2() {
    }

    public Fruit2(int id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Fruit2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}

