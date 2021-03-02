package com.wisea.cultivar.common.po.memb;

import java.io.Serializable;

import io.swagger.annotations.ApiModel;

/**
 * 修改用户会员信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月11日
 * @version 1.0
 */
@ApiModel("修改用户会员信息的PO")
public class UpdUserMembInfoPo implements Serializable{

	private static final long serialVersionUID = 2816021737092684306L;
	/**
	 * 用户ID
	 */
	private Long id;
	/**
	 * 登录用户名 (如果传值为空表示不修改)
	 */
	private String loginName;
	/**
	 * 注册手机号(如果传值为空表示不修改)
	 */
	private String mobile;
	/**
	 * 登录标识0:不可登录1:可以登录(如果传值为空表示不修改)
	 */
	private String loginFlag;
	/**
	 * 登录密码 (如果传值为空表示不修改)
	 */
	private String password;
	/**
	 * 物理删除标识(如果传值为空或者0表示不修改1：删除操作)
	 */
	private String physicalDelFLag;
	/**
	 * 菜单.id字符串数组(使用逗号分隔),如果为空不处理
	 */
    private String menuIds;
    /**
	 * 是否清除菜单标识(true:清空false:不操作 默认是false)
	 */
    private boolean clearMenuFlag = false;

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getLoginFlag() {
		return loginFlag;
	}
	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getPhysicalDelFLag() {
		return physicalDelFLag;
	}
	public void setPhysicalDelFLag(String physicalDelFLag) {
		this.physicalDelFLag = physicalDelFLag;
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
	public boolean isClearMenuFlag() {
		return clearMenuFlag;
	}
	public void setClearMenuFlag(boolean clearMenuFlag) {
		this.clearMenuFlag = clearMenuFlag;
	}

}
