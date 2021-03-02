package com.wisea.transac.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class MarketAcctNumMage extends DataLongEntity<MarketAcctNumMage> {
    /**
	 *
	 * @author wangh(wisea)
	 *
	 * @date 2020年5月6日
	 * @version 1.0
	 */
	private static final long serialVersionUID = -8712357304650449671L;


	/**
     * 批发市场id
     */
    private Long wholeSaleMarketId;

    /**
     * 用户名
     */
    private String loginName;

    /**
     * 姓名
     */
    private String name;

    /**
     * 联系电话
     */
    private String tel;

    /**
     * 角色名称
     */
    private String roleType;
    /**
     * 是否是管理员
     */
    private String sfAdminFlag;
    /**
     * 停启用状态
     */
    private String effeInvalState;

	public Long getWholeSaleMarketId() {
		return wholeSaleMarketId;
	}
	public void setWholeSaleMarketId(Long wholeSaleMarketId) {
		this.wholeSaleMarketId = wholeSaleMarketId;
	}
	public String getLoginName() {
		return loginName;
	}
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getRoleType() {
		return roleType;
	}
	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}
	public String getSfAdminFlag() {
		return sfAdminFlag;
	}
	public void setSfAdminFlag(String sfAdminFlag) {
		this.sfAdminFlag = sfAdminFlag;
	}
	public String getEffeInvalState() {
		return effeInvalState;
	}
	public void setEffeInvalState(String effeInvalState) {
		this.effeInvalState = effeInvalState;
	}
}
