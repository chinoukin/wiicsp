package com.wisea.transac.common.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.List;

/**
 * @author wangjiahao
 * @since 2020/7/6 4:04 下午
 */
@ApiModel("口岸下拉选择列表VO")
public class PortMageListVo {

    @ApiModelProperty("省份code")
    private String prov;
    @ApiModelProperty("省份名称")
    private String provName;
    @ApiModelProperty("省份名称")
    private String label;
    @ApiModelProperty("省份code")
    private String value;
    @ApiModelProperty("口岸集合")
    private List<PortMageVo> children;

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getProv() {
        return prov;
    }

    public void setProv(String prov) {
        this.prov = prov;
    }

    public String getProvName() {
        return provName;
    }

    public void setProvName(String provName) {
        this.provName = provName;
    }

    public List<PortMageVo> getChildren() {
        return children;
    }

    public void setChildren(List<PortMageVo> children) {
        this.children = children;
    }
}
