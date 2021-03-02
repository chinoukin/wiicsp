package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.NationalDistrStatistics;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsListPo;
import com.wisea.cultivar.common.po.bigdata.NationalDistrStatisticsPagePo;
import com.wisea.cultivar.common.vo.bigdata.NationalDistrStatisticsListVo;

import java.util.List;

/**
 * national_distr_statistics 表DAO
 * 全国配送统计
 * 2020/09/02 15:16:31
 */
public interface NationalDistrStatisticsMapper extends CrudDao<NationalDistrStatistics> {
    /**
     * 分页查询
     */
    List<NationalDistrStatisticsListVo> findPage(NationalDistrStatisticsPagePo nationalDistrStatisticsPagePo);

    /**
     * 列表查询
     */
    List<NationalDistrStatisticsListVo> findList(NationalDistrStatisticsListPo nationalDistrStatisticsListPo);

    /**
     * 查询全部数据总数
     * @return
     */
    Integer countAll();
}
