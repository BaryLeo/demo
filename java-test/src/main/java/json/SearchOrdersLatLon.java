package json;

/**
 * @author gang.su
 */
public class SearchOrdersLatLon {

    private Double lat;

    private Double lon;

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLon() {
        return lon;
    }

    public void setLon(Double lon) {
        this.lon = lon;
    }

    @Override
    public String toString() {
        return "LatLonPojo{" +
                "lat=" + lat +
                ", lon=" + lon +
                '}';
    }
}