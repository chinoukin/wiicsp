package com.wisea.transac.common.vo.product;

import com.wisea.transac.common.po.product.CommTree;

import java.util.List;

/**
 * @Author: wangs
 */
public class InsertCommAttriSetVo {

    /**
     * 商品管理的集合VO
     */
    private List<CommTree> commMageListVoList;

    /**
     * 商品属性的集合VO
     */
    private List<CommAttriMageGetVo> commAttriMageListVoList;

    public List<CommTree> getCommMageListVoList() {
        return commMageListVoList;
    }

    public void setCommMageListVoList(List<CommTree> commMageListVoList) {
        this.commMageListVoList = commMageListVoList;
    }

    public List<CommAttriMageGetVo> getCommAttriMageListVoList() {
        return commAttriMageListVoList;
    }

    public void setCommAttriMageListVoList(List<CommAttriMageGetVo> commAttriMageListVoList) {
        this.commAttriMageListVoList = commAttriMageListVoList;
    }
}
