package com.wisea.cultivar.plant.vo.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.common.annotation.LongSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTime2LongStrSerializer;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 会员管理中的会员列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月19日
 * @version 1.0
 */
@ApiModel("会员管理中的会员列表信息VO")
public class MembListInfoVo {

	@ApiModelProperty("账户ID")
	@JsonSerialize(using= LongSerializer.class)
	private Long id;
	@ApiModelProperty("用户名")
	private String loginName;
	@ApiModelProperty("姓名")
	private String contName;
	@ApiModelProperty("手机号")
	private String contTel;
	@ApiModelProperty("职位")
	private String position;
	@ApiModelProperty("主体名称")
	private String orgName;
    @ApiModelProperty("主体类型")
    private String subjectType;
	@ApiModelProperty("子账户数量")
	private int subCount;
	@ApiModelProperty("状态(acct_status[0:冻结1:正常])")
	private String acctStatus;
	@ApiModelProperty("注册时间")
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	private OffsetDateTime registerDate;
	@ApiModelProperty("更新人")
	private String updateName;
	@ApiModelProperty("更新时间")
	@JsonSerialize(using = OffsetDateTime2LongStrSerializer.class)
	private OffsetDateTime updateDate;
	@ApiModelProperty("性别(sex_type[0:男1:女])")
	private String sexType;
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the loginName
	 */
	public String getLoginName() {
		return loginName;
	}
	/**
	 * @param loginName the loginName to set
	 */
	public void setLoginName(String loginName) {
		this.loginName = loginName;
	}
	/**
	 * @return the contName
	 */
	public String getContName() {
		return contName;
	}
	/**
	 * @param contName the contName to set
	 */
	public void setContName(String contName) {
		this.contName = contName;
	}
	/**
	 * @return the contTel
	 */
	public String getContTel() {
		return contTel;
	}
	/**
	 * @param contTel the contTel to set
	 */
	public void setContTel(String contTel) {
		this.contTel = contTel;
	}
	/**
	 * @return the position
	 */
	public String getPosition() {
		return position;
	}
	/**
	 * @param position the position to set
	 */
	public void setPosition(String position) {
		this.position = position;
	}
	/**
	 * @return the orgName
	 */
	public String getOrgName() {
		return orgName;
	}
	/**
	 * @param orgName the orgName to set
	 */
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}

    public String getSubjectType() {
        return subjectType;
    }

    public void setSubjectType(String subjectType) {
        this.subjectType = subjectType;
    }

    /**
	 * @return the subCount
	 */
	public int getSubCount() {
		return subCount;
	}
	/**
	 * @param subCount the subCount to set
	 */
	public void setSubCount(int subCount) {
		this.subCount = subCount;
	}
	/**
	 * @return the acctStatus
	 */
	public String getAcctStatus() {
		return acctStatus;
	}
	/**
	 * @param acctStatus the acctStatus to set
	 */
	public void setAcctStatus(String acctStatus) {
		this.acctStatus = acctStatus;
	}
	/**
	 * @return the registerDate
	 */
	public OffsetDateTime getRegisterDate() {
		return registerDate;
	}
	/**
	 * @param registerDate the registerDate to set
	 */
	public void setRegisterDate(OffsetDateTime registerDate) {
		this.registerDate = registerDate;
	}
	/**
	 * @return the updateName
	 */
	public String getUpdateName() {
		return updateName;
	}
	/**
	 * @param updateName the updateName to set
	 */
	public void setUpdateName(String updateName) {
		this.updateName = updateName;
	}
	/**
	 * @return the updateDate
	 */
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	/**
	 * @param updateDate the updateDate to set
	 */
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
	/**
	 * @return the sexType
	 */
	public String getSexType() {
		return sexType;
	}
	/**
	 * @param sexType the sexType to set
	 */
	public void setSexType(String sexType) {
		this.sexType = sexType;
	}
}
