package com.wisea.transac.common.po.memb;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.transac.common.vo.memb.MarketAdminInfoVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页查询市场管理员列表信息PO
 *
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月7日
 * @version 1.0
 */
@ApiModel("分页查询市场管理员列表信息PO")
public class MarketAdminInfoPagePo  extends PagePo<MarketAdminInfoVo>{

	private static final long serialVersionUID = 4973370497366280149L;

	@ApiModelProperty("批发市场名称/用户名/姓名")
	private String key;

	@ApiModelProperty("手机号")
	private String tel;

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

}
