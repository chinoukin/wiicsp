package com.wisea.cultivar.common.po.tp.portal;

import com.wisea.cultivar.common.vo.tp.portal.ZxListMageListVo;
import com.wisea.cloud.model.po.PagePo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯列表管理分页查询操作PO(五彩布衣)
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("资讯列表管理分页查询操作PO(五彩布衣)")
public class ZxListMagePageForIndexPo extends PagePo<ZxListMageListVo> {
    private static final long serialVersionUID = 1L;


    /**
     * 所属分类
     */
    @ApiModelProperty(value = "所属分类(zx_catg_type 0:布依文化1:生态旅游2:糯米蕉产业资讯)")
    private String zxCatgType;

	public String getZxCatgType() {
		return zxCatgType;
	}
	public void setZxCatgType(String zxCatgType) {
		this.zxCatgType = zxCatgType;
	}
}
