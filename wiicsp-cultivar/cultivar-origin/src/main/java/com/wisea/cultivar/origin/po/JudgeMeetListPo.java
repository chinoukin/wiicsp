package com.wisea.cultivar.origin.po;

import com.wisea.cultivar.origin.vo.JudgeMeetListVo;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 品鉴会列表PO
 * @author wzx
 *
 */
@ApiModel("品鉴会列表PO")
public class JudgeMeetListPo extends PagePo<JudgeMeetListVo> {

	private static final long serialVersionUID = 3491557822319905440L;
	@ApiModelProperty("品鉴会名称")
	private String judgeMeetName;
	public String getJudgeMeetName() {
		return judgeMeetName;
	}
	public void setJudgeMeetName(String judgeMeetName) {
		this.judgeMeetName = judgeMeetName;
	}

}
