import org.springframework.util.ObjectUtils;
import sql.RelationalOperators;
import sql.SortMethod;
import sql.SqlCreateUtil;

import java.util.ArrayList;
import java.util.List;

public class MainTest {

    public static void main(String[] args) {
        List<Integer> city_id = new ArrayList<>();

        city_id.add(1);
        city_id.add(2);
        SqlCreateUtil sqlCreateUtil = new SqlCreateUtil();
        sqlCreateUtil.table("ucore_db_order")
                .fields("waiting_fee_fen,driver_id_history,order_display_id,ep_id,order_id,order_group,city_id,order_subset,order_status,address,order_vehicle_id,client_type,pickup_ts,order_snapshot,total_price_fen,tips_price_fen,name,tel,user_id,driver_id,remark,order_datetime,create_time,dashboard_status,latlong,invoice_status,rank_id,perquisite_price_fen,order_uuid,driver_amount_fen,order_type")
                .andCondition("order_vehicle_id", RelationalOperators.EQ,1)
                .orCondition("order_status",RelationalOperators.EQ,2)
                .andConditionNotIn("city_id",city_id)
                .orConditionIn("driver_id",city_id)
                .limit(1,5)
                .andLike("remark","heiehieh")
                .orderBy(SortMethod.DESC,"order_id");

        System.out.println(sqlCreateUtil.toString());

    }
}
