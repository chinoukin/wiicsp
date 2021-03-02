package com.wisea.cultivar.common.vo.tp.trade;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单列表的订单商品
 */
@ApiModel("订单商品")
public class BuyerOrdCommRela {

	@ApiModelProperty("订单id")
    private Long ordId;

	@ApiModelProperty("数量")
    private Integer count;

	@ApiModelProperty("可退数量")
    private Integer subCount;

	@ApiModelProperty("单价（代理价就是结算价）")
    private Double price;

	@ApiModelProperty("商品名称")
    private String commName;

	@ApiModelProperty("商品规格")
    private Double commSpec;

	@ApiModelProperty("计量单位名称")
	private String measUnitName;

	@ApiModelProperty("订单商品id")
    private Long ordCommId;

	@ApiModelProperty("商品发布id")
    private Long commPubId;

	@ApiModelProperty("批发价")
    private Double wholePrice;

	@ApiModelProperty("商品货号")
	private String commArtNum;

	@ApiModelProperty("商品等级")
	private String commLevelType;
    /**
     * 商品图片
     */
	@ApiModelProperty("商品图片")
    private String commUrl;

    public String getCommArtNum() {
		return commArtNum;
	}

	public void setCommArtNum(String commArtNum) {
		this.commArtNum = commArtNum;
	}

	public String getCommLevelType() {
		return commLevelType;
	}

	public void setCommLevelType(String commLevelType) {
		this.commLevelType = commLevelType;
	}

	public Long getOrdCommId() {
		return ordCommId;
	}

	public void setOrdCommId(Long ordCommId) {
		this.ordCommId = ordCommId;
	}

	public String getMeasUnitName() {
		return measUnitName;
	}

	public void setMeasUnitName(String measUnitName) {
		this.measUnitName = measUnitName;
	}

	public Integer getSubCount() {
		return subCount;
	}

	public void setSubCount(Integer subCount) {
		this.subCount = subCount;
	}

	/**
     * 获取订单id
     */
    public Long getOrdId() {
        return ordId;
    }

    /**
     * 设置订单id
     */
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    /**
     * 获取数量
     */
    public Integer getCount() {
        return count;
    }

    /**
     * 设置数量
     */
    public void setCount(Integer count) {
        this.count = count;
    }

    /**
     * 获取单价（代理价就是结算价）
     */
    public Double getPrice() {
        return price;
    }

    /**
     * 设置单价（代理价就是结算价）
     */
    public void setPrice(Double price) {
        this.price = price;
    }

    /**
     * 获取商品名称
     */
    public String getCommName() {
        return commName;
    }

    /**
     * 设置商品名称
     */
    public void setCommName(String commName) {
        this.commName = commName == null ? null : commName.trim();
    }

    /**
     * 获取商品规格
     */
    public Double getCommSpec() {
        return commSpec;
    }

    /**
     * 设置商品规格
     */
    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    /**
     * 获取批发价
     */
    public Double getWholePrice() {
        return wholePrice;
    }

    /**
     * 设置批发价
     */
    public void setWholePrice(Double wholePrice) {
        this.wholePrice = wholePrice;
    }

    /**
     * 获取商品图片
     */
    public String getCommUrl() {
        return commUrl;
    }

    /**
     * 设置商品图片
     */
    public void setCommUrl(String commUrl) {
        this.commUrl = commUrl == null ? null : commUrl.trim();
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
}
