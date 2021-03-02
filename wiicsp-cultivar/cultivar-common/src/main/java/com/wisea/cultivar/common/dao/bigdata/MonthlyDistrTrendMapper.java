package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.MonthlyDistrTrend;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrTrendListPo;
import com.wisea.cultivar.common.po.bigdata.MonthlyDistrTrendPagePo;
import com.wisea.cultivar.common.vo.bigdata.MonthlyDistrTrendListVo;

import java.util.List;

/**
 * monthly_distr_trend 表DAO
 * 月配送单量趋势
 * 2020/09/02 15:33:51
 */
public interface MonthlyDistrTrendMapper extends CrudDao<MonthlyDistrTrend> {
    /**
     * 分页查询
     */
    List<MonthlyDistrTrendListVo> findPage(MonthlyDistrTrendPagePo monthlyDistrTrendPagePo);

    /**
     * 列表查询
     */
    List<MonthlyDistrTrendListVo> findList(MonthlyDistrTrendListPo monthlyDistrTrendListPo);
}
