package com.wisea.cultivar.common.vo.memb;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 冻结/修改手机号/重置密码时获取会员验证信息PO
 *
 * @author wangh(wisea)
 *
 * @date 2020年5月28日
 * @version 1.0
 */
@ApiModel("冻结/修改手机号/重置密码时获取会员验证信息PO")
public class MembProveBaseInfoVo {

	@ApiModelProperty(value="会员ID")
	private Long membId;

	@ApiModelProperty(value="用户名")
	private String loginName;

	@ApiModelProperty(value="注册手机号")
	private String registTel;

	@ApiModelProperty(value="企业名称")
	private String entpName;

	@ApiModelProperty(value="联系人")
	private String contName;

	@ApiModelProperty(value="统一社会信用代码")
	private String ctsccb;

	@ApiModelProperty(value="法人姓名")
	private String legalPersonName;

    public String getContName() {
        return contName;
    }

    public void setContName(String contName) {
        this.contName = contName;
    }

    public Long getMembId() {
		return membId;
	}

	public void setMembId(Long membId) {
		this.membId = membId;
	}

	public String getLoginName() {
		return loginName;
	}

	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}

	public String getRegistTel() {
		return registTel;
	}

	public void setRegistTel(String registTel) {
		this.registTel = registTel;
	}

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getCtsccb() {
		return ctsccb;
	}

	public void setCtsccb(String ctsccb) {
		this.ctsccb = ctsccb;
	}

	public String getLegalPersonName() {
		return legalPersonName;
	}

	public void setLegalPersonName(String legalPersonName) {
		this.legalPersonName = legalPersonName;
	}
}
