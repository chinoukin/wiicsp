package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className ApplRetrospPo
 * @date 2019/12/20 14:19
 * @Description 申请追溯标签Po
 */
@ApiModel("申请追溯标签Po")
public class ApplRetrospPo {
    @ApiModelProperty("批次id")
    @Check(test = "required")
    private Long retrospPcMageId;
    @ApiModelProperty("产地")
    @Check(test = {"required", "maxLength"}, length = 14, lengthMsg = "产地最大长度不能超过14个字")
    private String placeOrigin;
    @ApiModelProperty("产品名称")
    @Check(test = {"required", "maxLength"}, length = 26, lengthMsg = "产品名称最大长度不能超过26个字")
    private String prdutName;
    @ApiModelProperty("申请类型")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "申请类型只能是自行打印或平台打印")
    private String retroLabelType;
    @ApiModelProperty("申请方式类型")
    @Check(test = {"required", "liveable"}, liveable = {"0", "1"}, liveableMsg = "申请方式只能是打印文件或数据文件")
    private String applModeType;
    @ApiModelProperty("收获地址ID")
    @Check(test = {"logic"}, logic = "'0'.equals(#retroLabelType)?#isNotEmpty(#refundCommAddressId):true", logicMsg = "申请类为平台印刷时，收货地址不能为空")
    private Long refundCommAddressId;
    @ApiModelProperty("申请数量")
    @Check(test = {"required", "logic"}, logic = "'0'.equals(#applModeType)?(#applSl<=500?true:false):(#applSl<=10000?true:false)", logicMsg = "打印文件申请上限为500，数据文件申请上限为10000")
    private Integer applSl;
    @ApiModelProperty("属性列表")
    @Check(test = "", nullSkip = true, cascade = true)
    private List<ApplRetrospAttributePo> attributes;

    public Long getRetrospPcMageId() {
        return retrospPcMageId;
    }

    public void setRetrospPcMageId(Long retrospPcMageId) {
        this.retrospPcMageId = retrospPcMageId;
    }

    public String getPlaceOrigin() {
        return placeOrigin;
    }

    public void setPlaceOrigin(String placeOrigin) {
        this.placeOrigin = placeOrigin;
    }

    public String getPrdutName() {
        return prdutName;
    }

    public void setPrdutName(String prdutName) {
        this.prdutName = prdutName;
    }

    public String getRetroLabelType() {
        return retroLabelType;
    }

    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType;
    }

    public String getApplModeType() {
        return applModeType;
    }

    public void setApplModeType(String applModeType) {
        this.applModeType = applModeType;
    }

    public Integer getApplSl() {
        return applSl;
    }

    public void setApplSl(Integer applSl) {
        this.applSl = applSl;
    }

    public Long getRefundCommAddressId() {
        return refundCommAddressId;
    }

    public void setRefundCommAddressId(Long refundCommAddressId) {
        this.refundCommAddressId = refundCommAddressId;
    }

    public List<ApplRetrospAttributePo> getAttributes() {
        return attributes;
    }

    public void setAttributes(List<ApplRetrospAttributePo> attributes) {
        this.attributes = attributes;
    }
}
