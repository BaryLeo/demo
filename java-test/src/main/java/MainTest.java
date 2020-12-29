
import com.alibaba.fastjson.JSONObject;
import json.SearchOrdersAddrInfo;

import java.util.List;

public class MainTest {

    private static  Integer a;

    public static void main(String[] args) {
        String json = "[{\"name\":\"深圳市人民政府\",\"address\":\"深圳市-福田区-福中三路市民中心C区\",\"city_id\":1002,\"district\":\"福田区\",\"house_number\":\"\",\"contacts_name\":\"\",\"contacts_phone_no\":\"\",\"distance_type\":0,\"addr_source\":\"\",\"is_request_rec\":null,\"action_type\":\"\"},{\"name\":\"深圳市人民政府\",\"address\":\"深圳市-福田区-福中三路市民中心C区\",\"city_id\":1002,\"district\":\"福田区\",\"house_number\":\"\",\"contacts_name\":\"\",\"contacts_phone_no\":\"\",\"distance_type\":0,\"addr_source\":\"\",\"is_request_rec\":null,\"action_type\":\"\"}]";
        List<SearchOrdersAddrInfo> searchOrdersAddrInfo = JSONObject.parseArray(json, SearchOrdersAddrInfo.class);
        System.out.println(searchOrdersAddrInfo);

        String latlon = "22.546240363137|114.05283878167,22.546240363137|114.05283878167";
        String[] latlonStr= latlon.split("\\|");
        System.out.println(latlonStr[0]);
        System.out.println(latlonStr[2]);
        StringBuilder stringBuilder = new StringBuilder("aaaabbbb");
        stringBuilder.delete(0,4);
        System.out.println(stringBuilder.toString());
    }
}
