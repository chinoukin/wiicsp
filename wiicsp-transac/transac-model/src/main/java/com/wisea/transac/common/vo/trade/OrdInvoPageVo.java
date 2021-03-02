package com.wisea.transac.common.vo.trade;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 订单发票列表VO
 */
@ApiModel("订单发票列表VO")
public class OrdInvoPageVo {
	@ApiModelProperty("发票id")
    private Long id;
	@ApiModelProperty("订单id")
    private Long ordId;
	@ApiModelProperty("发票状态")
    private String invoState;
	@ApiModelProperty("申请编号")
    private String applNum;
	@ApiModelProperty("订单编号")
    private String ordNum;
	@ApiModelProperty("开票金额")
    private Double drawAmount;
	@ApiModelProperty("买家id")
    private Long buyerId;
	@ApiModelProperty("买家账号")
    private String loginName;
	@ApiModelProperty("买家手机号")
    private String registTel;
	@ApiModelProperty("买家名称")
    private String entpName;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getRegistTel() {
        return registTel;
    }
    public void setRegistTel(String registTel) {
        this.registTel = registTel;
    }
    public Long getOrdId() {
        return ordId;
    }
    public void setOrdId(Long ordId) {
        this.ordId = ordId;
    }
    public String getInvoState() {
        return invoState;
    }
    public void setInvoState(String invoState) {
        this.invoState = invoState;
    }
    public String getApplNum() {
        return applNum;
    }
    public void setApplNum(String applNum) {
        this.applNum = applNum;
    }
    public String getOrdNum() {
        return ordNum;
    }
    public void setOrdNum(String ordNum) {
        this.ordNum = ordNum;
    }
    public Double getDrawAmount() {
        return drawAmount;
    }
    public void setDrawAmount(Double drawAmount) {
        this.drawAmount = drawAmount;
    }
    public Long getBuyerId() {
        return buyerId;
    }
    public void setBuyerId(Long buyerId) {
        this.buyerId = buyerId;
    }
    public String getLoginName() {
        return loginName;
    }
    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }
    public String getEntpName() {
        return entpName;
    }
    public void setEntpName(String entpName) {
        this.entpName = entpName;
    }
}
