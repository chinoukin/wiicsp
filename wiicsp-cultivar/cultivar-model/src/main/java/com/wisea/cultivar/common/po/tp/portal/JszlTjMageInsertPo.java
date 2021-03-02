package com.wisea.cultivar.common.po.tp.portal;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.wisea.cloud.model.annotation.Check;
import com.wisea.cloud.model.annotation.IdSerializer;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 资料推荐设置插入PO
 *
 * @author wangh(wisea)
 *
 * @date 2019年8月30日
 * @version 1.0
 */
@ApiModel("资料推荐设置插入PO")
public class JszlTjMageInsertPo {
    /**
     * 技术资料列表id
     */
    @JsonSerialize(using = IdSerializer.class)
    @Check(test = { "maxLength","required"}, length = 19)
    @ApiModelProperty(value = "技术资料列表id")
    private Long jszlListId;

    /**
     * 显示顺序
     */
    @Check(test = { "maxLength","required" }, length = 10)
    @ApiModelProperty(value = "显示顺序")
    private Integer sort;

    /**
     * 获取技术资料列表id
     */
    public Long getJszlListId() {
        return jszlListId;
    }

    /**
     * 设置技术资料列表id
     */
    public void setJszlListId(Long jszlListId) {
        this.jszlListId = jszlListId;
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
