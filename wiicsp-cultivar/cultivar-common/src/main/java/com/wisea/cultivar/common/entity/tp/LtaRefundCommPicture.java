package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

public class LtaRefundCommPicture extends DataLongEntity<LtaRefundCommPicture> {
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

    public Long getRefundApplId() {
        return refundApplId;
    }

    public void setRefundApplId(Long refundApplId) {
        this.refundApplId = refundApplId;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getBuySellFlag() {
        return buySellFlag;
    }

    public void setBuySellFlag(String buySellFlag) {
        this.buySellFlag = buySellFlag;
    }
}
