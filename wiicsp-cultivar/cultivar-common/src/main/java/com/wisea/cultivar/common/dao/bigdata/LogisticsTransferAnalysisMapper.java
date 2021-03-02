package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.LogisticsTransferAnalysis;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferAnalysisListPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsTransferAnalysisPagePo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsTransferAnalysisListVo;

import java.util.List;

/**
 * logistics_transfer_analysis 表DAO
 * 物流中转分析
 * 2020/09/02 15:33:51
 */
public interface LogisticsTransferAnalysisMapper extends CrudDao<LogisticsTransferAnalysis> {
    /**
     * 分页查询
     */
    List<LogisticsTransferAnalysisListVo> findPage(LogisticsTransferAnalysisPagePo logisticsTransferAnalysisPagePo);

    /**
     * 列表查询
     */
    List<LogisticsTransferAnalysisListVo> findList(LogisticsTransferAnalysisListPo logisticsTransferAnalysisListPo);
}
