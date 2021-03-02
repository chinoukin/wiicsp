package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * @Author jirg
 * @Date 2019/3/22 15:40
 * @Description 基地信息
 **/
public class OriBreedBaseInfo extends DataLongEntity<OriBreedBaseInfo> {
    /**
     * 会员id
     */
    private Long membId;

    /**
     * 主体名称
     */
    private String mainName;

    /**
     * logo
     */
    private String logoUrl;

    /**
     * 企业类型
     */
    private String entpType;

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

    /**
     * 简介
     */
    private String content;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getMainName() {
        return mainName;
    }

    public void setMainName(String mainName) {
        this.mainName = mainName;
    }

    public String getLogoUrl() {
        return logoUrl;
    }

    public void setLogoUrl(String logoUrl) {
        this.logoUrl = logoUrl;
    }

    public String getEntpType() {
        return entpType;
    }

    public void setEntpType(String entpType) {
        this.entpType = entpType;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
