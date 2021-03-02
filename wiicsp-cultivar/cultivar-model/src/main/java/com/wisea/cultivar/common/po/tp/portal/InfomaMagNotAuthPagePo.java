package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.portal.InformationMagePageListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯列表查询(无权限)PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月29日
 * @version 1.0
 */
@ApiModel("资讯列表查询(无权限)PO")
public class InfomaMagNotAuthPagePo extends PagePo<InformationMagePageListVo> {

	private static final long serialVersionUID = 5212996780357070447L;

	@ApiModelProperty(value = "所属分类（0:平台公告1:行业资讯2果链动态3价格行情）空为全部")
    private String informationType;

	public String getInformationType() {
		return informationType;
	}

	public void setInformationType(String informationType) {
		this.informationType = informationType;
	}

}
