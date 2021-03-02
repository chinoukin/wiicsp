package com.wisea.cultivar.plant.po.oritrapla;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * Auth： jirg
 * CreateDate:  2018/6/5
 * projectName:  oritrapla
 * remark:  保存追溯码申请PO
 */
@ApiModel("保存追溯码申请PO")
public class RtspCodeMageSavePo {
    @ApiModelProperty("我的档案id")
    @Check(test = "required", requiredMsg = "我的档案不能为空")
    private Long mineArchId;
    @ApiModelProperty("档案编号")
    @Check(test = "required", requiredMsg = "档案编号不能为空")
    private String archNum;
    @ApiModelProperty("追溯码数量【大于0小于10000】")
    @Check(test = "regex", regex = "^([1-9]|[1-9]\\d{1,3}|10000)$", requiredMsg = "追溯码数量只能大于0小于10000")
    private Integer rtspCodeCount;
    @ApiModelProperty("打印方式类型（0 自行打印，1 平台打印）")
    @Check(test = "required", requiredMsg = "打印方式不能为空")
    private String printMethType;
    @ApiModelProperty("平台打印-收件人")
    @Check(test = "logic", logic = "'1'.equals(#printMethType)?#isNotEmpty(#recipients):true", logicMsg = "收件人不能为空")
    private String recipients;
    @ApiModelProperty("平台打印-联系方式")
    @Check(test = "logic", logic = "'1'.equals(#printMethType)?#isNotEmpty(#contInform):true", logicMsg = "联系方式不能为空")
    private String contInform;
    @ApiModelProperty("平台打印-联系地址")
    @Check(test = "logic", logic = "'1'.equals(#printMethType)?#isNotEmpty(#contAddress):true", logicMsg = "联系地址不能为空")
    private String contAddress;

    public Long getMineArchId() {
        return mineArchId;
    }

    public void setMineArchId(Long mineArchId) {
        this.mineArchId = mineArchId;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public Integer getRtspCodeCount() {
        return rtspCodeCount;
    }

    public void setRtspCodeCount(Integer rtspCodeCount) {
        this.rtspCodeCount = rtspCodeCount;
    }

    public String getPrintMethType() {
        return printMethType;
    }

    public void setPrintMethType(String printMethType) {
        this.printMethType = printMethType;
    }

    public String getRecipients() {
        return recipients;
    }

    public void setRecipients(String recipients) {
        this.recipients = recipients;
    }

    public String getContInform() {
        return contInform;
    }

    public void setContInform(String contInform) {
        this.contInform = contInform;
    }

    public String getContAddress() {
        return contAddress;
    }

    public void setContAddress(String contAddress) {
        this.contAddress = contAddress;
    }
}
