package com.wisea.equipment.entity.xaircraft;

/**
 * @author jirg
 * @version 1.0
 * @className Location
 * @date 2019/2/25 13:55
 * @Description 极飞数据点位置信息
 */
public class XaircraftLocation {
    private Integer altitude; //海拔
    private Double latitude; //纬度
    private Double longitude; //经度
    private Integer precision; //定位精度

    public Integer getAltitude() {
        return altitude;
    }

    public void setAltitude(Integer altitude) {
        this.altitude = altitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Integer getPrecision() {
        return precision;
    }

    public void setPrecision(Integer precision) {
        this.precision = precision;
    }
}
