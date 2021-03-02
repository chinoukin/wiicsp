package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.FeedBackMage;
import com.wisea.transac.common.po.FeedBackMagePageListPo;
import com.wisea.transac.common.vo.FeedBackMageInfoVo;
import com.wisea.transac.common.vo.FeedBackMagePageListVo;
import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

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
