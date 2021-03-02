package com.wisea.cultivar.common.entity.tp;

import com.wisea.cultivar.common.po.tp.CommPubInfoGetPo;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2018/11/2
 */
public class CommPubInfoListSearchPo {

    private List<CommPubInfoGetPo> listPo;

    public List<CommPubInfoGetPo> getListPo() {
        return listPo;
    }

    public void setListPo(List<CommPubInfoGetPo> listPo) {
        this.listPo = listPo;
    }
}
