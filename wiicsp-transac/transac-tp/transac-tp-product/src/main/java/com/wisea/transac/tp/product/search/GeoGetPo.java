package com.wisea.transac.tp.product.search;

import com.wisea.transac.common.entity.BaseSearchPojo;
import io.swagger.annotations.ApiModelProperty;
import org.elasticsearch.common.geo.GeoPoint;

/**
 * @Description:
 * @author: wangs
 * @date :2020/4/7
 */
public class GeoGetPo extends BaseSearchPojo {

    @ApiModelProperty("批发市场id")
    private String id;
    @ApiModelProperty("批发市场详细地址")
    private String address;
    @ApiModelProperty("坐标点: lat 纬度; lon 经度;")
    private GeoPoint location1;
    @ApiModelProperty("有效距离")
    private Double tradeRange;
    @ApiModelProperty("图片路径")
    private String url;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Double getTradeRange() {
        return tradeRange;
    }

    public void setTradeRange(Double tradeRange) {
        this.tradeRange = tradeRange;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public GeoPoint getLocation1() {
        return location1;
    }

    public void setLocation1(GeoPoint location1) {
        this.location1 = location1;
    }
}
