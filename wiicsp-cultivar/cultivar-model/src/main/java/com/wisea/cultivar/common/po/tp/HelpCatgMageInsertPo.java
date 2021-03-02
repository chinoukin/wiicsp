package com.wisea.cultivar.common.po.tp;

import com.wisea.cloud.model.annotation.Check;
import io.swagger.annotations.ApiModelProperty;

/**
 * HelpCatgMageInsertPo
 * 2018/10/29 10:29:10
 */
public class HelpCatgMageInsertPo {
    /**
     * 编号
     */
    @Check(test = { "maxLength","required" }, mixLength = 10)
    @ApiModelProperty(value = "编号")
    private String num;

    /**
     * 分类名称
     */
    @Check(test = { "maxLength","required" }, mixLength = 100)
    @ApiModelProperty(value = "分类名称")
    private String catgName;

    /**
     * 是否显示
     */
    @Check(test = { "maxLength","required" }, mixLength = 1)
    @ApiModelProperty(value = "是否显示")
    private String defaultFlag;

    /**
     * 备注
     */
    @Check(test = { "maxLength" }, mixLength = 255)
    @ApiModelProperty(value = "备注")
    private String remarks;

    /**
     * 获取编号
     */
    public String getNum() {
        return num;
    }

    /**
     * 设置编号
     */
    public void setNum(String num) {
        this.num = num == null ? null : num.trim();
    }

    /**
     * 获取分类名称
     */
    public String getCatgName() {
        return catgName;
    }

    /**
     * 设置分类名称
     */
    public void setCatgName(String catgName) {
        this.catgName = catgName == null ? null : catgName.trim();
    }

    /**
     * 获取是否显示
     */
    public String getDefaultFlag() {
        return defaultFlag;
    }

    /**
     * 设置是否显示
     */
    public void setDefaultFlag(String defaultFlag) {
        this.defaultFlag = defaultFlag == null ? null : defaultFlag.trim();
    }

    /**
     * 获取备注
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 设置备注
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }
}
