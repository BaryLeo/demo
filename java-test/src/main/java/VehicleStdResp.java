import com.alibaba.fastjson.annotation.JSONField;

/**
 * @author gang.su
 */
public class VehicleStdResp {

    @JSONField(name = "id")
    private Integer id;

    @JSONField(name = "city_id")
    private Integer cityId;

    @JSONField(name = "order_vehicle_id")
    private Integer orderVehicleId;

    @JSONField(name = "name")
    private String name;

    @JSONField(name = "price_type")
    private Integer priceType;

    @JSONField(name = "active")
    private Integer active;

    @JSONField(name = "price_value_fen")
    private Integer priceValueFen;

    @JSONField(name = "driver_price_value_fen")
    private Integer driverPriceValueFen;

    @JSONField(name = "driver_price")
    private Integer driverPrice;

    //别名
    @JSONField(name = "price")
    private Integer price;

    //大小b合并增加字段
    /**
     * 创建时间
     */
    @JSONField(name = "create_time")
    private String createTime;
    /**
     * 修改时间
     */
    @JSONField(name = "modify_ts")
    private String modifyTs;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getOrderVehicleId() {
        return orderVehicleId;
    }

    public void setOrderVehicleId(Integer orderVehicleId) {
        this.orderVehicleId = orderVehicleId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPriceType() {
        return priceType;
    }

    public void setPriceType(Integer priceType) {
        this.priceType = priceType;
    }

    public Integer getActive() {
        return active;
    }

    public void setActive(Integer active) {
        this.active = active;
    }

    public Integer getPriceValueFen() {
        return priceValueFen;
    }

    public void setPriceValueFen(Integer priceValueFen) {
        this.priceValueFen = priceValueFen;
    }

    public Integer getDriverPriceValueFen() {
        return driverPriceValueFen;
    }

    public void setDriverPriceValueFen(Integer driverPriceValueFen) {
        this.driverPriceValueFen = driverPriceValueFen;
    }

    public Integer getDriverPrice() {
        return driverPrice;
    }

    public void setDriverPrice(Integer driverPrice) {
        this.driverPrice = driverPrice;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTs() {
        return modifyTs;
    }

    public void setModifyTs(String modifyTs) {
        this.modifyTs = modifyTs;
    }
}
