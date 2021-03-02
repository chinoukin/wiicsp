package com.wisea.cultivar.common.po.bigdata;

import com.wisea.cloud.model.po.PagePo;
import com.wisea.cultivar.common.vo.bigdata.PlaceOriginMageListVo;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * PlaceOriginMagePagePo
 * 2019/12/02 11:02:15
 */
public class PlaceOriginMagePagePo extends PagePo<PlaceOriginMageListVo> {
    private static final long serialVersionUID = 1L;

    /**
     * 产地类型
     */
    @ApiModelProperty(value = "查询条件（产地名称/主要品类）")
    private String searchKey;

    /**
     * 产地类型
     */
    @ApiModelProperty(value = "产地类型(国内国外)")
    private String placeOriginType;

    /**
     * 所在区域
     */
    @ApiModelProperty(value = "所在区域")
    private String locationType;

    /**
     * 基地类型
     */
    @ApiModelProperty(value = "基地类型")
    private String jdType;

    @ApiModelProperty(value = "基地类型列表")
    private List<String> jdTypeList;

    /**
     * 状态
     */
    @ApiModelProperty(value = "状态")
    private String placeOriginState;

    /**
     * 获取产地类型
     */
    public String getPlaceOriginType() {
        return placeOriginType;
    }

    /**
     * 设置产地类型
     */
    public void setPlaceOriginType(String placeOriginType) {
        this.placeOriginType = placeOriginType == null ? null : placeOriginType.trim();
    }

    /**
     * 获取基地类型
     */
    public String getJdType() {
        return jdType;
    }

    /**
     * 设置基地类型
     */
    public void setJdType(String jdType) {
        this.jdType = jdType == null ? null : jdType.trim();
    }

    public String getSearchKey() {
        return searchKey;
    }

    public void setSearchKey(String searchKey) {
        this.searchKey = searchKey;
    }

    public List<String> getJdTypeList() {
        return jdTypeList;
    }

    public void setJdTypeList(List<String> jdTypeList) {
        this.jdTypeList = jdTypeList;
    }

    public String getLocationType() {
        return locationType;
    }

    public void setLocationType(String locationType) {
        this.locationType = locationType;
    }

    /**
     * 获取状态
     */
    public String getPlaceOriginState() {
        return placeOriginState;
    }

    /**
     * 设置状态
     */
    public void setPlaceOriginState(String placeOriginState) {
        this.placeOriginState = placeOriginState == null ? null : placeOriginState.trim();
    }
}
