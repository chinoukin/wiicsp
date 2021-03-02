package com.wisea.cultivar.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.cultivar.common.entity.FeedBackMage;
import com.wisea.cultivar.common.po.FeedBackMagePageListPo;
import com.wisea.cultivar.common.vo.FeedBackMageInfoVo;
import com.wisea.cultivar.common.vo.FeedBackMagePageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FeedBackMageMapper extends CrudDao<FeedBackMage> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FeedBackMage
     */
    List<FeedBackMagePageListVo> findPageList(FeedBackMagePageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FeedBackMage
     */
    FeedBackMageInfoVo findInfo(LongIdPo po);

    /**
     * 有条件的分页查询
     * */
    List<FeedBackMagePageListVo> findListByCond(FeedBackMagePageListPo po);
}
