package my_tomcat;

public class MethodNoFoundException extends Exception {

    public MethodNoFoundException(){};

    public MethodNoFoundException(String msg){
        super(msg);
    }
}
