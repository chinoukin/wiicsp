package com.wisea.equipment.entity.influx;

import com.wisea.cloud.influxdb.entity.InfluxBaseEntity;
import org.influxdb.annotation.Column;
import org.influxdb.annotation.Measurement;

/**
 * @author jirg
 * @version 1.0
 * @className XaircraftDataPoint
 * @date 2020/7/9 12:00
 * @Description 物联网 - 设备气象数据 - 时序数据实体类
 */
@Measurement(name = "meteorology_table")
public class MeteorologyInflux extends InfluxBaseEntity {
    //极飞气象数据字段
    @Column(name = "temperature")
    private Double temperature; //空气温度
    @Column(name = "humidity")
    private Double humidity; //空气湿度
    @Column(name = "pressure")
    private Double pressure; //大气压力
    @Column(name = "illumination")
    private Double illumination; //光照强度
    @Column(name = "rainfall")
    private Double rainfall; //历史降雨总量
    @Column(name = "wind_speed")
    private Double wind_speed; //风速
    @Column(name = "wind_direction")
    private Double wind_direction; //风向
    @Column(name = "battery")
    private Integer battery; //电量
    //以下为极飞图片数据字段
    @Column(name = "image")
    private String image; //图片URL
    @Column(name = "height")
    private Integer height; //图片高度
    @Column(name = "width")
    private Integer width; //图片宽度
    //以下为极飞图片数据字段
    @Column(name = "image_width")
    private Integer image_width; //封面图片高度
    @Column(name = "image_height")
    private Integer image_height; //封面图片宽度
    @Column(name = "video")
    private String video; //全天时景URL（前一天的合成视频地址）
    @Column(name = "video_width")
    private Integer video_width; //视频高度
    @Column(name = "video_height")
    private Integer video_height; //视频宽度

    public Double getTemperature() {
        return temperature;
    }

    public void setTemperature(Double temperature) {
        this.temperature = temperature;
    }

    public Double getHumidity() {
        return humidity;
    }

    public void setHumidity(Double humidity) {
        this.humidity = humidity;
    }

    public Double getPressure() {
        return pressure;
    }

    public void setPressure(Double pressure) {
        this.pressure = pressure;
    }

    public Double getIllumination() {
        return illumination;
    }

    public void setIllumination(Double illumination) {
        this.illumination = illumination;
    }

    public Double getRainfall() {
        return rainfall;
    }

    public void setRainfall(Double rainfall) {
        this.rainfall = rainfall;
    }

    public Double getWind_speed() {
        return wind_speed;
    }

    public void setWind_speed(Double wind_speed) {
        this.wind_speed = wind_speed;
    }

    public Double getWind_direction() {
        return wind_direction;
    }

    public void setWind_direction(Double wind_direction) {
        this.wind_direction = wind_direction;
    }

    public Integer getBattery() {
        return battery;
    }

    public void setBattery(Integer battery) {
        this.battery = battery;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public Integer getHeight() {
        return height;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public Integer getWidth() {
        return width;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public Integer getImage_width() {
        return image_width;
    }

    public void setImage_width(Integer image_width) {
        this.image_width = image_width;
    }

    public Integer getImage_height() {
        return image_height;
    }

    public void setImage_height(Integer image_height) {
        this.image_height = image_height;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public Integer getVideo_width() {
        return video_width;
    }

    public void setVideo_width(Integer video_width) {
        this.video_width = video_width;
    }

    public Integer getVideo_height() {
        return video_height;
    }

    public void setVideo_height(Integer video_height) {
        this.video_height = video_height;
    }
}
