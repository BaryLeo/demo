package ibm_homwork;

import java.util.LinkedList;
import java.util.concurrent.locks.ReentrantLock;

public class AllStudent {
    private LinkedList<Student> students = new LinkedList<>();

    public AllStudent() {
        System.out.println("----- init students ------");
        for (int i = 0;i<100;i++){
            students.add(new Student(i));
        }
    }

    public Student getStudent(){
        if (students.isEmpty()){
            return null;
        }
        return students.pollFirst();
    }
}
