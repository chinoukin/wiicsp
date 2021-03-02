package com.wisea.cultivar.common.po.bigdata;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * LogisticBasicDataPo
 *
 * @author wangjiahao
 * @version 2020-09-03
 * @since 2020/9/3 11:04 上午
 */
@ApiModel("物流基础数据编辑Po")
public class LogisticBasicDataPo {
    private List<LogisticsBasicDataUpdatePo> list;

    public List<LogisticsBasicDataUpdatePo> getList() {
        return list;
    }

    public void setList(List<LogisticsBasicDataUpdatePo> list) {
        this.list = list;
    }
}
