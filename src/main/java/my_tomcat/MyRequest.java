package my_tomcat;

import java.io.IOException;
import java.io.InputStream;

public class MyRequest {
    private String method;

    private String requestUrl;

    public MyRequest(InputStream inputStream) throws IOException {
        //建缓冲区
        byte[] buffer = new byte[1024];
        int len = 0;
        String str = null;

        //把流读进缓冲区
        if ((len=inputStream.read(buffer))>0){
            str = new String(buffer,0,len);
        }

        //下面就是拆解内容了
        String[] http = str.split("\n");
        String[] mapper = http[0].split(" ");
        method = mapper[0];
        requestUrl = mapper[1];
        System.out.println(str);
    }

    public String getMethod() {
        return method;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public String getRequestUrl() {
        return requestUrl;
    }

    public void setRequestUrl(String requestUrl) {
        this.requestUrl = requestUrl;
    }
}
