package design.singleton;

public class SingletonH {
    private Context context;

    private static SingletonH instance;

    private SingletonH(Context context){
        this.context = context;
    }

    public static SingletonH getInstance(Context context){
        if (instance==null){
            synchronized (SingletonH.class){
                if (instance==null){
                    instance = new SingletonH(context);
                }
            }
        }

        return instance;
    }
}
