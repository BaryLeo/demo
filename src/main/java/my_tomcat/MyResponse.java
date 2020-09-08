package my_tomcat;

import java.io.IOException;
import java.io.OutputStream;

public class MyResponse {
    private OutputStream outputStream;

    public MyResponse(OutputStream outputStream) {
        this.outputStream = outputStream;
    }

    public void  write(String content) throws IOException {
        StringBuilder builder = new StringBuilder();

        //建立HTTP报文
        builder.append("HTTP/1.1 200 OK\n")
                .append("Content-Type:test/html\n")
                .append("\r\n")
                .append("<html>")
                .append("<body>")
                .append("<h1>"+content+"</h1>")
                .append("<body>")
                .append("<html>");

        this.outputStream.write(builder.toString().getBytes());
        this.outputStream.flush();
        this.outputStream.close();
    }
}
