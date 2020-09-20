package ibm_homwork;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MyThreadPool {
    Executor executor = new ThreadPoolExecutor(
            10,
            20,
            20,
            TimeUnit.SECONDS,
            new ArrayBlockingQueue<Runnable>(200),
            new ThreadPoolExecutor.AbortPolicy()
    );
}
