package com.wisea.cultivar.common.po.tp.system;

import com.wisea.cultivar.common.vo.tp.system.ZzjdZzmsMageListVo;
import com.wisea.cloud.model.po.PagePo;
import io.swagger.annotations.ApiModelProperty;

/**
 * zzjd_zzms_mage 表实体
 * 种植基地种植亩数管理
 * 2019/08/29 17:45:19
 */
public class ZzjdZzmsMagePagePo extends PagePo<ZzjdZzmsMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 种植基地名称
     */
    @ApiModelProperty("种植基地名称")
    private String zzjdName;

    /**
     * 实测面积
     */
    @ApiModelProperty("实测面积")
    private Double scMj;

    /**
     * 地区
     */
    @ApiModelProperty("地区")
    private String address;

    /**
     * 联系电话
     */
    @ApiModelProperty("联系电话")
    private String tel;

    @ApiModelProperty("搜索字段")
    private String search;

    @ApiModelProperty(value = "排序字段",hidden = true)
    private String sort;

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    /**
     * 获取种植基地名称
     */
    public String getZzjdName() {
        return zzjdName;
    }

    /**
     * 设置种植基地名称
     */
    public void setZzjdName(String zzjdName) {
        this.zzjdName = zzjdName == null ? null : zzjdName.trim();
    }

    /**
     * 获取实测面积
     */
    public Double getScMj() {
        return scMj;
    }

    /**
     * 设置实测面积
     */
    public void setScMj(Double scMj) {
        this.scMj = scMj;
    }

    /**
     * 获取地区
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置地区
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 获取联系电话
     */
    public String getTel() {
        return tel;
    }

    /**
     * 设置联系电话
     */
    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }
}
