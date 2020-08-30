package design.strategy;

/**
 * Comparable
 * 负值表示 当前对象比传入对象小
 * 0，相等
 * 正值，大
 */
public class Dog implements Comparable<Dog>{
    int weight;

    public Dog(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Dog o) {
        return weight-o.weight;
    }

    @Override
    public String toString() {
        return "Dog{" +
                "weight=" + weight +
                '}';
    }
}
