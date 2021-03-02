package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * help_catg_mage 表实体
 * 帮助分类管理
 * 2018/10/29 10:29:10
 */
public class HelpCatgMage extends DataLongEntity<HelpCatgMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     */
    private String num;

    /**
     * 分类名称
     */
    private String catgName;

    /**
     * 是否显示
     */
    private String defaultFlag;

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
}
