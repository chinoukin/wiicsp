package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * 退货拒绝退款PO
 */
public class RejectRefundPo {
    @ApiModelProperty("退货申请ID")
    @Check(test = "required")
    private Long id;
    @ApiModelProperty("货物状态（0 未收到货、1 已收到货）")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, logicMsg = "货物状态只能为0、1")
    private String goodsStateType;
    @ApiModelProperty("拒收原因")
    @Check(test = {"required", "maxLength"}, length = 255)
    private String rejeReason;
    @ApiModelProperty("图片列表")
    @Check(test = "logic",logic = "#imgUrls.size()<=10 ? true:false", logicMsg = "图片最多10张")
    private List<String> imgUrls;
    @ApiModelProperty("备注")
    @Check(test = "maxLength", length = 255)
    private String remarks;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getGoodsStateType() {
        return goodsStateType;
    }

    public void setGoodsStateType(String goodsStateType) {
        this.goodsStateType = goodsStateType;
    }

    public String getRejeReason() {
        return rejeReason;
    }

    public void setRejeReason(String rejeReason) {
        this.rejeReason = rejeReason;
    }

    public List<String> getImgUrls() {
        return imgUrls;
    }

    public void setImgUrls(List<String> imgUrls) {
        this.imgUrls = imgUrls;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
