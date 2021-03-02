package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cultivar.common.vo.tp.portal.JszlListMageListVo;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 技术学堂-技术资料列表查詢PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("技术学堂-技术资料列表查詢PO")
public class JsxtPageListPo extends PagePo<JszlListMageListVo>{

	private static final long serialVersionUID = 1063838764986638232L;

	@ApiModelProperty(value = "标题或信息来源")
	private String searchKey;

    @ApiModelProperty(value = "所属分类")
    private Long jszlCatgId;

	public String getSearchKey() {
		return searchKey;
	}

	public void setSearchKey(String searchKey) {
		this.searchKey = searchKey;
	}

	public Long getJszlCatgId() {
		return jszlCatgId;
	}

	public void setJszlCatgId(Long jszlCatgId) {
		this.jszlCatgId = jszlCatgId;
	}

}
