package com.wisea.cultivar.common.po.tp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 运费信息传入参数
 * @author: wangs
 * @date :2018/9/30
 */
@ApiModel("运费信息传入参数")
public class FreightFormworkMagePo {

	@ApiModelProperty("商品id")
    private Long commpubId;
    @ApiModelProperty("地址code 只要省级code码")
    private String address;
    @ApiModelProperty("订单数")
    private Integer orderCount;
    @ApiModelProperty("规格")
    private Double commSpec;
    @ApiModelProperty("运费id")
    private Long freightFormworkId;
    @ApiModelProperty("总重量")
    private Double weight;

    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }

    public Long getCommpubId() {
		return commpubId;
	}

	public void setCommpubId(Long commpubId) {
		this.commpubId = commpubId;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getOrderCount() {
        return orderCount;
    }

    public void setOrderCount(Integer orderCount) {
        this.orderCount = orderCount;
    }

    public Double getCommSpec() {
        return commSpec;
    }

    public void setCommSpec(Double commSpec) {
        this.commSpec = commSpec;
    }

    public Long getFreightFormworkId() {
        return freightFormworkId;
    }

    public void setFreightFormworkId(Long freightFormworkId) {
        this.freightFormworkId = freightFormworkId;
    }
}
