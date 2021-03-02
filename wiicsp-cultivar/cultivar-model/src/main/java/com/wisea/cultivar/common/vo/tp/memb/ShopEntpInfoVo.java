package com.wisea.cultivar.common.vo.tp.memb;

import java.util.List;

import com.wisea.cultivar.common.vo.tp.EntpCertInitVo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 诚信档案的基本信息VO
 *
 * @author wangh(wisea)
 *
 * @date 2019年12月12日
 * @version 1.0
 */
@ApiModel("诚信档案的基本信息VO")
public class ShopEntpInfoVo extends MembCompInfoVo{

	@ApiModelProperty("证书信息")
	private List<EntpCertInitVo> entpCerList;

	@ApiModelProperty("认证信息")
	private EntpDataInfoForShopVo entpDataInfo;

	public List<EntpCertInitVo> getEntpCerList() {
		return entpCerList;
	}

	public void setEntpCerList(List<EntpCertInitVo> entpCerList) {
		this.entpCerList = entpCerList;
	}

	public EntpDataInfoForShopVo getEntpDataInfo() {
		return entpDataInfo;
	}

	public void setEntpDataInfo(EntpDataInfoForShopVo entpDataInfo) {
		this.entpDataInfo = entpDataInfo;
	}
}
