package com.wisea.transac.common.po.memb;

import com.wisea.cloud.common.po.RegisterUserPo;

public class                      RegisterUserMembPo extends RegisterUserPo{

	/**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年6月12日
	 * @version 1.0
	 */
	private static final long serialVersionUID = -5658740257770023649L;

	/**
	 * 登录标识0:不可登录1:可以登录(如果传值为空表示不修改)
	 */
	private String loginFlag;

	/**
	 * 菜单.id字符串数组(使用逗号分隔),如果为空不处理
	 */
    private String menuIds;

	public String getLoginFlag() {
		return loginFlag;
	}

	public void setLoginFlag(String loginFlag) {
		this.loginFlag = loginFlag;
	}

	public String getMenuIds() {
		return menuIds;
	}

	public void setMenuIds(String menuIds) {
		this.menuIds = menuIds;
	}
}
