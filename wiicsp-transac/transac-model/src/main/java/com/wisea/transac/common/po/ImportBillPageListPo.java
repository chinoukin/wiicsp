package com.wisea.transac.common.po;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.ImportBillPageListVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

@ApiModel("分页查询Po")
public class ImportBillPageListPo extends PagePo<ImportBillPageListVo> {
    @ApiModelProperty(value="id")
    private Long id;

    @ApiModelProperty(value="会员id")
    private Long membId;

    @ApiModelProperty(value="采购员工id")
    private Long purchaseStaffId;

    @ApiModelProperty(value="卖方ID")
    private Long sellerId;

    @ApiModelProperty(value="商品发布id")
    private Long commPubId;

    @ApiModelProperty(value="数量")
    private Integer count;

    @ApiModelProperty(value="商品规格")
    private Double commSpec;

    @ApiModelProperty(value="价格表达式")
    private String price;

    @ApiModelProperty(value="加入时间")
    private OffsetDateTime joinTime;

    @ApiModelProperty(value="等级规格报价id")
    private Long levelSpecQuoteId;

    @ApiModelProperty(value="等级规格版本号")
    private String levelSpecQuoteVersionNum;

    @ApiModelProperty(value="商品版本号")
    private String commVersionNum;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMembId() {
        return membId;
    }

    public void setMembId(Long membId) {
        this.membId = membId;
    }

    public Long getPurchaseStaffId() {
        return purchaseStaffId;
    }

    public void setPurchaseStaffId(Long purchaseStaffId) {
        this.purchaseStaffId = purchaseStaffId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Double getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public OffsetDateTime getJoinTime() {
        return joinTime;
    }

    public void setJoinTime(OffsetDateTime joinTime) {
        this.joinTime = joinTime;
    }

    public Long getLevelSpecQuoteId() {
        return levelSpecQuoteId;
    }

    public void setLevelSpecQuoteId(Long levelSpecQuoteId) {
        this.levelSpecQuoteId = levelSpecQuoteId;
    }

    public String getLevelSpecQuoteVersionNum() {
        return levelSpecQuoteVersionNum;
    }

    public void setLevelSpecQuoteVersionNum(String levelSpecQuoteVersionNum) {
        this.levelSpecQuoteVersionNum = levelSpecQuoteVersionNum;
    }

    public String getCommVersionNum() {
        return commVersionNum;
    }

    public void setCommVersionNum(String commVersionNum) {
        this.commVersionNum = commVersionNum;
    }
}
