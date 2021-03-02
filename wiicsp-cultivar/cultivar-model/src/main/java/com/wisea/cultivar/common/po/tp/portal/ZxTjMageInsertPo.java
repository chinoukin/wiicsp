package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资讯推荐新增操作PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月31日
 * @version 1.0
 */
@ApiModel("资讯推荐新增操作PO")
public class ZxTjMageInsertPo {
    /**
     * 资讯列表id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = "required")
    @ApiModelProperty(value = "资讯列表id")
    private Long zxListId;

    /**
     * 显示顺序
     */
    @Check(test = "required")
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 获取资讯列表id
     */
    public Long getZxListId() {
        return zxListId;
    }

    /**
     * 设置资讯列表id
     */
    public void setZxListId(Long zxListId) {
        this.zxListId = zxListId;
    }

    /**
     * 获取显示顺序
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * 设置显示顺序
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
