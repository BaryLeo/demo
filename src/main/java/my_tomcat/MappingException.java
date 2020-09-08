package my_tomcat;

public class MappingException extends Exception{
    public MappingException (){};

    public MappingException (String msg){
        super(msg);
    }
}
