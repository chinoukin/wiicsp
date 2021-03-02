package com.wisea.cultivar.seedlings.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.seedlings.entity.SubsidyExamRecd;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdListPo;
import com.wisea.cultivar.seedlings.po.SubsidyExamRecdPagePo;
import com.wisea.cultivar.seedlings.vo.SubsidyExamRecdListVo;
import java.util.List;

/**
 * subsidy_exam_recd 表DAO
 * 补贴审核记录
 * 2020/08/06 14:19:24
 */
public interface SubsidyExamRecdMapper extends CrudDao<SubsidyExamRecd> {
    /**
     * 分页查询
     */
    List<SubsidyExamRecdListVo> findPage(SubsidyExamRecdPagePo subsidyExamRecdPagePo);

    /**
     * 列表查询
     */
    List<SubsidyExamRecdListVo> findList(SubsidyExamRecdListPo subsidyExamRecdListPo);
}
