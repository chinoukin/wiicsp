package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.MembListInfoVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 查询会员列表信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月19日
 * @version 1.0
 */
@ApiModel("查询会员列表信息的PO")
public class WebMembListPo extends PagePo<MembListInfoVo> {

	private static final long serialVersionUID = 4768590344715894860L;

	@ApiModelProperty(value="(0:用户名1:姓名2:手机号码3:主体名称)")
	private String key;
	@ApiModelProperty(value="选择查询条件后输入的参数")
	private String value;
	@ApiModelProperty(value="主体类型(subject_type[0:企业1:合作社2:散户3:经纪人])")
	private String subjectType;
	@ApiModelProperty(value="帐号状态 (acct_status[0:冻结1:正常])")
	private String acctStatus;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="注册开始时间")
    private OffsetDateTime regStaDate;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="注册结束时间")
    private OffsetDateTime regEndDate;
	@ApiModelProperty(value="用户类型 (0:主账户1:子账户)",hidden=true)
	private String acctType;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新开始时间",hidden=true)
	private OffsetDateTime updStaDate;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="更新结束时间",hidden=true)
	private OffsetDateTime updEndDate;
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the subjectType
	 */
	public String getSubjectType() {
		return subjectType;
	}
	/**
	 * @param subjectType the subjectType to set
	 */
	public void setSubjectType(String subjectType) {
		this.subjectType = subjectType;
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
	 * @return the regStaDate
	 */
	public OffsetDateTime getRegStaDate() {
		return regStaDate;
	}
	/**
	 * @param regStaDate the regStaDate to set
	 */
	public void setRegStaDate(OffsetDateTime regStaDate) {
		this.regStaDate = regStaDate;
	}
	/**
	 * @return the regEndDate
	 */
	public OffsetDateTime getRegEndDate() {
		return regEndDate;
	}
	/**
	 * @param regEndDate the regEndDate to set
	 */
	public void setRegEndDate(OffsetDateTime regEndDate) {
		this.regEndDate = regEndDate;
	}
	/**
	 * @return the acctType
	 */
	public String getAcctType() {
		return acctType;
	}
	/**
	 * @param acctType the acctType to set
	 */
	public void setAcctType(String acctType) {
		this.acctType = acctType;
	}
	/**
	 * @return the updStaDate
	 */
	public OffsetDateTime getUpdStaDate() {
		return updStaDate;
	}
	/**
	 * @param updStaDate the updStaDate to set
	 */
	public void setUpdStaDate(OffsetDateTime updStaDate) {
		this.updStaDate = updStaDate;
	}
	/**
	 * @return the updEndDate
	 */
	public OffsetDateTime getUpdEndDate() {
		return updEndDate;
	}
	/**
	 * @param updEndDate the updEndDate to set
	 */
	public void setUpdEndDate(OffsetDateTime updEndDate) {
		this.updEndDate = updEndDate;
	}
}
