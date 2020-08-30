package multi_threading;

import java.util.concurrent.Phaser;

public class Person implements Runnable {
    String name;

    Phaser phaser;

    public Person(String name, Phaser phaser) {
        this.name = name;
        this.phaser = phaser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void arrive(){
        try {
            Thread.sleep(100);
            System.out.println(name+"到达现场");
            //注册并等待
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void eat(){
        try {
            Thread.sleep(100);
            System.out.println(name+"吃完了");
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void leave(){
        try {
            Thread.sleep(100);
            System.out.println(name+"离开了");
            phaser.arriveAndAwaitAdvance();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void hug(){
        try {
            if (name.equals("新郎")||name.equals("新娘")){
                Thread.sleep(100);
                System.out.println(name+"洞房");
                phaser.arriveAndAwaitAdvance();
            }else {
                //这里将会把触发限定-1
                phaser.arriveAndDeregister();
            }

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        arrive();
        eat();
        leave();
        hug();
    }
}
