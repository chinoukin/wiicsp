package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 五彩布衣-资讯详细信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年9月2日
 * @version 1.0
 */
@ApiModel("五彩布衣-资讯详细信息PO")
public class ZxlListGetDetailPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "详细id")
	@Check(test="required")
    private Long id;

    @ApiModelProperty(value = "所属分类(zx_catg_type 0:布依文化1:生态旅游2:糯米蕉产业资讯)")
    private String zxCatgType;

	@ApiModelProperty(value = "行数",hidden=true)
	private int rowNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}

	public String getZxCatgType() {
		return zxCatgType;
	}

	public void setZxCatgType(String zxCatgType) {
		this.zxCatgType = zxCatgType;
	}
}
