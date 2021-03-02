package com.wisea.cultivar.common.vo.tp.retro;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 可申请追溯标签商品列表Vo
 */
@ApiModel("可申请追溯标签商品列表Vo")
public class RetroCommListVo {
    @ApiModelProperty("发布商品ID")
    private Long id;
    @ApiModelProperty("商品编号")
    private String commNum;
    @ApiModelProperty("商品货号")
    private String commArtNum;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品品牌")
    private String brandName;
    @ApiModelProperty("商品状态")
    private String commStateType;
    @ApiModelProperty("最后一次申请日期")
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    private OffsetDateTime lastApplyDate;
    @ApiModelProperty("已申请数量")
    private Integer applTotalCount;

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

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getCommStateType() {
        return commStateType;
    }

    public void setCommStateType(String commStateType) {
        this.commStateType = commStateType;
    }

    public OffsetDateTime getLastApplyDate() {
        return lastApplyDate;
    }

    public void setLastApplyDate(OffsetDateTime lastApplyDate) {
        this.lastApplyDate = lastApplyDate;
    }

    public Integer getApplTotalCount() {
        return applTotalCount;
    }

    public void setApplTotalCount(Integer applTotalCount) {
        this.applTotalCount = applTotalCount;
    }
}
