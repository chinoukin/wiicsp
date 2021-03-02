package com.wisea.cultivar.common.vo.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
/**
 * 系统消息列表信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月13日
 * @version 1.0
 */
@ApiModel("系统消息列表信息VO")
public class MessageInfoListVo {

	 @JsonSerialize(using = IdSerializer.class)
	 @ApiModelProperty(value = "id")
	 private Long id;

	 @ApiModelProperty(value = "发送标题")
     private String title;

	 @ApiModelProperty(value = "发送摘要")
	 private String summary;

	 @ApiModelProperty(value = "发送详细内容")
	 private String content;

	 @ApiModelProperty(value = "备注")
	 private String remarks;

	 @JsonSerialize(using = OffsetDateTimeSerializer.class)
	 @ApiModelProperty(value = "发送时间")
	 private OffsetDateTime createDate;

	 @ApiModelProperty(value = "消息已读标识(read_falg(0:未读1:已读))")
	 private String readFlag;

	 @ApiModelProperty(value = "跳转地址")
	 private String tzUrl;

	 @ApiModelProperty(value = "跳转地址的参数")
	 private String tzPara;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public String getRemarks() {
		return remarks;
	}

	public void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public OffsetDateTime getCreateDate() {
		return createDate;
	}

	public void setCreateDate(OffsetDateTime createDate) {
		this.createDate = createDate;
	}

	public String getReadFlag() {
		return readFlag;
	}

	public void setReadFlag(String readFlag) {
		this.readFlag = readFlag;
	}

	public String getTzUrl() {
		return tzUrl;
	}

	public void setTzUrl(String tzUrl) {
		this.tzUrl = tzUrl;
	}

	public String getTzPara() {
		return tzPara;
	}

	public void setTzPara(String tzPara) {
		this.tzPara = tzPara;
	}
}
