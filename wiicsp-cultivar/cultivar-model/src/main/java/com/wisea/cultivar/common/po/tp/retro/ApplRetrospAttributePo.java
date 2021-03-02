package com.wisea.cultivar.common.po.tp.retro;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className ApplRetrospPo
 * @date 2019/12/20 14:19
 * @Description 申请追溯标签属性Po
 */
@ApiModel("申请追溯标签属性Po")
public class ApplRetrospAttributePo {
    @ApiModelProperty("属性名称")
    @Check(test = {"logic"}, logic = "#isEmpty(#attributeContent)?#isNotEmpty(#attributeName):true", logicMsg = "属性名称不能为空")
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
