package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.portal.AdverSpaceMageListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 广告位管理分页查询PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月31日
 * @version 1.0
 */
@ApiModel("广告位管理分页查询PO")
public class AdverSpaceMagePagePo extends PagePo<AdverSpaceMageListVo>{

	private static final long serialVersionUID = -1212730534482351847L;

	@ApiModelProperty(value = "广告位名称(0:首页轮播图)")
	private String adverSpaceName;

	@ApiModelProperty(value = "状态(0:启用1:停用)")
    private String enableFlag;

	public String getAdverSpaceName() {
		return adverSpaceName;
	}

	public void setAdverSpaceName(String adverSpaceName) {
		this.adverSpaceName = adverSpaceName;
	}

	public String getEnableFlag() {
		return enableFlag;
	}

	public void setEnableFlag(String enableFlag) {
		this.enableFlag = enableFlag;
	}
}
