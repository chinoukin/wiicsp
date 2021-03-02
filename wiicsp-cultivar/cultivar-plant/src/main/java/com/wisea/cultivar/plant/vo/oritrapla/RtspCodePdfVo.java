package com.wisea.cultivar.plant.vo.oritrapla;

import com.wisea.cloud.common.util.excel.annotation.ExcelField;

/**
 * Auth： jirg
 * CreateDate:  2018/6/7
 * projectName:  oritrapla
 * remark:
 */
public class RtspCodePdfVo {

    //PDF、excel公用字段
    @ExcelField(title = "追溯码编号", sort = 0, width = 20)
    private String rtspCode; //追溯码
    @ExcelField(title = "批次编号", sort = 1, width = 10)
    private String batchNum;
    @ExcelField(title = "产品名称", sort = 2, width = 15)
    private String productName;
    @ExcelField(title = "所属地块", sort = 3, width = 10)
    private String massifName;
    @ExcelField(title = "档案编号", sort = 4, width = 10)
    private String archNum; //档案编号
    @ExcelField(title = "企业名称", sort = 5, width = 20)
    private String orgName; //农场或公司名称
    @ExcelField(title = "追溯地址", sort = 6, width = 60)
    private String qrCodeStr;

    //PDF字段
    private Integer rtspCodeCount; //追溯码数量
    private String commName; //品种名称-只显示第三级
    private String commVarietName; //品种名称
    private String qrCodeImgBase64; //二维码图片base64编码


    public String getRtspCode() {
        return rtspCode;
    }

    public void setRtspCode(String rtspCode) {
        this.rtspCode = rtspCode;
    }

    public String getBatchNum() {
        return batchNum;
    }

    public void setBatchNum(String batchNum) {
        this.batchNum = batchNum;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getMassifName() {
        return massifName;
    }

    public void setMassifName(String massifName) {
        this.massifName = massifName;
    }

    public String getArchNum() {
        return archNum;
    }

    public void setArchNum(String archNum) {
        this.archNum = archNum;
    }

    public String getOrgName() {
        return orgName;
    }

    public void setOrgName(String orgName) {
        this.orgName = orgName;
    }

    public String getQrCodeStr() {
        return qrCodeStr;
    }

    public void setQrCodeStr(String qrCodeStr) {
        this.qrCodeStr = qrCodeStr;
    }

    public Integer getRtspCodeCount() {
        return rtspCodeCount;
    }

    public void setRtspCodeCount(Integer rtspCodeCount) {
        this.rtspCodeCount = rtspCodeCount;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getCommVarietName() {
        return commVarietName;
    }

    public void setCommVarietName(String commVarietName) {
        this.commVarietName = commVarietName;
    }

    public String getQrCodeImgBase64() {
        return qrCodeImgBase64;
    }

    public void setQrCodeImgBase64(String qrCodeImgBase64) {
        this.qrCodeImgBase64 = qrCodeImgBase64;
    }
}
