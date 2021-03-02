package com.wisea.cultivar.common.po.tp.retro;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.tp.retro.RetroLabelMageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.time.OffsetDateTime;

/**
 * RetroLabelMagePagePo
 * 2018/10/11 09:24:35
 */
public class RetroLabelMagePagePo extends PagePo<RetroLabelMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 商品发布id
     */
    @JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "商品发布id")
    private Long commPubId;

    /**
     * 申请数量
     */
    @ApiModelProperty(value = "申请数量")
    private Integer applCount;

    /**
     * 申请日期
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请日期")
    private OffsetDateTime applDate;

    /**
     * 追溯标签类型
     */
    @ApiModelProperty(value = "追溯标签类型")
    private String retroLabelType;

    /**
     * 追溯标签状态
     */
    @ApiModelProperty(value = "追溯标签状态")
    private String retroLabelState;

    /**
     * 收件人
     */
    @ApiModelProperty(value = "收件人")
    private String receName;

    /**
     * 所在地区省
     */
    @ApiModelProperty(value = "所在地区省")
    private String addressProv;

    /**
     * 所在地区市
     */
    @ApiModelProperty(value = "所在地区市")
    private String addressCity;

    /**
     * 所在地区区县
     */
    @ApiModelProperty(value = "所在地区区县")
    private String addressCou;

    /**
     * 详细地址
     */
    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    /**
     * 邮编
     */
    @ApiModelProperty(value = "邮编")
    private String zipCode;

    /**
     * 手机号码
     */
    @ApiModelProperty(value = "手机号码")
    private String tel;

    /**
     * 物流公司名称
     */
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;

    /**
     * 物流单号
     */
    @ApiModelProperty(value = "物流单号")
    private String logisticsNum;

    /**
     * 备注
     */
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @ApiModelProperty(value = "删除标记")
    private String delFlag;

    /**
     * 获取id
     */
    public Long getId() {
        return id;
    }

    /**
     * 设置id
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * 获取商品发布id
     */
    public Long getCommPubId() {
        return commPubId;
    }

    /**
     * 设置商品发布id
     */
    public void setCommPubId(Long commPubId) {
        this.commPubId = commPubId;
    }

    /**
     * 获取申请数量
     */
    public Integer getApplCount() {
        return applCount;
    }

    /**
     * 设置申请数量
     */
    public void setApplCount(Integer applCount) {
        this.applCount = applCount;
    }

    /**
     * 获取申请日期
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请日期
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取追溯标签类型
     */
    public String getRetroLabelType() {
        return retroLabelType;
    }

    /**
     * 设置追溯标签类型
     */
    public void setRetroLabelType(String retroLabelType) {
        this.retroLabelType = retroLabelType == null ? null : retroLabelType.trim();
    }

    /**
     * 获取追溯标签状态
     */
    public String getRetroLabelState() {
        return retroLabelState;
    }

    /**
     * 设置追溯标签状态
     */
    public void setRetroLabelState(String retroLabelState) {
        this.retroLabelState = retroLabelState == null ? null : retroLabelState.trim();
    }

    /**
     * 获取收件人
     */
    public String getReceName() {
        return receName;
    }

    /**
     * 设置收件人
     */
    public void setReceName(String receName) {
        this.receName = receName == null ? null : receName.trim();
    }

    /**
     * 获取所在地区省
     */
    public String getAddressProv() {
        return addressProv;
    }

    /**
     * 设置所在地区省
     */
    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv == null ? null : addressProv.trim();
    }

    /**
     * 获取所在地区市
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * 设置所在地区市
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    /**
     * 获取所在地区区县
     */
    public String getAddressCou() {
        return addressCou;
    }

    /**
     * 设置所在地区区县
     */
    public void setAddressCou(String addressCou) {
        this.addressCou = addressCou == null ? null : addressCou.trim();
    }

    /**
     * 获取详细地址
     */
    public String getAddressDetail() {
        return addressDetail;
    }

    /**
     * 设置详细地址
     */
    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail == null ? null : addressDetail.trim();
    }

    /**
     * 获取邮编
     */
    public String getZipCode() {
        return zipCode;
    }

    /**
     * 设置邮编
     */
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode == null ? null : zipCode.trim();
    }

    /**
     * 获取手机号码
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号码
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取物流公司名称
     */
    public String getLogisticsCompName() {
        return logisticsCompName;
    }

    /**
     * 设置物流公司名称
     */
    public void setLogisticsCompName(String logisticsCompName) {
        this.logisticsCompName = logisticsCompName == null ? null : logisticsCompName.trim();
    }

    /**
     * 获取物流单号
     */
    public String getLogisticsNum() {
        return logisticsNum;
    }

    /**
     * 设置物流单号
     */
    public void setLogisticsNum(String logisticsNum) {
        this.logisticsNum = logisticsNum == null ? null : logisticsNum.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 获取删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 设置删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag == null ? null : delFlag.trim();
    }
}
