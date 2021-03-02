package com.wisea.transac.common.po.memb;

import java.util.List;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 市场管理员列表信息导出PO
 *
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月7日
 * @version 1.0
 */
@ApiModel("市场管理员列表信息导出PO")
public class MarketAdminExportPo{


	@ApiModelProperty("批发市场名称/用户名/姓名")
	private String key;

	@ApiModelProperty("手机号")
	private String tel;

	@ApiModelProperty(value="会员id列表(如果为空则按照条件,如果不是空则按照id列表查询)")
	private List<String> idList;

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

	public List<String> getIdList() {
		return idList;
	}

	public void setIdList(List<String> idList) {
		this.idList = idList;
	}

}
