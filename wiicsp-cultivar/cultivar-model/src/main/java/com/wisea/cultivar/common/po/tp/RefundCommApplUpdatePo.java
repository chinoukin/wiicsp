package com.wisea.cultivar.common.po.tp;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;
import io.swagger.annotations.ApiModelProperty;
import java.time.OffsetDateTime;

/**
 * RefundCommApplUpdatePo
 * 2018/09/30 09:46:17
 */
public class RefundCommApplUpdatePo {
    /**
     * id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "required" })
    @ApiModelProperty(value = "id")
    private Long id;

    /**
     * 订单商品id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "订单商品id")
    private Long ordCommId;

    /**
     * 服务类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "服务类型")
    private String serType;

    /**
     * 退款方式
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "退款方式")
    private String refundModeType;

    /**
     * 买方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "买方ID")
    private Long buyerId;

    /**
     * 卖方ID
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "卖方ID")
    private Long sellerId;

    /**
     * 退货数量
     */
    @Check(test = { "maxLength" }, length = 10)
    @ApiModelProperty(value = "退货数量")
    private Integer refundCounts;

    /**
     * 退货原因
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "退货原因")
    private Long refundReasonId;

    /**
     * 问题描述
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "问题描述")
    private String refundDesc;

    /**
     * 商品总额(申请退款金额)
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "商品总额(申请退款金额)")
    private Double commTotalAmount;

    /**
     * 应退金额
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "应退金额")
    private Double shouldRefundAmount;

    /**
     * 平台服务费
     */
    @Check(test = { "regex" }, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "平台服务费")
    private Double platfCost;

    /**
     * 客户姓名
     */
    @Check(test = { "maxLength" }, mixLength = 100)
    @ApiModelProperty(value = "客户姓名")
    private String custName;

    /**
     * 手机号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "手机号")
    private String tel;

    /**
     * 地区省
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "地区省")
    private String addressProv;

    /**
     * 地区市
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "地区市")
    private String addressCity;

    /**
     * 地区区县
     */
    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "地区区县")
    private String addressCou;

    /**
     * 详细地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "详细地址")
    private String addressDetail;

    /**
     * 邮编
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "邮编")
    private String zipCode;

    /**
     * 服务单号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "服务单号")
    private String serNum;

    /**
     * 订单编号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "订单编号")
    private String ordNum;

    /**
     * 退货状态
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "退货状态")
    private String refundCommState;

    /**
     * 申请时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "申请时间")
    private OffsetDateTime applDate;

    /**
     * 审核服务单时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "审核服务单时间")
    private OffsetDateTime examSerBillDate;

    /**
     * 发货时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "发货时间")
    private OffsetDateTime sendDate;

    /**
     * 完成时间
     */
    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "完成时间")
    private OffsetDateTime doneDate;

    /**
     * 物流公司名称
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "物流公司名称")
    private String logisticsCompName;

    /**
     * 物流单号
     */
    @Check(test = { "maxLength" }, mixLength = 30)
    @ApiModelProperty(value = "物流单号")
    private String logisticsNum;

    /**
     * 商品寄回地址
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "商品寄回地址")
    private String commReturnAddress;

    /**
     * 处理方
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength" }, length = 19)
    @ApiModelProperty(value = "处理方")
    private String handler;

    /**
     * 处理方式类型
     */
    @Check(test = { "maxLength" }, mixLength = 5)
    @ApiModelProperty(value = "处理方式类型")
    private String handleType;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 删除标记
     */
    @Check(test = { "maxLength" }, mixLength = 1)
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
     * 获取订单商品id
     */
    public Long getOrdCommId() {
        return ordCommId;
    }

    /**
     * 设置订单商品id
     */
    public void setOrdCommId(Long ordCommId) {
        this.ordCommId = ordCommId;
    }

    /**
     * 获取服务类型
     */
    public String getSerType() {
        return serType;
    }

    /**
     * 设置服务类型
     */
    public void setSerType(String serType) {
        this.serType = serType == null ? null : serType.trim();
    }

    /**
     * 获取退款方式
     */
    public String getRefundModeType() {
        return refundModeType;
    }

    /**
     * 设置退款方式
     */
    public void setRefundModeType(String refundModeType) {
        this.refundModeType = refundModeType == null ? null : refundModeType.trim();
    }

    /**
     * 获取买方ID
     */
    public Long getBuyerId() {
        return buyerId;
    }

    /**
     * 设置买方ID
     */
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 获取卖方ID
     */
    public Long getSellerId() {
        return sellerId;
    }

    /**
     * 设置卖方ID
     */
    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    /**
     * 获取退货数量
     */
    public Integer getRefundCounts() {
        return refundCounts;
    }

    /**
     * 设置退货数量
     */
    public void setRefundCounts(Integer refundCounts) {
        this.refundCounts = refundCounts;
    }

    /**
     * 获取退货原因
     */
    public Long getRefundReasonId() {
        return refundReasonId;
    }

    /**
     * 设置退货原因
     */
    public void setRefundReasonId(Long refundReasonId) {
        this.refundReasonId = refundReasonId;
    }

    /**
     * 获取问题描述
     */
    public String getRefundDesc() {
        return refundDesc;
    }

    /**
     * 设置问题描述
     */
    public void setRefundDesc(String refundDesc) {
        this.refundDesc = refundDesc == null ? null : refundDesc.trim();
    }

    /**
     * 获取商品总额(申请退款金额)
     */
    public Double getCommTotalAmount() {
        return commTotalAmount;
    }

    /**
     * 设置商品总额(申请退款金额)
     */
    public void setCommTotalAmount(Double commTotalAmount) {
        this.commTotalAmount = commTotalAmount;
    }

    /**
     * 获取应退金额
     */
    public Double getShouldRefundAmount() {
        return shouldRefundAmount;
    }

    /**
     * 设置应退金额
     */
    public void setShouldRefundAmount(Double shouldRefundAmount) {
        this.shouldRefundAmount = shouldRefundAmount;
    }

    /**
     * 获取平台服务费
     */
    public Double getPlatfCost() {
        return platfCost;
    }

    /**
     * 设置平台服务费
     */
    public void setPlatfCost(Double platfCost) {
        this.platfCost = platfCost;
    }

    /**
     * 获取客户姓名
     */
    public String getCustName() {
        return custName;
    }

    /**
     * 设置客户姓名
     */
    public void setCustName(String custName) {
        this.custName = custName == null ? null : custName.trim();
    }

    /**
     * 获取手机号
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置手机号
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    /**
     * 获取地区省
     */
    public String getAddressProv() {
        return addressProv;
    }

    /**
     * 设置地区省
     */
    public void setAddressProv(String addressProv) {
        this.addressProv = addressProv == null ? null : addressProv.trim();
    }

    /**
     * 获取地区市
     */
    public String getAddressCity() {
        return addressCity;
    }

    /**
     * 设置地区市
     */
    public void setAddressCity(String addressCity) {
        this.addressCity = addressCity == null ? null : addressCity.trim();
    }

    /**
     * 获取地区区县
     */
    public String getAddressCou() {
        return addressCou;
    }

    /**
     * 设置地区区县
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
     * 获取服务单号
     */
    public String getSerNum() {
        return serNum;
    }

    /**
     * 设置服务单号
     */
    public void setSerNum(String serNum) {
        this.serNum = serNum == null ? null : serNum.trim();
    }

    /**
     * 获取订单编号
     */
    public String getOrdNum() {
        return ordNum;
    }

    /**
     * 设置订单编号
     */
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum == null ? null : ordNum.trim();
    }

    /**
     * 获取退货状态
     */
    public String getRefundCommState() {
        return refundCommState;
    }

    /**
     * 设置退货状态
     */
    public void setRefundCommState(String refundCommState) {
        this.refundCommState = refundCommState == null ? null : refundCommState.trim();
    }

    /**
     * 获取申请时间
     */
    public OffsetDateTime getApplDate() {
        return applDate;
    }

    /**
     * 设置申请时间
     */
    public void setApplDate(OffsetDateTime applDate) {
        this.applDate = applDate;
    }

    /**
     * 获取审核服务单时间
     */
    public OffsetDateTime getExamSerBillDate() {
        return examSerBillDate;
    }

    /**
     * 设置审核服务单时间
     */
    public void setExamSerBillDate(OffsetDateTime examSerBillDate) {
        this.examSerBillDate = examSerBillDate;
    }

    /**
     * 获取发货时间
     */
    public OffsetDateTime getSendDate() {
        return sendDate;
    }

    /**
     * 设置发货时间
     */
    public void setSendDate(OffsetDateTime sendDate) {
        this.sendDate = sendDate;
    }

    /**
     * 获取完成时间
     */
    public OffsetDateTime getDoneDate() {
        return doneDate;
    }

    /**
     * 设置完成时间
     */
    public void setDoneDate(OffsetDateTime doneDate) {
        this.doneDate = doneDate;
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
     * 获取商品寄回地址
     */
    public String getCommReturnAddress() {
        return commReturnAddress;
    }

    /**
     * 设置商品寄回地址
     */
    public void setCommReturnAddress(String commReturnAddress) {
        this.commReturnAddress = commReturnAddress == null ? null : commReturnAddress.trim();
    }

    /**
     * 获取处理方
     */
    public String getHandler() {
        return handler;
    }

    /**
     * 设置处理方
     */
    public void setHandler(String handler) {
        this.handler = handler;
    }

    /**
     * 获取处理方式类型
     */
    public String getHandleType() {
        return handleType;
    }

    /**
     * 设置处理方式类型
     */
    public void setHandleType(String handleType) {
        this.handleType = handleType == null ? null : handleType.trim();
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
