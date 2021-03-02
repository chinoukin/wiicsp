package com.wisea.transac.common.po.product;

import org.javers.core.metamodel.annotation.DiffInclude;

import java.util.List;

/**
 * @Description:
 * @author: wangs
 * @date :2020/7/23
 */
public class LevelCommPricePo {

    @DiffInclude
    private List<CommPricePo> commPricePo;

    public List<CommPricePo> getCommPricePo() {
        return commPricePo;
    }

    public void setCommPricePo(List<CommPricePo> commPricePo) {
        this.commPricePo = commPricePo;
    }
}
