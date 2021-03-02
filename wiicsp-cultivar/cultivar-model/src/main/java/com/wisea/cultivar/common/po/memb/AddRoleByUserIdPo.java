package com.wisea.cultivar.common.po.memb;

import java.io.Serializable;
import java.util.List;

/**
 * 通过用户ID和角色Code添加用户角色权限PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年6月8日
 * @version 1.0
 */
public class AddRoleByUserIdPo implements Serializable{

	private static final long serialVersionUID = -5964604035833571387L;

	/**
	 * 用户ID
	 */
	private Long userId;
	/**
	 * 角色code集合
	 */
	private List<String> roleCodeList;

	public Long getUserId() {
		return userId;
	}
	public void setUserId(Long userId) {
		this.userId = userId;
	}
	public List<String> getRoleCodeList() {
		return roleCodeList;
	}
	public void setRoleCodeList(List<String> roleCodeList) {
		this.roleCodeList = roleCodeList;
	}
}
