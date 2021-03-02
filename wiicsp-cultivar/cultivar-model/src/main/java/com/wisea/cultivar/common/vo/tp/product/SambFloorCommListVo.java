package com.wisea.cultivar.common.vo.tp.product;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @Description: 中小零批楼层对应的品类,品种列表信息
 * @author: wangs
 * @date :2019/5/29
 */
@ApiModel("中小零批楼层对应的品类,品种列表信息")
public class SambFloorCommListVo {

    @ApiModelProperty("记录id")
    private Long id;
    /**
     * 中小零批页楼层id
     */
    @ApiModelProperty("中小零批页楼层id")
    private Long sambFloorId;

    /**
     * 商品分类
     */
    @ApiModelProperty("商品分类")
    private Long commId;

    /**
     * 商品品种
     */
    @ApiModelProperty("商品品种")
    private Long commVarietId;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    private Integer sort;

    private String remarks;

    private String delFlag;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public String getDelFlag() {
        return delFlag;
    }

    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    public Long getSambFloorId() {
        return sambFloorId;
    }

    public void setSambFloorId(Long sambFloorId) {
        this.sambFloorId = sambFloorId;
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

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
