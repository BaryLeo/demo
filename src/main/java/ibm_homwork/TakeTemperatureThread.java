package ibm_homwork;

import java.util.concurrent.locks.ReentrantLock;

public class TakeTemperatureThread extends Thread {

    private static AllStudent allStudent;

    private static ReentrantLock reentrantLock = new ReentrantLock();

    public TakeTemperatureThread(AllStudent allStudent) {
        this.allStudent = allStudent;
    }

    @Override
    public void run() {
        boolean loop = true;
        while (loop){
            reentrantLock.lock();
            try {
                int i =takeTemperature();
                if (i==0){
                    loop=false;
                }
            }finally {
                reentrantLock.unlock();
            }
        }


        System.out.println(Thread.currentThread().getName()+"完成测量");
    }

    public int takeTemperature(){
        Student student = null;
        student = allStudent.getStudent();
        if (student==null){
            return 0;
        }else {
            System.out.println(Thread.currentThread().getName()+"已为学生"+student.getId()+"测量体温");
            return 1;
        }

    }
}
