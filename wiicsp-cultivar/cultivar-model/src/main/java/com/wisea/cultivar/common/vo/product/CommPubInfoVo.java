package com.wisea.cultivar.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel("推荐企业信息")
public class CommPubInfoVo {

    @ApiModelProperty("商家名称")
    private String membName;
    @ApiModelProperty("商品标题")
    private String commName;
    @ApiModelProperty("商品id")
    private Long commPubInfoId;
    private Integer commPubCount;
    private Integer salesCount;

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public Integer getCommPubCount() {
        return commPubCount;
    }

    public void setCommPubCount(Integer commPubCount) {
        this.commPubCount = commPubCount;
    }

    public Integer getSalesCount() {
        return salesCount;
    }

    public void setSalesCount(Integer salesCount) {
        this.salesCount = salesCount;
    }

    public String getMembName() {
        return membName;
    }

    public void setMembName(String membName) {
        this.membName = membName;
    }

    public Long getCommPubInfoId() {
        return commPubInfoId;
    }

    public void setCommPubInfoId(Long commPubInfoId) {
        this.commPubInfoId = commPubInfoId;
    }
}
