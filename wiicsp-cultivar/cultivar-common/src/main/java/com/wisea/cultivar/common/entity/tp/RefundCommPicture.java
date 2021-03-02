package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * refund_comm_picture 表实体
 * 退货申请图片
 * 2018/09/30 09:46:17
 */
public class RefundCommPicture extends DataLongEntity<RefundCommPicture> {
    private static final long serialVersionUID = 1L;

    /**
     * 退货申请id
     */
    private Long refundApplId;

    /**
     * 图片url
     */
    private String url;

    /**
     * 买卖方标志
     */
    private String buySellFlag;

    /**
     * 获取退货申请id
     */
    public Long getRefundApplId() {
        return refundApplId;
    }

    /**
     * 设置退货申请id
     */
    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
    }

    /**
     * 获取图片url
     */
    public String getUrl() {
        return url;
    }

    /**
     * 设置图片url
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    public String getBuySellFlag() {
        return buySellFlag;
    }

    public void setBuySellFlag(String buySellFlag) {
        this.buySellFlag = buySellFlag;
    }
}
