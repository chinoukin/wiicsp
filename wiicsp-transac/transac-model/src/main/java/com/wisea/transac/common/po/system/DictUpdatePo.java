package com.wisea.transac.common.po.system;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * @author wangjiahao
 * @since 2020/7/17 10:31 上午
 */
@ApiModel("字典修改PO")
public class DictUpdatePo {
    @ApiModelProperty(value = "ID 非空", required = true)
    @Check(test = {"required"})
    private String id;
    @ApiModelProperty("数据值")
    @Check(test = {"required"})
    private String value;
    @ApiModelProperty("标签名 非空")
    @Check(test = {"required"})
    private String label;
    @ApiModelProperty("标签名 非空")
    @Check(test = {"required"})
    private String type;
    @ApiModelProperty("描述")
    private String description;
    @ApiModelProperty("排序")
    private Integer sort;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}
