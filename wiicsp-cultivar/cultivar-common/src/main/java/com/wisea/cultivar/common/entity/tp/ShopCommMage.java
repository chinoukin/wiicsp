package com.wisea.cultivar.common.entity.tp;

import com.wisea.cloud.common.entity.DataLongEntity;

/**
 * shop_comm_mage 表实体
 * 店内商品管理
 * 2019/12/12 09:12:09
 */
public class ShopCommMage extends DataLongEntity<ShopCommMage> {
    private static final long serialVersionUID = 1L;

    /**
     * 店铺id
     */
    private Long shopInfoMageId;

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
    private String pCommCatgName;

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
     * 获取店铺id
     */
    public Long getShopInfoMageId() {
        return shopInfoMageId;
    }

    /**
     * 设置店铺id
     */
    public void setShopInfoMageId(Long shopInfoMageId) {
        this.shopInfoMageId = shopInfoMageId;
    }

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
    public String getpCommCatgName() {
        return pCommCatgName;
    }

    /**
     * 设置父分类名称
     */
    public void setpCommCatgName(String pCommCatgName) {
        this.pCommCatgName = pCommCatgName == null ? null : pCommCatgName.trim();
    }

    /**
     * 获取商品分类名称
     */
    public String getCommCatgName() {
        return commCatgName;
    }

    /**
     * 设置商品分类名称
     */
    public void setCommCatgName(String commCatgName) {
        this.commCatgName = commCatgName == null ? null : commCatgName.trim();
    }

    /**
     * 获取商品状态（有效、无效）
     */
    public String getEffeInvalState() {
        return effeInvalState;
    }

    /**
     * 设置商品状态（有效、无效）
     */
    public void setEffeInvalState(String effeInvalState) {
        this.effeInvalState = effeInvalState == null ? null : effeInvalState.trim();
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
}
