package com.wisea.transac.common.po;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/7/1 4:15 下午
 */
@ApiModel("口岸管理新增或修改Po")
public class PortMagePo {

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

    /**
     * 市
     */
    @ApiModelProperty("市")
    private String areaCity;

    /**
     * 区县
     */
    @ApiModelProperty("区县")
    private String areaCou;

    /**
     * 详细地址
     */
    @ApiModelProperty("详细地址")
    private String address;

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
