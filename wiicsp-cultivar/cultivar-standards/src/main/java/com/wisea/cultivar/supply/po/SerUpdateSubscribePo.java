package com.wisea.cultivar.supply.po;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改价格
 * @author chengq
 * @date 2020/8/15 18:45
 */
public class SerUpdateSubscribePo {

    @ApiModelProperty("服务单id")
    @Check(test = {"required" }, requiredMsg = "服务单id不能为空")
    private Long id;

    @ApiModelProperty("服务地区省")
    private String serAreaProv;

    @ApiModelProperty("服务地区市")
    private String serAreaCity;

    @ApiModelProperty("服务地区县")
    private String serAreaCou;

    @ApiModelProperty("服务地区省")
    private String serAreaProvId;

    @ApiModelProperty("服务地区市")
    private String serAreaCityId;

    @ApiModelProperty("服务地区县")
    private String serAreaCouId;

    @ApiModelProperty("服务地详细地址")
    private String serAreaAddress;

    @ApiModelProperty(value = "服务日期", example = "2020.08.16")
    @Check(test = {"required" }, requiredMsg = "服务日期不能为空")
    private String serDate;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSerAreaProv() {
        return serAreaProv;
    }

    public void setSerAreaProv(String serAreaProv) {
        this.serAreaProv = serAreaProv;
    }

    public String getSerAreaCity() {
        return serAreaCity;
    }

    public void setSerAreaCity(String serAreaCity) {
        this.serAreaCity = serAreaCity;
    }

    public String getSerAreaCou() {
        return serAreaCou;
    }

    public void setSerAreaCou(String serAreaCou) {
        this.serAreaCou = serAreaCou;
    }

    public String getSerAreaAddress() {
        return serAreaAddress;
    }

    public void setSerAreaAddress(String serAreaAddress) {
        this.serAreaAddress = serAreaAddress;
    }

    public String getSerDate() {
        return serDate;
    }

    public void setSerDate(String serDate) {
        this.serDate = serDate;
    }

    public String getSerAreaProvId() {
        return serAreaProvId;
    }

    public void setSerAreaProvId(String serAreaProvId) {
        this.serAreaProvId = serAreaProvId;
    }

    public String getSerAreaCityId() {
        return serAreaCityId;
    }

    public void setSerAreaCityId(String serAreaCityId) {
        this.serAreaCityId = serAreaCityId;
    }

    public String getSerAreaCouId() {
        return serAreaCouId;
    }

    public void setSerAreaCouId(String serAreaCouId) {
        this.serAreaCouId = serAreaCouId;
    }
}
