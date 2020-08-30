package design.observer;

public class CryEvent extends Event<Child> {

    private Child source;

    public CryEvent(Child source) {
        this.source = source;
    }

    @Override
    Child getSource() {
        return source;
    }
}
