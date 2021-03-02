package com.wisea.cultivar.common.po.tp.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className InvoBillingPo
 * @date 2019/4/25 10:34
 * @Description 订单发票开票PO
 */
@ApiModel("订单发票开票PO")
public class InvoBillingPo extends LongIdPo {
    @ApiModelProperty("发票形式")
    @Check(test={"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "发票形式有效值：0、1")
    private String invoForm;
    @ApiModelProperty("电子发票文件URL")
    @Check(test = "logic", logic = "'0'.equals(#invoForm)?#isNotEmpty(#eleInvoUrl):true", logicMsg = "电子发票文件不能为空")
    private String eleInvoUrl;
    @ApiModelProperty("文件名称")
    @Check(test = "logic", logic = "'0'.equals(#invoForm)?#isNotEmpty(#eleInvoFileName):true", logicMsg = "文件名称不能为空")
    private String eleInvoFileName;
    @ApiModelProperty("物流公司名称")
    @Check(test = "logic", logic = "'1'.equals(#invoForm)?#isNotEmpty(#logisticsCompName):true", logicMsg = "物流公司不能为空")
    private String logisticsCompName;
    @ApiModelProperty("物流单号")
    @Check(test = "logic", logic = "'1'.equals(#invoForm)?#isNotEmpty(#logisticsNum):true", logicMsg = "物流单号不能为空")
    private String logisticsNum;
    @ApiModelProperty("发票备注")
    private String remarks;

    public String getInvoForm() {
        return invoForm;
    }

    public void setInvoForm(String invoForm) {
        this.invoForm = invoForm;
    }

    public String getEleInvoUrl() {
        return eleInvoUrl;
    }

    public void setEleInvoUrl(String eleInvoUrl) {
        this.eleInvoUrl = eleInvoUrl;
    }

    public String getEleInvoFileName() {
        return eleInvoFileName;
    }

    public void setEleInvoFileName(String eleInvoFileName) {
        this.eleInvoFileName = eleInvoFileName;
    }

    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName;
    }

    public String getLogisticsNum() {
        return logisticsNum;
    }

    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }
}
