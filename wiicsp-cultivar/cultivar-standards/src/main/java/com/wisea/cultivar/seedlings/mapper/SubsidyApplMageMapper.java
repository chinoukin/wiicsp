package com.wisea.cultivar.seedlings.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.seedlings.entity.SubsidyApplMage;
import com.wisea.cultivar.seedlings.po.SubsidyApplMageListPo;
import com.wisea.cultivar.seedlings.po.SubsidyApplMagePagePo;
import com.wisea.cultivar.seedlings.vo.SubsidyApplCountVo;
import com.wisea.cultivar.seedlings.vo.SubsidyApplMageListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * subsidy_appl_mage 表DAO
 * 补贴申请管理
 * 2020/08/06 14:19:24
 */
public interface SubsidyApplMageMapper extends CrudDao<SubsidyApplMage> {
    /**
     * 分页查询
     */
    List<SubsidyApplMageListVo> findPage(SubsidyApplMagePagePo subsidyApplMagePagePo);

    /**
     * 列表查询
     */
    List<SubsidyApplMageListVo> findList(SubsidyApplMageListPo subsidyApplMageListPo);

    List<SubsidyApplMageListVo> findByIds(@Param("delList") List<Long> delList);

    List<SubsidyApplMage> findListByStateType(Map<String, Object> maps);

    void updateState(Map<String, Object> maps);

    SubsidyApplCountVo getapplCount();
}
