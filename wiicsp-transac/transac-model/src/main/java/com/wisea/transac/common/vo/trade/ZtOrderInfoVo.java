package com.wisea.transac.common.vo.trade;

import com.wisea.cloud.model.po.LongIdPo;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className ZtOrderInfoVo
 * @date 2020/5/7 14:59
 * @Description 自提订单详情
 */
@ApiModel("自提订单详情")
public class ZtOrderInfoVo extends LongIdPo {
    @ApiModelProperty("订单编号")
    private String ordNum;
    @ApiModelProperty("提货人")
    private String consigneeName;
    @ApiModelProperty("手机号码手机号")
    private String consigneeTel;
    @ApiModelProperty("认证主体名称")
    private String authZtName;
    @ApiModelProperty("档口ID")
    private Long stallsId;
    @ApiModelProperty("所属档口")
    private String selfMentionAddressName;
    @ApiModelProperty("提货地址类型")
    private String ztAddressType;
    @ApiModelProperty("营业时间")
    private String ztBusinessHours;
    @ApiModelProperty("档口所在地省")
    private String ztAddressProv;
    @ApiModelProperty("档口所在地市")
    private String ztAddressCity;
    @ApiModelProperty("档口所在地区县")
    private String ztAddressCou;
    @ApiModelProperty("档口所在地详细地址")
    private String stallsAddress;
    @ApiModelProperty("买卖双方商量提货地址")
    private String ztAddress;
    @ApiModelProperty("自提联系人")
    private String ztContactsName;
    @ApiModelProperty("自提联系电话")
    private String ztTel;
    @ApiModelProperty("订单商品列表")
    private List<OrdCommRelaVo> ordCommRelas;

    public String getOrdNum() {
        return ordNum;
    }

    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }

    public String getConsigneeName() {
        return consigneeName;
    }

    public void setConsigneeName(String consigneeName) {
        this.consigneeName = consigneeName;
    }

    public String getConsigneeTel() {
        return consigneeTel;
    }

    public void setConsigneeTel(String consigneeTel) {
        this.consigneeTel = consigneeTel;
    }

    public String getAuthZtName() {
        return authZtName;
    }

    public void setAuthZtName(String authZtName) {
        this.authZtName = authZtName;
    }

    public Long getStallsId() {
        return stallsId;
    }

    public void setStallsId(Long stallsId) {
        this.stallsId = stallsId;
    }

    public String getSelfMentionAddressName() {
        return selfMentionAddressName;
    }

    public void setSelfMentionAddressName(String selfMentionAddressName) {
        this.selfMentionAddressName = selfMentionAddressName;
    }

    public String getZtAddressType() {
        return ztAddressType;
    }

    public void setZtAddressType(String ztAddressType) {
        this.ztAddressType = ztAddressType;
    }

    public String getZtBusinessHours() {
        return ztBusinessHours;
    }

    public void setZtBusinessHours(String ztBusinessHours) {
        this.ztBusinessHours = ztBusinessHours;
    }

    public String getZtAddressProv() {
        return ztAddressProv;
    }

    public void setZtAddressProv(String ztAddressProv) {
        this.ztAddressProv = ztAddressProv;
    }

    public String getZtAddressCity() {
        return ztAddressCity;
    }

    public void setZtAddressCity(String ztAddressCity) {
        this.ztAddressCity = ztAddressCity;
    }

    public String getZtAddressCou() {
        return ztAddressCou;
    }

    public void setZtAddressCou(String ztAddressCou) {
        this.ztAddressCou = ztAddressCou;
    }

    public String getZtAddress() {
        return ztAddress;
    }

    public void setZtAddress(String ztAddress) {
        this.ztAddress = ztAddress;
    }

    public String getStallsAddress() {
        return stallsAddress;
    }

    public void setStallsAddress(String stallsAddress) {
        this.stallsAddress = stallsAddress;
    }

    public String getZtContactsName() {
        return ztContactsName;
    }

    public void setZtContactsName(String ztContactsName) {
        this.ztContactsName = ztContactsName;
    }

    public String getZtTel() {
        return ztTel;
    }

    public void setZtTel(String ztTel) {
        this.ztTel = ztTel;
    }

    public List<OrdCommRelaVo> getOrdCommRelas() {
        return ordCommRelas;
    }

    public void setOrdCommRelas(List<OrdCommRelaVo> ordCommRelas) {
        this.ordCommRelas = ordCommRelas;
    }
}
