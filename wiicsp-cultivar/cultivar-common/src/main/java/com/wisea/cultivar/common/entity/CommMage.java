package com.wisea.cultivar.common.entity;

import com.wisea.cloud.common.entity.DataLongEntity;

public class CommMage extends DataLongEntity<CommMage> {
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
     * 商品分类名称
     */
    private String commCatgName;

    /**
     * 商品状态（有效、无效）
     */
    private String effeInvalState;

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
     * 父分类名称
     */
    private String pCommCatgName;

    public Long getPid() {
        return pid;
    }

    public void setPid(Long pid) {
        this.pid = pid;
    }

    public String getPids() {
        return pids;
    }

    public void setPids(String pids) {
        this.pids = pids;
    }

    public String getCommNum() {
        return commNum;
    }

    public void setCommNum(String commNum) {
        this.commNum = commNum;
    }

    public String getCommCatgName() {
        return commCatgName;
    }

    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName;
    }

    public String getEffeInvalState() {
        return effeInvalState;
    }

    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getCatgIconUrl() {
        return catgIconUrl;
    }

    public void setCatgIconUrl(String catgIconUrl) {
        this.catgIconUrl = catgIconUrl;
    }

    public String getKeyWord() {
        return keyWord;
    }

    public void setKeyWord(String keyWord) {
        this.keyWord = keyWord;
    }

    public String getCatgRemarks() {
        return catgRemarks;
    }

    public void setCatgRemarks(String catgRemarks) {
        this.catgRemarks = catgRemarks;
    }

    public String getpCommCatgName() {
        return pCommCatgName;
    }

    public void setpCommCatgName(String pCommCatgName) {
        this.pCommCatgName = pCommCatgName;
    }
}
