package com.wisea.transac.common.po.trade;

import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.po.LongIdPo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className InvoicingPo
 * @date 2020/5/18 9:37
 * @Description
 */
@ApiModel("开票PO")
public class InvoicingPo extends LongIdPo {
    @ApiModelProperty("录入开票结果类型")
    @Check(test = "liveable", liveable = {"0", "1", "2"}, liveableMsg = "开票结果类型有误")
    private String entryOpenInvoType;
    @ApiModelProperty("电子发票文件列表")
    @Check(test = "logic", logic = "'0'.equals(#entryOpenInvoType)?#isNotEmpty(#invoFiles):true", logicMsg = "电子发票文件不能为空")
    private List<InvoFilePo> invoFiles;
    @ApiModelProperty("物流公司名称")
    @Check(test = "logic", logic = "'1'.equals(#entryOpenInvoType)?#isNotEmpty(#logisticsCompName):true", logicMsg = "物流公司名称不能为空")
    private String logisticsCompName;
    @ApiModelProperty("物流单号")
    @Check(test = "logic", logic = "'1'.equals(#entryOpenInvoType)?#isNotEmpty(#logisticsNum):true", logicMsg = "物流单号不能为空")
    private String logisticsNum;
    @ApiModelProperty("开票备注")
    @Check(test = "logic", logic = "'2'.equals(#entryOpenInvoType)?#isNotEmpty(#openInvoRemarks):true", logicMsg = "开票备注不能为空")
    private String openInvoRemarks;

    public String getEntryOpenInvoType() {
        return entryOpenInvoType;
    }

    public void setEntryOpenInvoType(String entryOpenInvoType) {
        this.entryOpenInvoType = entryOpenInvoType;
    }

    public List<InvoFilePo> getInvoFiles() {
        return invoFiles;
    }

    public void setInvoFiles(List<InvoFilePo> invoFiles) {
        this.invoFiles = invoFiles;
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

    public String getOpenInvoRemarks() {
        return openInvoRemarks;
    }

    public void setOpenInvoRemarks(String openInvoRemarks) {
        this.openInvoRemarks = openInvoRemarks;
    }
}
