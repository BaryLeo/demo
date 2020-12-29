package json;

/**
 * @Description
 * @Author jettyk.kuang
 * @Date: Created in 14:36 2020-06-24
 * @Modified By:
 */
public class SearchOrdersAddrInfo {

    private SearchOrdersLatLon latLon;

    private String name;

    private String address;

    private Integer cityId;

    private String district;

    private String houseNumber;

    private String contactsName;

    private String contactsPhoneNo;

    private Integer distanceType;

    private String addrSource;

    private Integer isRequestRec;

    private String actionType;

    public SearchOrdersLatLon getLatLon() {
        return latLon;
    }

    public void setLatLon(SearchOrdersLatLon latLon) {
        this.latLon = latLon;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    public String getContactsName() {
        return contactsName;
    }

    public void setContactsName(String contactsName) {
        this.contactsName = contactsName;
    }

    public String getContactsPhoneNo() {
        return contactsPhoneNo;
    }

    public void setContactsPhoneNo(String contactsPhoneNo) {
        this.contactsPhoneNo = contactsPhoneNo;
    }

    public Integer getDistanceType() {
        return distanceType;
    }

    public void setDistanceType(Integer distanceType) {
        this.distanceType = distanceType;
    }

    public String getAddrSource() {
        return addrSource;
    }

    public void setAddrSource(String addrSource) {
        this.addrSource = addrSource;
    }

    public Integer getIsRequestRec() {
        return isRequestRec;
    }

    public void setIsRequestRec(Integer isRequestRec) {
        this.isRequestRec = isRequestRec;
    }

    public String getActionType() {
        return actionType;
    }

    public void setActionType(String actionType) {
        this.actionType = actionType;
    }

    @Override
    public String toString() {
        return "SearchOrdersAddrInfo{" +
                "latLon=" + latLon +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", cityId=" + cityId +
                ", district='" + district + '\'' +
                ", houseNumber='" + houseNumber + '\'' +
                ", contactsName='" + contactsName + '\'' +
                ", contactsPhoneNo='" + contactsPhoneNo + '\'' +
                ", distanceType=" + distanceType +
                ", addrSource='" + addrSource + '\'' +
                ", isRequestRec=" + isRequestRec +
                ", actionType='" + actionType + '\'' +
                '}';
    }
}
