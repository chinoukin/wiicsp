package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className UpdateOrdInvoPo
 * @date 2019/4/18 10:57
 * @Description 修改订单发票PO
 */
public class UpdateOrdInvoPo {
    @ApiModelProperty("订单ID")
    @Check(test = "required")
    private Long ordId;
    @ApiModelProperty("发票类型 0 普通发票 、1 增值税专用发票 、2 不开发票")
    @Check(test = { "required", "liveable"}, liveable = {"0", "1", "2"}, liveableMsg = "配送信息类型有效值为 0、1、2")
    private String invoType;

    /**普通发票字段**/
    @ApiModelProperty("发票类别")
    @Check(test = { "logic"}, logic = "'0'.equals(#invoType)?#isNotEmpty(#invoCatgType):true", logicMsg = "发票类别不能为空")
    private String invoCatgType;
    @ApiModelProperty("发票抬头")
    @Check(test = { "logic" }, logic = "('0'.equals(#invoType) || '1'.equals(#invoType))?#isNotEmpty(#invoTitle):true", logicMsg = "发票抬头不能为空")
    private String invoTitle;
    @ApiModelProperty("纳税人识别号")
    @Check(test = { "logic" }, logic = "'1'.equals(#invoType)||('0'.equals(#invoType) && '1'.equals(#invoCatgType))?#isNotEmpty(#taxIdentNum):true", logicMsg = "纳税人识别号不能为空")
    private String taxIdentNum;

    /**专用发票补充字段**/
    @ApiModelProperty("注册地址")
    @Check(test = { "logic" }, logic = "'1'.equals(#invoType)?#isNotEmpty(#registAddress):true", logicMsg = "注册地址不能为空")
    private String registAddress;
    @ApiModelProperty("注册电话")
    @Check(test = { "logic" }, logic = "'1'.equals(#invoType)?#isNotEmpty(#registTel):true", logicMsg = "注册电话不能为空")
    private String registTel;
    @ApiModelProperty("开户银行")
    @Check(test = { "logic" }, logic = "'1'.equals(#invoType)?#isNotEmpty(#bankName):true", logicMsg = "开户银行不能为空")
    private String bankName;
    @ApiModelProperty("银行账户")
    @Check(test = { "logic" }, logic = "'1'.equals(#invoType)?#isNotEmpty(#bankAccNum):true", logicMsg = "银行账户不能为空")
    private String bankAccNum;

    public Long getOrdId() {
        return ordId;
    }

    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }

    public String getInvoType() {
        return invoType;
    }

    public void setInvoType(String invoType) {
        this.invoType = invoType;
    }

    public String getInvoCatgType() {
        return invoCatgType;
    }

    public void setInvoCatgType(String invoCatgType) {
        this.invoCatgType = invoCatgType;
    }

    public String getInvoTitle() {
        return invoTitle;
    }

    public void setInvoTitle(String invoTitle) {
        this.invoTitle = invoTitle;
    }

    public String getTaxIdentNum() {
        return taxIdentNum;
    }

    public void setTaxIdentNum(String taxIdentNum) {
        this.taxIdentNum = taxIdentNum;
    }

    public String getRegistAddress() {
        return registAddress;
    }

    public void setRegistAddress(String registAddress) {
        this.registAddress = registAddress;
    }

    public String getRegistTel() {
        return registTel;
    }

    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getBankAccNum() {
        return bankAccNum;
    }

    public void setBankAccNum(String bankAccNum) {
        this.bankAccNum = bankAccNum;
    }
}
