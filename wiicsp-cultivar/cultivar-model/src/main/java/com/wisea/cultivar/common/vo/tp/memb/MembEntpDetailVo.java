package com.wisea.cultivar.common.vo.tp.memb;

import java.util.List;

import com.wisea.cultivar.common.vo.tp.EntpCertInitVo;
import com.wisea.cultivar.common.vo.tp.EntpPictureListVo;
import com.wisea.cultivar.common.vo.tp.ExamRecdListVo;
import com.wisea.cultivar.common.vo.tp.system.SellerSpeSerCostMageListVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 会员企业详细信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年4月24日
 * @version 1.0
 */
@ApiModel("会员企业详细信息VO")
public class MembEntpDetailVo {

	@ApiModelProperty(value="会员Id")
	private Long id;
	/**
     * 注册信息
     */
	@ApiModelProperty(value = "注册信息")
    private UserRegisterInfoVo userRegisterInfoVo;
	/**
     * 企业认证审核信息
     */
	@ApiModelProperty(value = "企业认证审核信息")
    private EntpDataInfoGetVo entpDataInfoGetVo;
	/**
     * 企业证书信息列表
     */
    @ApiModelProperty(value = "企业证书信息列表")
    private List<EntpCertInitVo> entpCerList;
	/**
     * 公司基本信息
     */
	@ApiModelProperty(value = "公司基本信息")
	private EntpCompAutoInfoVo entpCompAutoInfoVo;
	/**
     * 企业历史审核记录
     */
    @ApiModelProperty(value = "企业历史审核记录")
    private List<ExamRecdListVo> examRecdList;
    /**
     * 统一服务费
     */
    @ApiModelProperty(value = "统一服务费")
    private Double serCost;
    /**
     * 特殊服务费
     */
    @ApiModelProperty(value = "特殊服务费")
    private List<SellerSpeSerCostMageListVo> costMageList;
    /**
     * 企业图片列表
     */
    @ApiModelProperty(value = "企业图片列表")
    private List<EntpPictureListVo> entpPicList;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public UserRegisterInfoVo getUserRegisterInfoVo() {
		return userRegisterInfoVo;
	}
	public void setUserRegisterInfoVo(UserRegisterInfoVo userRegisterInfoVo) {
		this.userRegisterInfoVo = userRegisterInfoVo;
	}
	public EntpDataInfoGetVo getEntpDataInfoGetVo() {
		return entpDataInfoGetVo;
	}
	public void setEntpDataInfoGetVo(EntpDataInfoGetVo entpDataInfoGetVo) {
		this.entpDataInfoGetVo = entpDataInfoGetVo;
	}
	public List<EntpCertInitVo> getEntpCerList() {
		return entpCerList;
	}
	public void setEntpCerList(List<EntpCertInitVo> entpCerList) {
		this.entpCerList = entpCerList;
	}
	public List<ExamRecdListVo> getExamRecdList() {
		return examRecdList;
	}
	public void setExamRecdList(List<ExamRecdListVo> examRecdList) {
		this.examRecdList = examRecdList;
	}
	public Double getSerCost() {
		return serCost;
	}
	public void setSerCost(Double serCost) {
		this.serCost = serCost;
	}
	public List<SellerSpeSerCostMageListVo> getCostMageList() {
		return costMageList;
	}
	public void setCostMageList(List<SellerSpeSerCostMageListVo> costMageList) {
		this.costMageList = costMageList;
	}
	public List<EntpPictureListVo> getEntpPicList() {
		return entpPicList;
	}
	public void setEntpPicList(List<EntpPictureListVo> entpPicList) {
		this.entpPicList = entpPicList;
	}
	public EntpCompAutoInfoVo getEntpCompAutoInfoVo() {
		return entpCompAutoInfoVo;
	}
	public void setEntpCompAutoInfoVo(EntpCompAutoInfoVo entpCompAutoInfoVo) {
		this.entpCompAutoInfoVo = entpCompAutoInfoVo;
	}
}
