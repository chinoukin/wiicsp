package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * hp_catg 表实体
 * 首页分类
 * 2019/05/28 16:20:20
 */
public class HpCatg extends DataLongEntity<HpCatg> {
    private static final long serialVersionUID = 1L;

    /**
     * pid
     */
    private Long pid;

    /**
     * pids
     */
    private String pids;

    /**
     * 商品编号
     */
    private String commNum;

    /**
     * 父分类名称
     */
    private String parentCatgName;

    /**
     * 分类名称
     */
    private String catgName;

    /**
     * 状态（启用、停用）
     */
    private String enableFlag;

    /**
     * 显示顺序
     */
    private Integer sort;

    /**
     * 分类图标
     */
    private String catgIconUrl;

    /**
     * 关键词
     */
    private String keyWord;

    /**
     * 分类描述
     */
    private String catgRemarks;

    /**
     * 是否显示（是、否）
     */
    private String ifShow;

    /**
     * 获取pid
     */
    public Long getPid() {
        return pid;
    }

    /**
     * 设置pid
     */
    public void setPid(Long pid) {
        this.pid = pid;
    }

    /**
     * 获取pids
     */
    public String getPids() {
        return pids;
    }

    /**
     * 设置pids
     */
    public void setPids(String pids) {
        this.pids = pids == null ? null : pids.trim();
    }

    /**
     * 获取商品编号
     */
    public String getCommNum() {
        return commNum;
    }

    /**
     * 设置商品编号
     */
    public void setCommNum(String commNum) {
        this.commNum = commNum == null ? null : commNum.trim();
    }

    /**
     * 获取父分类名称
     */
    public String getParentCatgName() {
        return parentCatgName;
    }

    /**
     * 设置父分类名称
     */
    public void setParentCatgName(String parentCatgName) {
        this.parentCatgName = parentCatgName == null ? null : parentCatgName.trim();
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
     * 获取状态（启用、停用）
     */
    public String getEnableFlag() {
        return enableFlag;
    }

    /**
     * 设置状态（启用、停用）
     */
    public void setEnableFlag(String enableFlag) {
        this.enableFlag = enableFlag == null ? null : enableFlag.trim();
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

    /**
     * 获取分类图标
     */
    public String getCatgIconUrl() {
        return catgIconUrl;
    }

    /**
     * 设置分类图标
     */
    public void setCatgIconUrl(String catgIconUrl) {
        this.catgIconUrl = catgIconUrl == null ? null : catgIconUrl.trim();
    }

    /**
     * 获取关键词
     */
    public String getKeyWord() {
        return keyWord;
    }

    /**
     * 设置关键词
     */
    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord == null ? null : keyWord.trim();
    }

    /**
     * 获取分类描述
     */
    public String getCatgRemarks() {
        return catgRemarks;
    }

    /**
     * 设置分类描述
     */
    public void setCatgRemarks(String catgRemarks) {
        this.catgRemarks = catgRemarks == null ? null : catgRemarks.trim();
    }

    /**
     * 获取是否显示（是、否）
     */
    public String getIfShow() {
        return ifShow;
    }

    /**
     * 设置是否显示（是、否）
     */
    public void setIfShow(String ifShow) {
        this.ifShow = ifShow == null ? null : ifShow.trim();
    }
}
