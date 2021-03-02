package com.wisea.cultivar.common.po.tp.memb;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

/**
 * 修改已读未读标识PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月14日
 * @version 1.0
 */
public class GetMsgInfoPo {

	private Long msgId;// 消息ID
	private Long membId; // 会员ID
	private String updateBy; // 更新者
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime updateDate; // 更新日期
	public Long getMsgId() {
		return msgId;
	}
	public void setMsgId(Long msgId) {
		this.msgId = msgId;
	}
	public Long getMembId() {
		return membId;
	}
	public void setMembId(Long membId) {
		this.membId = membId;
	}
	public String getUpdateBy() {
		return updateBy;
	}
	public void setUpdateBy(String updateBy) {
		this.updateBy = updateBy;
	}
	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}
	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
