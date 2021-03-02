package com.wisea.cultivar.common.po.tp.lta;

import java.time.OffsetDateTime;
import java.util.List;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 新增长协合同的PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月7日
 * @version 1.0
 */
@ApiModel("新增长协合同的PO")
public class LtaContInfoInsertPo {

	@JsonSerialize(using = IdSerializer.class)
    @ApiModelProperty(value = "id(新增的时候为空，修改不为空)")
	private Long id;

	@ApiModelProperty(value="合同编号")
	@Check(test = {"logic"},logic = "#isEmpty(#id)?#isNotEmpty(#ltaContNumb):true",logicMsg = "新增的情况合同编码不能为空")
	private String ltaContNumb;

	@ApiModelProperty(value="采购商名称")
	@Check(test = {"logic"},logic = "#isEmpty(#id)?#isNotEmpty(#sellerName):true",logicMsg = "新增合同采购商名称不能为空")
	private String sellerName;//采购商名称

	@ApiModelProperty(value="合同开始时间")
	@Check(test = "required")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime contStartDate;//合同开始时间

	@ApiModelProperty(value="合同结束时间")
	@Check(test = "required")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    private OffsetDateTime contEndDate;//合同结束时间

	@ApiModelProperty(value="结算支付类型")
	@Check(test = "required")
    private String payMethodType;//结算支付类型

	@ApiModelProperty(value="流服务类型")
	@Check(test = "required")
    private String logisticsSerType;//物流服务类型

	@ApiModelProperty(value="供应商品")
	@Check(test = "required")
    private String supplyComm;// 供应商品

	@ApiModelProperty(value="合同模板")
	@Check(test = "required")
    private String contTemp;//合同模板

	@ApiModelProperty(value="合同附件信息")
	private List<LtaContFilePo> contFileList;

	@ApiModelProperty(value="排他字段(修改的情况必填)")
	@Check(test = {"logic"},logic = "#isNotEmpty(#id)?#isNotEmpty(#updateDate):true",logicMsg = "排他字段(修改的情况必填)")
	@JsonSerialize(using = OffsetDateTimeSerializer.class)
	@JsonDeserialize(using = OffsetDateTimeDeserializer.class)
	private OffsetDateTime updateDate;

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String sellerName) {
		this.sellerName = sellerName;
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

	public List<LtaContFilePo> getContFileList() {
		return contFileList;
	}

	public void setContFileList(List<LtaContFilePo> contFileList) {
		this.contFileList = contFileList;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public OffsetDateTime getUpdateDate() {
		return updateDate;
	}

	public void setUpdateDate(OffsetDateTime updateDate) {
		this.updateDate = updateDate;
	}

	public String getLtaContNumb() {
		return ltaContNumb;
	}

	public void setLtaContNumb(String ltaContNumb) {
		this.ltaContNumb = ltaContNumb;
	}
}
