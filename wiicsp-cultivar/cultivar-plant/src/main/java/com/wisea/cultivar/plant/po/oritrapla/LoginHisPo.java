package com.wisea.cultivar.plant.po.oritrapla;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.plant.vo.oritrapla.FindLoginHisVo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * 查询登录历史记录的PO
 *
 * @author wangh(wisea)
 *
 * @date 2018年6月20日
 * @version 1.0
 */
@ApiModel("查询登录历史记录的PO")
public class LoginHisPo extends PagePo<FindLoginHisVo> {

	private static final long serialVersionUID = -7039088559010066088L;

	@ApiModelProperty(value="(0:用户名1:姓名2:手机号码3:主体名称)")
	private String key;
	@ApiModelProperty(value="选择查询条件后输入的参数")
	private String value;
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="登录开始时间")
    private OffsetDateTime loginStaDate; //注册开始时间
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value="登录结束时间")
    private OffsetDateTime loginEndDate; //注册开始时间
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
	 * @return the loginStaDate
	 */
	public OffsetDateTime getLoginStaDate() {
		return loginStaDate;
	}
	/**
	 * @param loginStaDate the loginStaDate to set
	 */
	public void setLoginStaDate(OffsetDateTime loginStaDate) {
		this.loginStaDate = loginStaDate;
	}
	/**
	 * @return the loginEndDate
	 */
	public OffsetDateTime getLoginEndDate() {
		return loginEndDate;
	}
	/**
	 * @param loginEndDate the loginEndDate to set
	 */
	public void setLoginEndDate(OffsetDateTime loginEndDate) {
		this.loginEndDate = loginEndDate;
	}
}
