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
 * 查询会员下子用户列表信息的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月19日
 * @version 1.0
 */
@ApiModel("查询会员下子用户列表信息的PO")
public class SubWebMembListPo extends PagePo<MembListInfoVo> {

	private static final long serialVersionUID = 4768590344715894860L;

	@ApiModelProperty(value="(0:用户名1:姓名2:手机号码3:主体名称)")
	private String key;
	@ApiModelProperty(value="选择查询条件后输入的参数")
	private String value;
	@ApiModelProperty(value="帐号状态 (acct_status[0:冻结1:正常])")
	private String acctStatus;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="注册开始时间")
    private OffsetDateTime regStaDate; //注册开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="注册结束时间")
    private OffsetDateTime regEndDate; //注册开始时间
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
}
