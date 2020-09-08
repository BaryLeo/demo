package design.observer;

import java.util.ArrayList;
import java.util.List;

public class Child {

    private List<Observer> observers = new ArrayList<>();

    public Child addObserver(Observer observer){
        observers.add(observer);
        return this;
    }

    public void wakeUp(){
        CryEvent cryEvent = new CryEvent(this);
        for (Observer observer:observers){
            observer.actionOnWakeUp(cryEvent);
        }
    }

}
