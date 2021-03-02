package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.LogisticsBasicData;
import com.wisea.cultivar.common.po.bigdata.LogisticsBasicDataListPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsBasicDataPagePo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsBasicDataListVo;

import java.util.List;

/**
 * logistics_basic_data 表DAO
 * 物流基础数据
 * 2020/09/03 10:24:52
 */
public interface LogisticsBasicDataMapper extends CrudDao<LogisticsBasicData> {
    /**
     * 分页查询
     */
    List<LogisticsBasicDataListVo> findPage(LogisticsBasicDataPagePo logisticsBasicDataPagePo);

    /**
     * 列表查询
     */
    List<LogisticsBasicDataListVo> findList(LogisticsBasicDataListPo logisticsBasicDataListPo);
}
