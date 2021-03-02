package com.wisea.cultivar.common.po.tp.portal;

import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 首页查询详细资讯信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("首页查询详细资讯信息的PO")
public class InfomationMageNotAuthPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "详细id")
	@Check(test="required")
    private Long id;

	@ApiModelProperty(value="所属分类(0:平台公告1:行业资讯2:果链动态3:价格行情)")
	private List<String> informationTypes;

	@ApiModelProperty(value = "行数",hidden=true)
	private int rowNum;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<String> getInformationTypes() {
		return informationTypes;
	}

	public void setInformationTypes(List<String> informationTypes) {
		this.informationTypes = informationTypes;
	}

	public int getRowNum() {
		return rowNum;
	}

	public void setRowNum(int rowNum) {
		this.rowNum = rowNum;
	}
}
