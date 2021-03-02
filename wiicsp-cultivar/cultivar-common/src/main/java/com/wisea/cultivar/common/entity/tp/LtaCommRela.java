package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LtaCommRela extends DataLongEntity<LtaCommRela> {
    /**
     * 商品编号
     */
    private Long membId;

    /**
     * 商品编号
     */
    private String commNum;

    /**
     * 商品货号
     */
    private String commHh;

    /**
     * 商品图片url
     */
    private String commPicUrl;

    /**
     * 商品名称
     */
    private String commName;

    /**
     * 商品品牌(品牌管理表id)
     */
    private Long brandId;

    /**
     * 商品id
     */
    private Long commCatgId;

    /**
     * 品种id
     */
    private Long commVariId;

    /**
     * 等级
     */
    private String level;

    /**
     * 商品状态
     */
    private String ltaCommStateType;

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommHh() {
        return commHh;
    }

    public void setCommHh(String commHh) {
        this.commHh = commHh;
    }

    public String getCommPicUrl() {
        return commPicUrl;
    }

    public void setCommPicUrl(String commPicUrl) {
        this.commPicUrl = commPicUrl;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Long getBrandId() {
        return brandId;
    }

    public void setBrandId(Long brandId) {
        this.brandId = brandId;
    }

    public Long getCommCatgId() {
        return commCatgId;
    }

    public void setCommCatgId(Long commCatgId) {
        this.commCatgId = commCatgId;
    }

    public Long getCommVariId() {
        return commVariId;
    }

    public void setCommVariId(Long commVariId) {
        this.commVariId = commVariId;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLtaCommStateType() {
        return ltaCommStateType;
    }

    public void setLtaCommStateType(String ltaCommStateType) {
        this.ltaCommStateType = ltaCommStateType;
    }
}
