package com.wisea.cultivar.common.vo.tp.memb;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 商品列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月13日
 * @version 1.0
 */
@ApiModel("商品列表信息VO")
public class ShopCommSetupListVo {

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(店铺分类和商品关系表ID)")
    private Long id;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品分类id(店铺)")
    private Long commId;

    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    @ApiModelProperty(value = "商品名称")
    private String commName;

    @ApiModelProperty(value = "商品分类名称")
    private String shopCommMageName;

    @ApiModelProperty(value = "发布商品的分类ID")
    @JsonSerialize(using = IdSerializer.class)
    private Long commPubCommId;

    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    @ApiModelProperty(value = "备注")
    private String remarks;

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
     * 获取商品分类id
     */
    public Long getCommId() {
        return commId;
    }

    /**
     * 设置商品分类id
     */
    public void setCommId(Long commId) {
        this.commId = commId;
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
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
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

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getShopCommMageName() {
		return shopCommMageName;
	}

	public void setShopCommMageName(String shopCommMageName) {
		this.shopCommMageName = shopCommMageName;
	}

	public Long getCommPubCommId() {
		return commPubCommId;
	}

	public void setCommPubCommId(Long commPubCommId) {
		this.commPubCommId = commPubCommId;
	}
}
