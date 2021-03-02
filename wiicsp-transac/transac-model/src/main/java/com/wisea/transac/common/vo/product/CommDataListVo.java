package com.wisea.transac.common.vo.product;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * @author wangs
 */
public class CommDataListVo {

    /**
     * 商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品id")
    private Long id;

    /**
     * 商品编号
     */
    @ApiModelProperty(value = "商品编号")
    private String commNum;

    /**
     * 商品货号
     */
    @ApiModelProperty(value = "商品货号")
    private String commArtNum;

    /**
     * 档口id
     */
    @ApiModelProperty("档口id")
    private Long stallsMageId;

    /**
     * 档口名称
     */
    @ApiModelProperty("档口名称")
    private String stallsName;

    /**
     * 基地名称
     */
    @ApiModelProperty("基地名称")
    private String baseName;

    /**
     * 商品名称
     */
    @ApiModelProperty(value = "商品名称")
    private String commName;

    /**
     * 商家名称
     */
    @ApiModelProperty(value = "商家名称")
    private String entpName;

    /**
     * 商品状态类型
     */
    @ApiModelProperty(value = "商品状态类型")
    private String commStateType;

    /**
     * 商品分类
     */
    @ApiModelProperty(value = "商品分类")
    @JsonSerialize(using = IdSerializer.class)
    private Long commId;

    /**
     * 销售分类配置id
     */
    @ApiModelProperty("销售分类配置id")
    private Long commSaleSetId;

    /**
     * 销售分类配置名称
     */
    @ApiModelProperty("销售分类配置名称")
    private String commSaleSetName;

    /**
     * 销售分类名称
     */
    @ApiModelProperty("销售分类名称")
    private String catgName;
    /**
     * 价格区间
     */
    @ApiModelProperty(value = "价格区间")
    private String startOrdExpres;

    /**
     * 有效期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "更新时间")
    private OffsetDateTime updateDate;

    /**
     * 审核意见
     */
    @ApiModelProperty("审核意见")
    private String examYj;

    @ApiModelProperty("货品类型:0 非标件; 1 标价")
    private String goodsType;

    @ApiModelProperty("一件代发服务标志 : 0 是 ; 1 否")
    private String yjdfFlag;

    public String getGoodsType() {
        return goodsType;
    }

    public void setGoodsType(String goodsType) {
        this.goodsType = goodsType;
    }

    public String getYjdfFlag() {
        return yjdfFlag;
    }

    public void setYjdfFlag(String yjdfFlag) {
        this.yjdfFlag = yjdfFlag;
    }

    public String getBaseName() {
        return baseName;
    }

    public void setBaseName(String baseName) {
        this.baseName = baseName;
    }

    public String getExamYj() {
        return examYj;
    }

    public void setExamYj(String examYj) {
        this.examYj = examYj;
    }

    public String getStartOrdExpres() {
        return startOrdExpres;
    }

    public void setStartOrdExpres(String startOrdExpres) {
        this.startOrdExpres = startOrdExpres;
    }

    public OffsetDateTime getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(OffsetDateTime updateDate) {
        this.updateDate = updateDate;
    }

    public Long getCommId() {
        return commId;
    }

    public void setCommId(Long commId) {
        this.commId = commId;
    }

    public Long getCommSaleSetId() {
        return commSaleSetId;
    }

    public void setCommSaleSetId(Long commSaleSetId) {
        this.commSaleSetId = commSaleSetId;
    }

    public String getCommSaleSetName() {
        return commSaleSetName;
    }

    public void setCommSaleSetName(String commSaleSetName) {
        this.commSaleSetName = commSaleSetName;
    }

    public String getCatgName() {
        return catgName;
    }

    public void setCatgName(String catgName) {
        this.catgName = catgName;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public Long getStallsMageId() {
        return stallsMageId;
    }

    public void setStallsMageId(Long stallsMageId) {
        this.stallsMageId = stallsMageId;
    }

    public String getStallsName() {
        return stallsName;
    }

    public void setStallsName(String stallsName) {
        this.stallsName = stallsName;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getEntpName() {
        return entpName;
    }

    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

}
