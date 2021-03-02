package com.wisea.transac.common.vo.trade;

import java.time.OffsetDateTime;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 导出平台端收支明细列表vo
 * @author yangtao
 *
 */
@ApiModel("导出平台端收支明细列表vo")
public class IncomeListExpAdminVo {

    @ApiModelProperty("收支明细ID")
    private Long id;
    @ApiModelProperty("交易流水号")
    @ExcelField(title = "流水号", sort = 0, width = 20)
    private String tradeNo;
    @ApiModelProperty("订单编号")
    @ExcelField(title = "订单编号", sort = 2, width = 20)
    private String ordNum;
    @ApiModelProperty("完成时间")
    @ExcelField(title = "到账时间", sort = 3, width = 20)
    private OffsetDateTime finishDate;
    @ApiModelProperty("买家支付金额")
    @ExcelField(title = "采购商支付金额", sort = 4, width = 20)
    private Double commTotalPrice;
    @ApiModelProperty("分账收入")
    @ExcelField(title = "供应商入账金额", sort = 5, width = 20)
    private Double splitIncome;
    @ApiModelProperty("账期编号")
    @ExcelField(title = "账单单编号", sort = 1, width = 20)
    private String settleBillNumb;
    @ApiModelProperty("平台服务费")
    @ExcelField(title = "平台服务费", sort = 6, width = 20)
    private Double operSerCharge;
    @ApiModelProperty("账期，订单ID")
    private Long settOrdId;
    @ApiModelProperty("采购商账户")
    private String loginName;
    @ApiModelProperty("采购商名称")
    private String entpName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTradeNo() {
        return tradeNo;
    }
    public void setTradeNo(String tradeNo) {
        this.tradeNo = tradeNo;
    }
    public String getOrdNum() {
        return ordNum;
    }
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }
    public Double getSplitIncome() {
        return splitIncome;
    }
    public void setSplitIncome(Double splitIncome) {
        this.splitIncome = splitIncome;
    }
    public String getSettleBillNumb() {
        return settleBillNumb;
    }
    public void setSettleBillNumb(String settleBillNumb) {
        this.settleBillNumb = settleBillNumb;
    }
    public OffsetDateTime getFinishDate() {
        return finishDate;
    }
    public void setFinishDate(OffsetDateTime finishDate) {
        this.finishDate = finishDate;
    }
    public Double getCommTotalPrice() {
        return commTotalPrice;
    }
    public void setCommTotalPrice(Double commTotalPrice) {
        this.commTotalPrice = commTotalPrice;
    }
    public Double getOperSerCharge() {
        return operSerCharge;
    }
    public void setOperSerCharge(Double operSerCharge) {
        this.operSerCharge = operSerCharge;
    }
    public Long getSettOrdId() {
        return settOrdId;
    }
    public void setSettOrdId(Long settOrdId) {
        this.settOrdId = settOrdId;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
}
