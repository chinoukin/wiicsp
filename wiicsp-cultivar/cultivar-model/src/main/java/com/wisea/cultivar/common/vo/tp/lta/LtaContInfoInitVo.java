package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 合同基本信息的VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月8日
 * @version 1.0
 */
@ApiModel("合同基本信息的VO")
public class LtaContInfoInitVo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id")
	private Long id;

	@ApiModelProperty(value = "合同编号")
    private String ltaContNumb;//合同编号

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "合同开始时间")
    private OffsetDateTime contStartDate;//合同开始时间

	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	@ApiModelProperty(value = "合同结束时间")
    private OffsetDateTime contEndDate;//合同结束时间

	@ApiModelProperty(value = "结算支付类型")
    private String payMethodType;//结算支付类型

	@ApiModelProperty(value = "物流服务类型")
    private String logisticsSerType;//物流服务类型

	@ApiModelProperty(value = "供应商品")
    private String supplyComm;//供应商品

	@ApiModelProperty(value = "合同模板")
    private String contTemp;//合同模板

	@ApiModelProperty(value = "供应商信息")
	private LtaContEntpInfoVo sellerInfo;

	@ApiModelProperty(value = "采购商信息")
	private LtaContEntpInfoVo buyerInfo;

	@ApiModelProperty(value = "合同附件列表")
	private List<LtaContFileVo> fileList;

	@ApiModelProperty(value = "排他字段(修改的场合需要传入)")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLtaContNumb() {
		return ltaContNumb;
	}

	public void setLtaContNumb(String ltaContNumb) {
		this.ltaContNumb = ltaContNumb;
	}

	public OffsetDateTime getContStartDate() {
		return contStartDate;
	}

	public void setContStartDate(OffsetDateTime contStartDate) {
		this.contStartDate = contStartDate;
	}

	public OffsetDateTime getContEndDate() {
		return contEndDate;
	}

	public void setContEndDate(OffsetDateTime contEndDate) {
		this.contEndDate = contEndDate;
	}

	public String getPayMethodType() {
		return payMethodType;
	}

	public void setPayMethodType(String payMethodType) {
		this.payMethodType = payMethodType;
	}

	public String getLogisticsSerType() {
		return logisticsSerType;
	}

	public void setLogisticsSerType(String logisticsSerType) {
		this.logisticsSerType = logisticsSerType;
	}

	public String getSupplyComm() {
		return supplyComm;
	}

	public void setSupplyComm(String supplyComm) {
		this.supplyComm = supplyComm;
	}

	public String getContTemp() {
		return contTemp;
	}

	public void setContTemp(String contTemp) {
		this.contTemp = contTemp;
	}

	public List<LtaContFileVo> getFileList() {
		return fileList;
	}

	public void setFileList(List<LtaContFileVo> fileList) {
		this.fileList = fileList;
	}

	public LtaContEntpInfoVo getSellerInfo() {
		return sellerInfo;
	}

	public void setSellerInfo(LtaContEntpInfoVo sellerInfo) {
		this.sellerInfo = sellerInfo;
	}

	public LtaContEntpInfoVo getBuyerInfo() {
		return buyerInfo;
	}

	public void setBuyerInfo(LtaContEntpInfoVo buyerInfo) {
		this.buyerInfo = buyerInfo;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}
}
