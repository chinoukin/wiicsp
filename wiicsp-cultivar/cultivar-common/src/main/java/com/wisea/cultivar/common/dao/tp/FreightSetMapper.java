package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.FreightSet;
import com.wisea.cultivar.common.po.tp.FreightSetListPo;
import com.wisea.cultivar.common.po.tp.FreightSetPagePo;
import com.wisea.cultivar.common.vo.tp.FreightSetListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * freight_set 表DAO
 * 运费设置
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface FreightSetMapper extends CrudDao<FreightSet> {
    List<FreightSetListVo> findPage(FreightSetPagePo freightSetPagePo);

    List<FreightSetListVo> findList(FreightSetListPo freightSetListPo);

    Integer countById(@Param("id")Long id);

    Integer updateAllDelFlagByFormworkId(@Param("id") Long id);

    List<FreightSetListVo> findForListByFormworkId(@Param("id") Long id);

    /**
     * 根据省份count 以及 模板ids 查询 运费设置信息
     */
    List<FreightSet> selectIfSent(FreightSet freightSet);

    /**
     * 根据运费模板ID查询运费设置信息
     */
    FreightSet selectFreightSetInfo(FreightSet freightSet);
}
