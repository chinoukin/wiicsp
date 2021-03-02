package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单商品VO
 */
@ApiModel("订单商品VO")
public class OrderCommRelaVo {
	@ApiModelProperty("订单商品ID")
    private Long ordCommId;
    @ApiModelProperty("商品发布ID")
    private Long commPubId;
    @ApiModelProperty("商品名称")
    private String commName;
    @ApiModelProperty("商品货号")
    private String commArtNum;
    @ApiModelProperty("商品编号")
    private String commNum;
    @ApiModelProperty("购买数量")
    private Integer count;
    @ApiModelProperty("商品计量单位")
    private String measUnitName;
    @ApiModelProperty("商品规格")
    private Double commSpec;
    @ApiModelProperty("商品图片")
    private String commUrl;
    @ApiModelProperty("商品单价")
    private Double price;
    @ApiModelProperty("商品单价小计")
    private Double priceCount;
    @ApiModelProperty("商品结算价格小计")
    private Double settlePriceCount;
    @ApiModelProperty("平台服务费小计")
    private Double platfCostCount;
    @ApiModelProperty("验收标准表达式")
    private String ysbzBds;
    @ApiModelProperty("商品等级")
    private String commLevelType;
    @ApiModelProperty("商品品牌")
    private String brandName;
    @ApiModelProperty("是否可以退货（0是可以，1不可以）")
    private String refundFlag;

    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Long getOrdCommId() {
		return ordCommId;
	}

	public void setOrdCommId(Long ordCommId) {
		this.ordCommId = ordCommId;
	}

	public String getRefundFlag() {
		return refundFlag;
	}

	public void setRefundFlag(String refundFlag) {
		this.refundFlag = refundFlag;
	}

	public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommArtNum() {
        return commArtNum;
    }

    public void setCommArtNum(String commArtNum) {
        this.commArtNum = commArtNum;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getMeasUnitName() {
        return measUnitName;
    }

    public void setMeasUnitName(String measUnitName) {
        this.measUnitName = measUnitName;
    }

    public Double getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    public String getCommUrl() {
        return commUrl;
    }

    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPriceCount() {
        return priceCount;
    }

    public void setPriceCount(Double priceCount) {
        this.priceCount = priceCount;
    }

    public Double getSettlePriceCount() {
        return settlePriceCount;
    }

    public void setSettlePriceCount(Double settlePriceCount) {
        this.settlePriceCount = settlePriceCount;
    }

    public Double getPlatfCostCount() {
        return platfCostCount;
    }

    public void setPlatfCostCount(Double platfCostCount) {
        this.platfCostCount = platfCostCount;
    }

    public String getYsbzBds() {
        return ysbzBds;
    }

    public void setYsbzBds(String ysbzBds) {
        this.ysbzBds = ysbzBds;
    }

    public String getCommLevelType() {
        return commLevelType;
    }

    public void setCommLevelType(String commLevelType) {
        this.commLevelType = commLevelType;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }
}
