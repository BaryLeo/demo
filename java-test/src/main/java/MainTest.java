
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import json.SearchOrdersAddrInfo;

import java.util.List;

public class MainTest {

    private static  Integer a;

    static long total = 1;
    static int size = 150;
    public static void main(String[] args) {
        Long pageNum = (long) Math.ceil((double) total / (double) size);

        System.out.println(pageNum);
    }
}
