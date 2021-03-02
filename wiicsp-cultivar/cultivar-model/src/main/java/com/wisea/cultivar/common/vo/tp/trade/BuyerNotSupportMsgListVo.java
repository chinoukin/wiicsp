package com.wisea.cultivar.common.vo.tp.trade;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 进货单的商品列表信息
 */
@ApiModel("进货单的商品列表信息")
public class BuyerNotSupportMsgListVo {

	@ApiModelProperty("商品名称")
    private String commName;

	@ApiModelProperty("图片地址")
	private String url;

	@ApiModelProperty("主键ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long id;

	@ApiModelProperty("进货单ID")
	@JsonSerialize(using = IdSerializer.class)
	private Long importBillId;

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getImportBillId() {
		return importBillId;
	}

	public void setImportBillId(Long importBillId) {
		this.importBillId = importBillId;
	}
}

