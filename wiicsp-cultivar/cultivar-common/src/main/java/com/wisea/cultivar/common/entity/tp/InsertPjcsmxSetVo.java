package com.wisea.cultivar.common.entity.tp;

import com.wisea.cultivar.common.vo.tp.product.PjcsmxMageGetVo;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2019/6/5
 */
public class InsertPjcsmxSetVo {

    /*
     * 商品管理的集合VO
     * */
    private List<CommTree> commMageListVoList;

    /*
     * 商品属性的集合VO
     * */
    private List<PjcsmxMageGetVo> commAttriMageListVoList;

    public List<CommTree> getCommMageListVoList() {
        return commMageListVoList;
    }

    public void setCommMageListVoList(List<CommTree> commMageListVoList) {
        this.commMageListVoList = commMageListVoList;
    }

    public List<PjcsmxMageGetVo> getCommAttriMageListVoList() {
        return commAttriMageListVoList;
    }

    public void setCommAttriMageListVoList(List<PjcsmxMageGetVo> commAttriMageListVoList) {
        this.commAttriMageListVoList = commAttriMageListVoList;
    }
}
