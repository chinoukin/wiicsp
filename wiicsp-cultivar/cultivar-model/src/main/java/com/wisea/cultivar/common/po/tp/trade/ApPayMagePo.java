package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className ApPayMagePo
 * @date 2019/4/22 15:58
 * @Description 添加或修改账期支付设置Po
 */
@ApiModel(value = "添加或修改账期支付设置Po", description = "查询会员信息请调用/tp/system/w/memb/getByUserName")
public class ApPayMagePo {
    @ApiModelProperty("账期设置ID，修改时必填")
    private Long id;
    @ApiModelProperty("买家会员id，新增时必填，修改时不能修改该字段，修改时不用传")
    @Check(test = "logic", logic = "#isEmpty(#id)?#isNotEmpty(#buyerId):true", logicMsg = "采购商Id不能为空")
    private Long buyerId;
    @ApiModelProperty("采购商账号，修改时不能修改该字段，修改时不用传")
    @Check(test = "logic", logic = "#isEmpty(#id)?#isNotEmpty(#purchaserAcct):true", logicMsg = "采购商账号不能为空")
    private String purchaserAcct;
    @ApiModelProperty("采购商名称")
    private String purchaserAcctName;
    @ApiModelProperty("账期类型")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1", "2", "3", "4"}, liveableMsg = "账期类型有效值：0、1、2、3、4")
    private String settleCycleType;
    @ApiModelProperty("账单生成日类型")
    @Check(test = "required")
    private String billDateType;
    @ApiModelProperty("账期授信额度")
    @Check(test = "required")
    private Double acctCreditLine;
    @ApiModelProperty("最晚付款日")
    @Check(test = "required")
    private Integer payDeadDate;
    @ApiModelProperty("服务费比例")
    @Check(test = "regex", regex = "^(([1-9]{1}\\d*)|(0{1}))(\\.\\d{0,2})?$", regexMsg = "服务费比例比例输入有误")
    private Double serCostBl;
    @ApiModelProperty("是否收取滞纳金")
    private String sfLateFeeFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getBuyerId() {
        return buyerId;
    }

    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    public String getPurchaserAcct() {
        return purchaserAcct;
    }

    public void setPurchaserAcct(String purchaserAcct) {
        this.purchaserAcct = purchaserAcct;
    }

    public String getPurchaserAcctName() {
        return purchaserAcctName;
    }

    public void setPurchaserAcctName(String purchaserAcctName) {
        this.purchaserAcctName = purchaserAcctName;
    }

    public String getSettleCycleType() {
        return settleCycleType;
    }

    public void setSettleCycleType(String settleCycleType) {
        this.settleCycleType = settleCycleType;
    }

    public String getBillDateType() {
        return billDateType;
    }

    public void setBillDateType(String billDateType) {
        this.billDateType = billDateType;
    }

    public Double getAcctCreditLine() {
        return acctCreditLine;
    }

    public void setAcctCreditLine(Double acctCreditLine) {
        this.acctCreditLine = acctCreditLine;
    }

    public Integer getPayDeadDate() {
        return payDeadDate;
    }

    public void setPayDeadDate(Integer payDeadDate) {
        this.payDeadDate = payDeadDate;
    }

    public String getSfLateFeeFlag() {
        return sfLateFeeFlag;
    }

    public void setSfLateFeeFlag(String sfLateFeeFlag) {
        this.sfLateFeeFlag = sfLateFeeFlag;
    }

    public Double getSerCostBl() {
        return serCostBl;
    }

    public void setSerCostBl(Double serCostBl) {
        this.serCostBl = serCostBl;
    }
}
