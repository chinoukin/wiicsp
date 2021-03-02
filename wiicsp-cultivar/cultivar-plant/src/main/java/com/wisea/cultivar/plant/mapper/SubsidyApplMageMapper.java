package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.SubsidyApplMage;
import com.wisea.cultivar.plant.po.SubsidyApplMagePageListPo;
import com.wisea.cultivar.plant.vo.CommVo;
import com.wisea.cultivar.plant.vo.SubsidyApplMageInfoVo;
import com.wisea.cultivar.plant.vo.SubsidyApplMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface SubsidyApplMageMapper extends CrudDao<SubsidyApplMage> {
    /**
     * @Description 获取用户的补贴申请集合
     * @param id
     * @return
     */
    List<SubsidyApplMageInfoVo> findByIdPageList(Long id);
    /**
     * @author wbf-code-generator
     * @date 2020/08/08 11:00:15
     * @Description 分页查询SubsidyApplMage
     */
    List<SubsidyApplMagePageListVo> findPageList(SubsidyApplMagePageListPo po);


    SubsidyApplMageInfoVo findInfo(LongIdPo po);

    SubsidyApplMageInfoVo showSubsidyinfo(CommVo po);
}
