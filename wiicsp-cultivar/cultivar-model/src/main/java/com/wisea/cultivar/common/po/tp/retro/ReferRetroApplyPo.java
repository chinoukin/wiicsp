package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 提交追溯标签申请PO
 */
@ApiModel("提交追溯标签申请PO")
public class ReferRetroApplyPo {
    @ApiModelProperty("发布商品ID")
    @Check(test = "required")
    private Long commPubId;
    @ApiModelProperty("申请数量")
    @Check(test = "required")
    private Integer applCount;
    @ApiModelProperty("追溯标签类型(0:平台印刷 、1:自行打印)")
    @Check(test = "required")
    private String retroLabelType;
    @ApiModelProperty(value = "收货人姓名")
    @Check(test = "logic", logic = "'0'.equals(#retroLabelType)?#isNotEmpty(#receName):true", logicMsg = "收货人姓名不能为空")
    private String receName;
    @ApiModelProperty("收货人联系方式")
    @Check(test = "logic", logic = "'0'.equals(#retroLabelType)?#isNotEmpty(#tel):true", logicMsg = "收货人手机号码不能为空")
    private String tel;
    @ApiModelProperty(value = "收货地址省")
    @Check(test = "logic", logic = "'0'.equals(#retroLabelType)?#isNotEmpty(#addressProv):true", logicMsg = "收货地址省不能为空")
    private String addressProv;
    @ApiModelProperty(value = "收货地址市")
    @Check(test = "logic", logic = "'0'.equals(#retroLabelType)?#isNotEmpty(#addressCity):true", logicMsg = "收货地址市不能为空")
    private String addressCity;
    @ApiModelProperty(value = "收货地址区县")
    @Check(test = "logic", logic = "'0'.equals(#retroLabelType)?#isNotEmpty(#addressCou):true", logicMsg = "收货地址区县不能为空")
    private String addressCou;
    @ApiModelProperty(value = "收货详细地址")
    @Check(test = "logic", logic = "'0'.equals(#retroLabelType)?#isNotEmpty(#addressDetail):true", logicMsg = "收货详细地址不能为空")
    private String addressDetail;
    @ApiModelProperty("收货地址邮政编码")
    private String zipCode;


    public Long getCommPubId() {
        return commPubId;
    }

    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    public Integer getApplCount() {
        return applCount;
    }

    public void setApplCount(Integer applCount) {
        this.applCount = applCount;
    }

    public String getRetroLabelType() {
        return retroLabelType;
    }

    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType;
    }

    public String getReceName() {
        return receName;
    }

    public void setReceName(String receName) {
        this.receName = receName;
    }

    public String getAddressProv() {
        return addressProv;
    }

    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv;
    }

    public String getAddressCity() {
        return addressCity;
    }

    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity;
    }

    public String getAddressCou() {
        return addressCou;
    }

    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }
}
