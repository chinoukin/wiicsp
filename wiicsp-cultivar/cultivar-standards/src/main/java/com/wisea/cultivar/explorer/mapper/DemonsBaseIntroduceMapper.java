package com.wisea.cultivar.explorer.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.explorer.entity.DemonsBaseIntroduce;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroduceListPo;
import com.wisea.cultivar.explorer.po.DemonsBaseIntroducePagePo;
import com.wisea.cultivar.explorer.vo.DemonsBaseIntroduceListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * demons_base_introduce 表DAO
 * 示范基地详细介绍
 * 2020/08/11 13:21:46
 */
public interface DemonsBaseIntroduceMapper extends CrudDao<DemonsBaseIntroduce> {
    /**
     * 分页查询
     */
    List<DemonsBaseIntroduceListVo> findPage(DemonsBaseIntroducePagePo demonsBaseIntroducePagePo);

    /**
     * 列表查询
     */
    List<DemonsBaseIntroduceListVo> findList(DemonsBaseIntroduceListPo demonsBaseIntroduceListPo);

    /**
     * 物理删除详细信息
     * @param demonsBaseId 示范基地主表ID
     */
    void delIntroduce(@Param("demonsBaseId") Long demonsBaseId);

}
