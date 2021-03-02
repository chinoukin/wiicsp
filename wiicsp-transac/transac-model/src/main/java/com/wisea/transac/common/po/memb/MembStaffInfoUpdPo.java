package com.wisea.transac.common.po.memb;

import java.io.Serializable;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 修改会员员工信息(销售员/采购员)PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月14日
 * @version 1.0
 */
@ApiModel("修改会员员工信息(销售员/采购员)PO")
public class MembStaffInfoUpdPo  implements Serializable {

	private static final long serialVersionUID = -2552249484214642355L;

	@ApiModelProperty(value = "员工类型(0:销售员工1:采购员工 默认是1采购员工)", required = false)
	private String staffType = "1";

	@ApiModelProperty(value = "会员ID", required = true)
    @Check(test = "required")
    private Long id;

    @ApiModelProperty(value = "客服分组ID(基地ID或者店铺ID) 如果不需要修改客服不填写", required = false)
	private String groupId;

    @ApiModelProperty(value = "是否设置成为管理员(0:是1:否) 如果不需要修改客服不填写", required = false)
    private String sfAdminFlag;

    @ApiModelProperty(value = "手机", required = true)
    @Check(test = "required")
    private String mobile;

    @ApiModelProperty(value = "菜单.id字符串数组(使用逗号分隔),采购员工没有菜单 销售员工如果为空的情况删除 ", required = false)
    private String menuIds;

	public String getStaffType() {
		return staffType;
	}

	public void setStaffType(String staffType) {
		this.staffType = staffType;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getGroupId() {
		return groupId;
	}

	public void setGroupId(String groupId) {
		this.groupId = groupId;
	}

	public String getSfAdminFlag() {
		return sfAdminFlag;
	}

	public void setSfAdminFlag(String sfAdminFlag) {
		this.sfAdminFlag = sfAdminFlag;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
}
