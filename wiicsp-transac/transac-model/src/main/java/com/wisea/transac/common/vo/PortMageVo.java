package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/7/1 4:10 下午
 */
@ApiModel("口岸管理")
public class PortMageVo {

    @ApiModelProperty("口岸名称")
    private String label;
    @ApiModelProperty("id")
    private String value;

    @ApiModelProperty("id")
    private Long id;

    /**
     * 口岸名称
     */
    @ApiModelProperty("口岸名称")
    private String portName;

    /**
     * 省
     */
    @ApiModelProperty("省")
    private String areaProv;
    @ApiModelProperty("省名称")
    private String areaProvName;

    /**
     * 市
     */
    @ApiModelProperty("市")
    private String areaCity;
    @ApiModelProperty("市名称")
    private String areaCityName;

    /**
     * 区县
     */
    @ApiModelProperty("区县")
    private String areaCou;
    @ApiModelProperty("区县名称")
    private String areaCouName;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String address;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getAreaProvName() {
        return areaProvName;
    }

    public void setAreaProvName(String areaProvName) {
        this.areaProvName = areaProvName;
    }

    public String getAreaCityName() {
        return areaCityName;
    }

    public void setAreaCityName(String areaCityName) {
        this.areaCityName = areaCityName;
    }

    public String getAreaCouName() {
        return areaCouName;
    }

    public void setAreaCouName(String areaCouName) {
        this.areaCouName = areaCouName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPortName() {
        return portName;
    }

    public void setPortName(String portName) {
        this.portName = portName;
    }

    public String getAreaProv() {
        return areaProv;
    }

    public void setAreaProv(String areaProv) {
        this.areaProv = areaProv;
    }

    public String getAreaCity() {
        return areaCity;
    }

    public void setAreaCity(String areaCity) {
        this.areaCity = areaCity;
    }

    public String getAreaCou() {
        return areaCou;
    }

    public void setAreaCou(String areaCou) {
        this.areaCou = areaCou;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
