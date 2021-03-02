package com.wisea.cultivar.common.po.bigdata;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * MonthlyDistrUpdatePo
 *
 * @author wangjiahao
 * @version 2020-09-02
 * @since 2020/9/2 5:49 下午
 */
@ApiModel("月配送单量修改po")
public class MonthlyDistrUpdatePo {

    private List<MonthlyDistrTrendUpdatePo> list;

    public List<MonthlyDistrTrendUpdatePo> getList() {
        return list;
    }

    public void setList(List<MonthlyDistrTrendUpdatePo> list) {
        this.list = list;
    }
}
