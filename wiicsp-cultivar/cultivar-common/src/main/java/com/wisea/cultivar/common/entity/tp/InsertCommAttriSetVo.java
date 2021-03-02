package com.wisea.cultivar.common.entity.tp;

import com.wisea.cultivar.common.vo.tp.CommAttriMageGetVo;

import java.util.List;

/**
 * @Author:Liangzy(Wisea)
 * @Date:Create in 2018/9/21 上午9:12
 * @Description:给商品赋予属性之前查询VO
 */
public class InsertCommAttriSetVo {

    /*
    * 商品管理的集合VO
    * */
    private List<CommTree> commMageListVoList;

    /*
    * 商品属性的集合VO
    * */
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
