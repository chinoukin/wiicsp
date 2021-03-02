package com.wisea.cultivar.common.vo.tp;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import io.swagger.annotations.ApiModelProperty;

/**
 * CollFolderListVo
 * 2018/09/18 14:36:47
 */
public class CollFolderListVo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 会员id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "会员id")
    private Long membId;

    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    /**
     * 图片URL
     */
    @ApiModelProperty(value = "图片URL")
    private String pictureUrl;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 商品名称
     * */
    private String commName;

    /**
     * 商品编号
     * */
    private String commNum;

    /**
     * 普通价格显示区间
     * */
    private String wholePriceSection;

    /**
     * 代理价格显示区间
     * */
    private String agentWholePriceSection;

    /**
     * 销售量
     * */
    private String salesCount;


    /**
     * 最终的展示价格
     * */
    private String price;

    public String getPictureUrl() {
        return pictureUrl;
    }

    public void setPictureUrl(String pictureUrl) {
        this.pictureUrl = pictureUrl;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getWholePriceSection() {
        return wholePriceSection;
    }

    public void setWholePriceSection(String wholePriceSection) {
        this.wholePriceSection = wholePriceSection;
    }

    public String getAgentWholePriceSection() {
        return agentWholePriceSection;
    }

    public void setAgentWholePriceSection(String agentWholePriceSection) {
        this.agentWholePriceSection = agentWholePriceSection;
    }

    public String getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(String salesCount) {
        this.salesCount = salesCount;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取会员id
     */
    public Long getMembId() {
        return membId;
    }

    /**
     * 设置会员id
     */
    public void setMembId(Long membId) {
        this.membId = membId;
    }

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取商品状态类型
     */
    public String getCommStateType() {
        return commStateType;
    }

    /**
     * 设置商品状态类型
     */
    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType == null ? null : commStateType.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
