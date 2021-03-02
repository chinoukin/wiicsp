package com.wisea.cultivar.common.po.tp.memb;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cultivar.common.vo.tp.CommPubInfoGetVo;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 根据分类ID查询商品分页信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月13日
 * @version 1.0
 */
@ApiModel("根据分类ID查询商品分页信息PO")
public class ShopCommPageForIndexPo extends PagePo<CommPubInfoGetVo> {
    private static final long serialVersionUID = 1L;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "店铺id")
    @Check(test="required",requiredMsg="店铺ID不能为空")
    private Long shopInfoMageId;
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品分类id")
    private Long commId;
    @ApiModelProperty(value = "key")
    private String searchKey;
    @ApiModelProperty(value = "价格开始")
    private Double priceStar;
    @ApiModelProperty(value = "价格结束")
    private Double priceEnd;
    @ApiModelProperty(value = "排序的字段(0:销量1:发布时间2:价格)")
    private String orderBy;
    @ApiModelProperty(value = "正序:ASC 倒序:DESC")
    private String sortOrder;
    @ApiModelProperty(value = "分类ID列表",hidden=true)
    private List<Long> commIds;
	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Double getPriceStar() {
		return priceStar;
	}

	public void setPriceStar(Double priceStar) {
		this.priceStar = priceStar;
	}

	public Double getPriceEnd() {
		return priceEnd;
	}

	public void setPriceEnd(Double priceEnd) {
		this.priceEnd = priceEnd;
	}

	public String getOrderBy() {
		return orderBy;
	}

	public void setOrderBy(String orderBy) {
		this.orderBy = orderBy;
	}

	public String getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(String sortOrder) {
		this.sortOrder = sortOrder;
	}

	public Long getShopInfoMageId() {
		return shopInfoMageId;
	}

	public void setShopInfoMageId(Long shopInfoMageId) {
		this.shopInfoMageId = shopInfoMageId;
	}

	public List<Long> getCommIds() {
		return commIds;
	}

	public void setCommIds(List<Long> commIds) {
		this.commIds = commIds;
	}
}
