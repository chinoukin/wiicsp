package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class PortMage extends DataLongEntity<PortMage> {
    /**
     * 口岸名称
     */
    private String portName;

    /**
     * 省
     */
    private String areaProv;

    /**
     * 市
     */
    private String areaCity;

    /**
     * 区县
     */
    private String areaCou;

    /**
     * 详细地址
     */
    private String address;

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
