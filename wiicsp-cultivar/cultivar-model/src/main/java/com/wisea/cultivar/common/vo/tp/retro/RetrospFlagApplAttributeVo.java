package com.wisea.cultivar.common.vo.tp.retro;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author jirg
 * @version 1.0
 * @className RetrospFlagApplAttributeVo
 * @date 2019/12/20 11:18
 * @Description 追溯标签申请记录属性
 */
@ApiModel("追溯标签申请记录属性")
public class RetrospFlagApplAttributeVo {
    @ApiModelProperty("属性名称")
    private String attributeName;
    @ApiModelProperty("属性内容")
    private String attributeContent;
    @ApiModelProperty("排序")
    private Integer sort;

    public String getAttributeName() {
        return attributeName;
    }

    public void setAttributeName(String attributeName) {
        this.attributeName = attributeName;
    }

    public String getAttributeContent() {
        return attributeContent;
    }

    public void setAttributeContent(String attributeContent) {
        this.attributeContent = attributeContent;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
