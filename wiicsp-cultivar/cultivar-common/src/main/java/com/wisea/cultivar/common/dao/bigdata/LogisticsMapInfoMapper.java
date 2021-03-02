package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.LogisticsMapInfo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoListPo;
import com.wisea.cultivar.common.po.bigdata.LogisticsMapInfoPagePo;
import com.wisea.cultivar.common.vo.bigdata.LogisticsMapInfoListVo;

import java.util.List;

/**
 * logistics_map_info 表DAO
 * 物流地图信息
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface LogisticsMapInfoMapper extends CrudDao<LogisticsMapInfo> {
    List<LogisticsMapInfoListVo> findPage(LogisticsMapInfoPagePo logisticsMapInfoPagePo);

    List<LogisticsMapInfoListVo> findList(LogisticsMapInfoListPo logisticsMapInfoListPo);

    List<LogisticsMapInfo> findAllEntity();
}
