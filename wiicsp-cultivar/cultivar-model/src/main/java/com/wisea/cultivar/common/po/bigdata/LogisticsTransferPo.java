package com.wisea.cultivar.common.po.bigdata;

import io.swagger.annotations.ApiModel;

import java.util.List;

/**
 * LogisticsTransferPo
 *
 * @author wangjiahao
 * @version 2020-09-03
 * @since 2020/9/3 10:02 上午
 */
@ApiModel("物流中转编辑PO")
public class LogisticsTransferPo {

    private List<LogisticsTransferAnalysisUpdatePo> list;

    public List<LogisticsTransferAnalysisUpdatePo> getList() {
        return list;
    }

    public void setList(List<LogisticsTransferAnalysisUpdatePo> list) {
        this.list = list;
    }
}
