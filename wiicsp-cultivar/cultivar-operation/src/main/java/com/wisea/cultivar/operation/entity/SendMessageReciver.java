package com.wisea.cultivar.operation.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class SendMessageReciver extends DataLongEntity<SendMessageReciver> {
    private static final long serialVersionUID = -1436290458323106276L;

    /**
     * 消息ID
     */
    private Long msgId;

    /**
     * 会员ID
     */
    private Long membId;

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
}
