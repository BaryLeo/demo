package my_tomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

    public static void main(String[] args)throws Exception{
        StartServer(8888);
    }

    //用来启动my_tomcat
    public static void StartServer(int port) throws Exception{
        //开启服务套接字
        ServerSocket serverSocket = new ServerSocket(port);

        Socket client = null;

        while (true){
            client = serverSocket.accept();

            InputStream inputStream = client.getInputStream();

            OutputStream outputStream = client.getOutputStream();

            MyRequest request = new MyRequest(inputStream);

            MyResponse response = new MyResponse(outputStream);

            //目标class的全路径名
            String clazz = MyMapper.getMapping().get(request.getRequestUrl());

            //获取class反射对象
            if (clazz!=null){
                Class<MyServlet> myServletClass = (Class<MyServlet>)Class.forName(clazz);
                MyServlet myServlet = myServletClass.newInstance();
                myServlet.service(request,response);
            }else {
                throw new MappingException("mapping error");
            }
        }
    }
}
