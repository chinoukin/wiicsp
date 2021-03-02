package com.wisea.cultivar.plant.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.plant.entity.MembMoments;
import com.wisea.cultivar.plant.po.MembMomentsPageListPo;
import com.wisea.cultivar.plant.vo.MembMomentsInfoVo;
import com.wisea.cultivar.plant.vo.MembMomentsPageListVo;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
@Repository
public interface MembMomentsMapper extends CrudDao<MembMoments> {
    /**
     * @Description 分页查询MembMoments
     */
    List<MembMomentsPageListVo> findPageList(MembMomentsPageListPo po);

    /**
     * @Description 查询详细信息MembMoments
     */
    MembMomentsInfoVo findInfo(LongIdPo po);

    // 油茶圈列表
    List<MembMomentsInfoVo> findAllMembMoments(MembMomentsPageListPo po);

    // 查询个人主页信息
    List<MembMomentsInfoVo> findOwnPageInfo(MembMomentsPageListPo po);

    // 油茶圈搜索
    List<MembMomentsInfoVo> searchMembMoments(MembMomentsPageListPo po);
}
