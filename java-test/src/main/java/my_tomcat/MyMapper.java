package my_tomcat;

import java.util.HashMap;

public class MyMapper {
    private static HashMap<String,String> mapping = new HashMap<>();

    static {
        //类映射是从main同级目录开始，classLoader原理
        mapping.put("/","my_tomcat.MyServlet");
    }

    public static HashMap<String, String> getMapping() {
        return mapping;
    }

}
