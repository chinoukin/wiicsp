package com.wisea.cultivar.common.po.tp.memb;

import com.wisea.cloud.model.annotation.Check;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * 会员公司信息的保存PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月16日
 * @version 1.0
 */
@ApiModel("会员公司信息的保存PO")
public class MembCompInfoPo {

	@ApiModelProperty(value = "会员ID",hidden=true)
	private Long id;
	/**
     * 公司名称
     */
	@Check(test = "required")
    @ApiModelProperty(value = "公司名称")
    private String entpName;

    /**
     * 公司类别类型
     */
	@Check(test = {"required", "liveable"}, liveable = {"0", "1","2","3"}, liveableMsg = "公司类别类型只能0~3")
    @ApiModelProperty(value = "公司类别类型(0:企业单位1:事业单位或社会团体2:个体经营3:个人)")
    private String compCatgType;

    /**
     * 我的部门
     */
    @ApiModelProperty(value = "我的部门")
    private String myDept;

    /**
     * 我的职位
     */
    @ApiModelProperty(value = "我的职位")
    private String myPosition;

    /**
     * 经营模式类型
     */
    @Check(test = {"required", "liveable"}, liveable = {"0", "1","2","3","4"}, liveableMsg = "经营模式类型只能0~4")
    @ApiModelProperty(value = "经营模式类型(0:生产基地1:加工厂商2:商业服务3:其它4:经销批发)")
    private String mageModelType;

    /**
     * 采购产品(主营产品)
     */
    @Check(test = "logic", logic = "#isEmpty(#salePrdut)?#isNotEmpty(#purchasePrdut):true", logicMsg = "当销售产品为空的情况，采购产品不能为空")
    @ApiModelProperty(value = "采购产品(主营产品)")
    private String purchasePrdut;

    /**
     * 销售产品(主营产品)
     */
    @Check(test = "logic", logic = "#isEmpty(#purchasePrdut)?#isNotEmpty(#salePrdut):true", logicMsg = "当采购产品为空的情况，销售产品不能为空")
    @ApiModelProperty(value = "销售产品(主营产品)")
    private String salePrdut;

    /**
     * 公司网址
     */
    @ApiModelProperty(value = "公司网址")
    private String compWebsite;

    /**
     * 公司介绍
     */
    @ApiModelProperty(value = "公司介绍")
    private String compIntroduce;

	public String getEntpName() {
		return entpName;
	}

	public void setEntpName(String entpName) {
		this.entpName = entpName;
	}

	public String getCompCatgType() {
		return compCatgType;
	}

	public void setCompCatgType(String compCatgType) {
		this.compCatgType = compCatgType;
	}

	public String getMyDept() {
		return myDept;
	}

	public void setMyDept(String myDept) {
		this.myDept = myDept;
	}

	public String getMyPosition() {
		return myPosition;
	}

	public void setMyPosition(String myPosition) {
		this.myPosition = myPosition;
	}

	public String getMageModelType() {
		return mageModelType;
	}

	public void setMageModelType(String mageModelType) {
		this.mageModelType = mageModelType;
	}

	public String getPurchasePrdut() {
		return purchasePrdut;
	}

	public void setPurchasePrdut(String purchasePrdut) {
		this.purchasePrdut = purchasePrdut;
	}

	public String getSalePrdut() {
		return salePrdut;
	}

	public void setSalePrdut(String salePrdut) {
		this.salePrdut = salePrdut;
	}

	public String getCompWebsite() {
		return compWebsite;
	}

	public void setCompWebsite(String compWebsite) {
		this.compWebsite = compWebsite;
	}

	public String getCompIntroduce() {
		return compIntroduce;
	}

	public void setCompIntroduce(String compIntroduce) {
		this.compIntroduce = compIntroduce;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
