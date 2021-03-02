package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.SubsidyExamRecd;
import com.wisea.cultivar.plant.po.SubsidyExamRecdPageListPo;
import com.wisea.cultivar.plant.vo.SubsidyExamRecdInfoVo;
import com.wisea.cultivar.plant.vo.SubsidyExamRecdPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubsidyExamRecdMapper extends CrudDao<SubsidyExamRecd> {
    /**
     * @author wbf-code-generator
     * @date 2020/09/09 14:44:23
     * @Description 分页查询SubsidyExamRecd
     */
    List<SubsidyExamRecdPageListVo> findPageList(SubsidyExamRecdPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/09/09 14:44:23
     * @Description 查询详细信息SubsidyExamRecd
     */
    SubsidyExamRecdInfoVo findInfo(LongIdPo po);
}
