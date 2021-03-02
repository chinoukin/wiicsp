package com.wisea.cultivar.common.vo.tp.lta;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.excel.annotation.ExcelField;

import io.swagger.annotations.ApiModel;

/**
 * 长协合同导出VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月10日
 * @version 1.0
 */
@ApiModel("长协合同导出VO")
public class LtaContInfoExportVo {

	private Long id;//合同ID

	@ExcelField(title = "合同编号",sort = 10)
	private String ltaContNumb;//合同编号

	@ExcelField(title = "采购商名称",sort = 20)
	private String buyerCompName;//采购商名称

	private String sellerCompName;//供应商名称

	@JsonFormat(pattern = "yyyy-MM-dd")
	@ExcelField(title = "拟定日期",sort = 30)
	private OffsetDateTime draftContDate;//拟定日期

	@JsonFormat(pattern = "yyyy-MM-dd")
	private OffsetDateTime contStartDate;//合同开始时间

	@JsonFormat(pattern = "yyyy-MM-dd")
	private OffsetDateTime contEndDate;//合同结束时间

	@ExcelField(title = "合同状态",sort = 60)
	private String ltaContStateType;//合同状态

	@ExcelField(title = "订单数量",sort = 50)
	private int orderCount;//订单数量

	@ExcelField(title = "合同有效期",sort = 40)
	private String contDate;// 合同有效期

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

	public String getBuyerCompName() {
		return buyerCompName;
	}

	public void setBuyerCompName(String buyerCompName) {
		this.buyerCompName = buyerCompName;
	}

	public String getSellerCompName() {
		return sellerCompName;
	}

	public void setSellerCompName(String sellerCompName) {
		this.sellerCompName = sellerCompName;
	}

	public OffsetDateTime getDraftContDate() {
		return draftContDate;
	}

	public void setDraftContDate(OffsetDateTime draftContDate) {
		this.draftContDate = draftContDate;
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

	public String getLtaContStateType() {
		return ltaContStateType;
	}

	public void setLtaContStateType(String ltaContStateType) {
		this.ltaContStateType = ltaContStateType;
	}

	public int getOrderCount() {
		return orderCount;
	}

	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}

	public String getContDate() {
		String startDate = ConverterUtil.offsetDateTimeFormat(contStartDate, "yyyy-MM-dd");
		String endDate = ConverterUtil.offsetDateTimeFormat(contEndDate, "yyyy-MM-dd");
		return startDate + "至" + endDate;
	}

	public void setContDate(String contDate) {
		this.contDate = contDate;
	}
}
