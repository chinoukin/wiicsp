package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:42
 * @Description 养殖场信息
 **/
public class OriFarmInfo extends DataLongEntity<OriFarmInfo> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 养殖场名称
     */
    private String farmName;

    /**
     * 规模
     */
    private Integer scale;

    /**
     * 联系人姓名
     */
    private String contactName;

    /**
     * 电话
     */
    private String tel;

    /**
     * 联系地区省
     */
    private String areaProv;

    /**
     * 联系地区市
     */
    private String areaCity;

    /**
     * 联系地区区县
     */
    private String areaCou;

    /**
     * 详细地址
     */
    private String address;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public Integer getScale() {
        return scale;
    }

    public void setScale(Integer scale) {
        this.scale = scale;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
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
