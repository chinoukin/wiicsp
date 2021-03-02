package com.wisea.cultivar.common.po.tp.portal;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资资讯列表管理PO(五彩布衣资讯详情界面)
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("资讯列表管理PO(五彩布衣资讯详情界面)")
public class ZxListForDetailPo {

    /**
     * 所属分类
     */
    @ApiModelProperty(value = "所属分类(zx_catg_type 0:布依文化1:生态旅游2:糯米蕉产业资讯)")
    private String zxCatgType;
    @ApiModelProperty(value="获取的条数")
    private int num;// 获取的条数

	public String getZxCatgType() {
		return zxCatgType;
	}
	public void setZxCatgType(String zxCatgType) {
		this.zxCatgType = zxCatgType;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
}
