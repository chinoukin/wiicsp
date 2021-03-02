package com.wisea.cultivar.common.vo.tp.retro;

import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * Auth： jirg
 * CreateDate:  2018/6/7
 * remark:
 */
public class RetroLabelPdfVo {
    @ApiModelProperty("批次号")
    @ExcelField(title = "批次号", sort = 10)
    private String traceBatchNumCode;
    @ApiModelProperty("追溯码")
    @ExcelField(title = "追溯码", sort = 10)
    private String rtspCode;
    @ApiModelProperty("二维码图片base64编码")
    private String qrCodeImgBase64;
    @ApiModelProperty("商品名称")
    @ExcelField(title = "商品名称", sort = 15)
    private String commName;
    @ApiModelProperty("产品属性")
    @ExcelField(title = "产品属性", sort = 20)
    private String attributesStr;
    @ApiModelProperty("产地")
    @ExcelField(title = "产地", sort = 25)
    private String placeOrigin;
    @ApiModelProperty("生产企业")
    @ExcelField(title = "生产企业", sort = 30)
    private String compName;
    @ApiModelProperty("联系方式")
    @ExcelField(title = "联系方式", sort = 35)
    private String compTel;
    @ApiModelProperty("联系地址")
    @ExcelField(title = "联系地址", sort = 40)
    private String compAddress;
    @ApiModelProperty("属性列表")
    private List<RetrospFlagApplAttributeVo> attributes;
    @ApiModelProperty("追溯码地址")
    @ExcelField(title = "追溯码地址", sort = 45)
    private String qrCodeUrl;

    public String getTraceBatchNumCode() {
        return traceBatchNumCode;
    }

    public void setTraceBatchNumCode(String traceBatchNumCode) {
        this.traceBatchNumCode = traceBatchNumCode;
    }

    public String getRtspCode() {
        return rtspCode;
    }

    public void setRtspCode(String rtspCode) {
        this.rtspCode = rtspCode;
    }

    public String getQrCodeImgBase64() {
        return qrCodeImgBase64;
    }

    public void setQrCodeImgBase64(String qrCodeImgBase64) {
        this.qrCodeImgBase64 = qrCodeImgBase64;
    }

    public String getCommName() {
        return commName;
    }

    public void setCommName(String commName) {
        this.commName = commName;
    }

    public String getAttributesStr() {
        StringBuffer str = new StringBuffer();
        this.attributes.forEach(e->{
            if(ConverterUtil.isNotEmpty(e.getAttributeName())){
                str.append(e.getAttributeName());
                str.append("：");
                str.append(e.getAttributeContent());
                str.append("   ");
            }
        });
        return str.toString();
    }

    public void setAttributesStr(String attributesStr) {
        this.attributesStr = attributesStr;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getCompName() {
        return compName;
    }

    public void setCompName(String compName) {
        this.compName = compName;
    }

    public String getCompTel() {
        return compTel;
    }

    public void setCompTel(String compTel) {
        this.compTel = compTel;
    }

    public String getCompAddress() {
        return compAddress;
    }

    public void setCompAddress(String compAddress) {
        this.compAddress = compAddress;
    }

    public List<RetrospFlagApplAttributeVo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<RetrospFlagApplAttributeVo> attributes) {
        this.attributes = attributes;
    }

    public String getQrCodeUrl() {
        return qrCodeUrl;
    }

    public void setQrCodeUrl(String qrCodeUrl) {
        this.qrCodeUrl = qrCodeUrl;
    }
}
