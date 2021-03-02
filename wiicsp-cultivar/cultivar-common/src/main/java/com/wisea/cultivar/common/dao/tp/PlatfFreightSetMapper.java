package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.PlatfFreightSet;
import com.wisea.cultivar.common.po.tp.PlatfFreightSetListPo;
import com.wisea.cultivar.common.po.tp.PlatfFreightSetPagePo;
import com.wisea.cultivar.common.vo.tp.PlatfFreightSetListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * platf_freight_set 表DAO
 * 平台运费设置
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface PlatfFreightSetMapper extends CrudDao<PlatfFreightSet> {
    List<PlatfFreightSetListVo> findPage(PlatfFreightSetPagePo platfFreightSetPagePo);

    List<PlatfFreightSetListVo> findList(PlatfFreightSetListPo platfFreightSetListPo);

    /**
     * 根据ID查询条数
     * @param id
     * @return
     */
    Integer countById(@Param("id")Long id);

    /**
     * 根据所有模板ID更新所有记录delflag
     * @param id
     * @return
     */
    Integer updateAllDelFlagByFormworkId(@Param("id") Long id);

    /**
     * 根据模板ID查询所有可用记录
     * @param id
     * @return
     */
    List<PlatfFreightSetListVo> findForListByFormworkId(@Param("id") Long id);
}
