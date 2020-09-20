package ibm_homwork;

import java.util.ArrayList;

public class TakeTemperatureTest {
    public static void main(String[] args) throws InterruptedException {
        AllStudent allStudent = new AllStudent();
        ArrayList<TakeTemperatureThread> threads = new ArrayList<>();
        for (int i =0;i<5;i++){
            TakeTemperatureThread takeTemperatureThread = new TakeTemperatureThread(allStudent);
            takeTemperatureThread.setName("测试者"+i+"号");
            threads.add(takeTemperatureThread);
        }

        for (TakeTemperatureThread thread:threads){
            thread.start();
        }

        Thread.sleep(2000);
    }
}
