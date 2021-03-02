package com.wisea.cultivar.common.po.tp.portal;

import java.time.OffsetDateTime;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeDeserializer;
import com.wisea.cloud.model.annotation.OffsetDateTimeSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 水果价格插入需要的具体参数PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年5月30日
 * @version 1.0
 */
@ApiModel("水果价格插入需要的具体参数PO")
public class FruitsPriceInsPo {

    @JsonSerialize(using = OffsetDateTimeSerializer.class)
    @JsonDeserialize(using = OffsetDateTimeDeserializer.class)
    @ApiModelProperty(value = "日期")
    @Check(test ="required")
    private OffsetDateTime fpDate;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = {"required","maxLength"}, length = 19)
    @ApiModelProperty(value = "商品分类-子节点")
    private Long commId;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = {"required","maxLength"}, length = 19)
    @ApiModelProperty(value = "商品品种")
    private Long commVarietId;

    @Check(test = {"required","maxLength"}, mixLength = 20)
    @ApiModelProperty(value = "地区-省")
    private String areaProv;

    @Check(test = {"required","maxLength"}, mixLength = 20)
    @ApiModelProperty(value = "地区-市")
    private String areaCity;

    @Check(test = { "maxLength" }, mixLength = 20)
    @ApiModelProperty(value = "地区-区县")
    private String areaCou;

    @Check(test = {"required","regex"}, regex = "^0$|^(0\\.[0-9]+)$|^[1-9]\\d*(\\.[0-9]+)?$")
    @ApiModelProperty(value = "单价")
    private Double price;

    @ApiModelProperty(value = "地区(中文)")
    private String areaDetail;

    @ApiModelProperty(value = "品类名称")
    private String commName;

    @ApiModelProperty(value = "品种名称")
    private String commVarietName;

    @JsonSerialize(using = IdSerializer.class)
    @Check(test = {"required","maxLength"}, length = 19)
    @ApiModelProperty(value = "商品分类-父节点")
    private Long commPid;

	public OffsetDateTime getFpDate() {
		return fpDate;
	}

	public void setFpDate(OffsetDateTime fpDate) {
		this.fpDate = fpDate;
	}

	public Long getCommId() {
		return commId;
	}

	public void setCommId(Long commId) {
		this.commId = commId;
	}

	public Long getCommVarietId() {
		return commVarietId;
	}

	public void setCommVarietId(Long commVarietId) {
		this.commVarietId = commVarietId;
	}

	public String getAreaProv() {
		return areaProv;
	}

	public void setAreaProv(String areaProv) {
		this.areaProv = areaProv;
	}

	public String getAreaCity() {
		return areaCity;
	}

	public void setAreaCity(String areaCity) {
		this.areaCity = areaCity;
	}

	public String getAreaCou() {
		return areaCou;
	}

	public void setAreaCou(String areaCou) {
		this.areaCou = areaCou;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public String getAreaDetail() {
		return areaDetail;
	}

	public void setAreaDetail(String areaDetail) {
		this.areaDetail = areaDetail;
	}

	public String getCommName() {
		return commName;
	}

	public void setCommName(String commName) {
		this.commName = commName;
	}

	public String getCommVarietName() {
		return commVarietName;
	}

	public void setCommVarietName(String commVarietName) {
		this.commVarietName = commVarietName;
	}

	public Long getCommPid() {
		return commPid;
	}

	public void setCommPid(Long commPid) {
		this.commPid = commPid;
	}
}
