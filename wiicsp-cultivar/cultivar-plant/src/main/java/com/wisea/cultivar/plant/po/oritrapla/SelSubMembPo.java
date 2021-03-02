package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.SubMembInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 根据手机号、姓名或用户名查询人员信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月6日
 * @version 1.0
 */
@ApiModel("根据手机号、姓名或用户名查询人员信息PO")
public class SelSubMembPo extends PagePo<SubMembInfoVo> {

	private static final long serialVersionUID = -4656410000205176089L;
	@ApiModelProperty("查询条件(手机号或者姓名或者用户名)")
	private String strKey;
	@ApiModelProperty(value="父节点Id",hidden=true)
	private Long pid;
	/**
	 * @return the strKey
	 */
	public String getStrKey() {
		return strKey;
	}
	/**
	 * @param strKey the strKey to set
	 */
	public void setStrKey(String strKey) {
		this.strKey = strKey;
	}
	/**
	 * @return the pid
	 */
	public Long getPid() {
		return pid;
	}
	/**
	 * @param pid the pid to set
	 */
	public void setPid(Long pid) {
		this.pid = pid;
	}

}
