package design.strategy;

import java.util.Comparator;
import java.util.stream.Stream;

/**
 * 策略模式的思想，实现目的的方法可以有多种并且可以灵活指定
 */
public class StrategyDemo<T> {

    public static void main(String[] args) {
        Dog[] dogs = new Dog[]{new Dog(3),new Dog(5),new Dog(2)};
        new StrategyDemo<Dog>().sort(dogs,(o1,o2)->o1.weight-o2.weight);
    }

    public void sort(Comparable[] ar){
        for (int i=0;i<ar.length;i++){
            for (int x = i;x<ar.length;x++){
                if (ar[i].compareTo(ar[x])>0){
                    Comparable temp = ar[i];
                    ar[i]=ar[x];
                    ar[x]=temp;
                }
            }
        }
    }


    public void sort(T[] ar, Comparator<T> comparator){
        for (int i=0;i<ar.length;i++){
            for (int x = i;x<ar.length;x++){
                if (comparator.compare(ar[i],ar[x])>0){
                    T temp = ar[i];
                    ar[i]=ar[x];
                    ar[x]=temp;
                }
            }
        }

        Stream.of(ar).forEach(System.out::println);
    }
}
