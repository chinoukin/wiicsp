package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.plant.entity.MembMomentsLimitsMage;
import com.wisea.cultivar.plant.po.MembMomentsLimitsMagePageListPo;
import com.wisea.cultivar.plant.vo.MembMomentsLimitsMageInfoVo;
import com.wisea.cultivar.plant.vo.MembMomentsLimitsMagePageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MembMomentsLimitsMageMapper extends CrudDao<MembMomentsLimitsMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/08/06 18:28:39
     * @Description 分页查询MembMomentsLimitsMage
     */
    List<MembMomentsLimitsMagePageListVo> findPageList(MembMomentsLimitsMagePageListPo po);

    List<MembMomentsLimitsMageInfoVo> findMembMomentsLimits(MembMomentsLimitsMagePageListPo po);

    List<MembMomentsLimitsMage> findByConditions(MembMomentsLimitsMage membMomentsLimitsMage);
}
