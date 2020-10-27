package my_tomcat;

public abstract class MyHttpServlet {

    public static final String METHOD_GET = "GET";

    public static final String METHOD_POST = "POST";

    public abstract void doGet(MyRequest request,MyResponse response)throws Exception;

    public abstract void doPost(MyRequest request,MyResponse response)throws Exception;

    /**
     * 根据请求方式来判断需要调用哪种处理方法
     */
    public void service(MyRequest request,MyResponse response) throws Exception{
        switch (request.getMethod()){
            case METHOD_GET:{
                doGet(request,response);
                break;
            }
            case METHOD_POST:{
                doPost(request,response);
                break;
            }
            default:{
                throw new MethodNoFoundException("不存在方法"+request.getMethod());
            }
        }
    }
}
