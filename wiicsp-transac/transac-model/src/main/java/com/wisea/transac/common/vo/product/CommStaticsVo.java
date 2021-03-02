package com.wisea.transac.common.vo.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品销售情况vo
 * @author yangtao
 *
 */
@ApiModel("商品销售情况vo")
public class CommStaticsVo {

	@ApiModelProperty(value = "商品名称")
	private String commName;
	@ApiModelProperty(value = "商家")
	private String compName;
	@ApiModelProperty(value = "付款人数")
	private Integer personPayCount;
	@ApiModelProperty(value = "销售数量")
	private Double saleCount;
	@ApiModelProperty(value = "销售金额")
	private Double saleNum;
	public String getCommName() {
		return commName;
	}
	public void setCommName(String commName) {
		this.commName = commName;
	}
	public String getCompName() {
		return compName;
	}
	public void setCompName(String compName) {
		this.compName = compName;
	}
	public Double getSaleCount() {
		return saleCount;
	}
	public void setSaleCount(Double saleCount) {
		this.saleCount = saleCount;
	}
	public Double getSaleNum() {
		return saleNum;
	}
	public void setSaleNum(Double saleNum) {
		this.saleNum = saleNum;
	}

    public Integer getPersonPayCount() {
        return personPayCount;
    }

    public void setPersonPayCount(Integer personPayCount) {
        this.personPayCount = personPayCount;
    }
}
