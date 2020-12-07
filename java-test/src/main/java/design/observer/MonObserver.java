package design.observer;

public class MonObserver implements Observer{
    @Override
    public void actionOnWakeUp(CryEvent event) {
        System.out.println("Mon：im coming");
    }
}
