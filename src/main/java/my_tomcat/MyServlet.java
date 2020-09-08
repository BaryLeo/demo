package my_tomcat;

public class MyServlet extends MyHttpServlet {
    @Override
    public void doGet(MyRequest request, MyResponse response) throws Exception{
        response.write("leo : hello get");
    }

    @Override
    public void doPost(MyRequest request, MyResponse response) throws Exception{
        response.write("leo : hello post");
    }
}
