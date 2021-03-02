package com.wisea.transac.common.po.memb;

import java.io.Serializable;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 添加会员员工信息(销售员/采购员)PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年8月13日
 * @version 1.0
 */
@ApiModel("添加会员员工信息(销售员/采购员)PO")
public class MembStaffInfoAddPo implements Serializable {

	private static final long serialVersionUID = 6810958254815823909L;

	@ApiModelProperty(value = "员工类型(0:销售员工1:采购员工 默认是1采购员工)", required = false)
	private String staffType = "1";

	@ApiModelProperty(value = "会员ID(为空的情况随机生成)")
    private Long id;

    @ApiModelProperty(value = "用户父id")
    private Long parentId;

    @ApiModelProperty(value = "客服分组ID(基地ID或者店铺ID) 销售员工不能为空", required = false)
    @Check(test = {"logic"},logic = "'0'.equals(#staffType)?#isNotEmpty(#groupId):true", logicMsg = "销售员工客服分组ID不能为空")
	private String groupId;

    @ApiModelProperty(value = "是否设置成为管理员(0:是1:否) 销售员工不能为空", required = false)
    @Check(test = {"logic"},logic = "'0'.equals(#staffType)?#isNotEmpty(#sfAdminFlag):true", logicMsg = "销售员工是否为管理员不能为空")
    private String sfAdminFlag;

    @ApiModelProperty(value = "手机", required = true)
    @Check(test = "required")
    private String mobile;

    @ApiModelProperty(value = "职称", required = false)
    private String position;

    @ApiModelProperty(value = "性别(0:未知1:男2:女)", required = false)
    private String sexType;

    @ApiModelProperty(value = "姓名", required = true)
    private String contName;

    @ApiModelProperty(value = "菜单.id字符串数组(使用逗号分隔)如果是空清空菜单操作", required = false)
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

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getSexType() {
		return sexType;
	}

	public void setSexType(String sexType) {
		this.sexType = sexType;
	}

	public String getContName() {
		return contName;
	}

	public void setContName(String contName) {
		this.contName = contName;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}

	public Long getParentId() {
		return parentId;
	}

	public void setParentId(Long parentId) {
		this.parentId = parentId;
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
}
