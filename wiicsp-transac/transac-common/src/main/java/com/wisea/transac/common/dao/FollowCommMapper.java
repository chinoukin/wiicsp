package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.FollowComm;
import com.wisea.transac.common.po.FollowCommPageListPo;
import com.wisea.transac.common.po.FollowCommPo;
import com.wisea.transac.common.po.seller.FocusPo;
import com.wisea.transac.common.po.seller.FollowCommMiniPageListPo;
import com.wisea.transac.common.vo.FollowCommInfoVo;
import com.wisea.transac.common.vo.FollowCommPageListVo;
import com.wisea.transac.common.vo.seller.FollowCommMiniPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FollowCommMapper extends CrudDao<FollowComm> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowComm
     */
    List<FollowCommPageListVo> findPageList(FollowCommPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FollowComm
     */
    FollowCommInfoVo findInfo(LongIdPo po);

    Long findSumByUserId(FocusPo po);

    /**
     * 查询关注商品
     * @param po
     * @return
     */
    List<FollowCommMiniPageListVo> findMiniPageList(FollowCommMiniPageListPo po);

    /**
     * 根据用户id和商品发布id查询是否存在
     * @param po
     * @return
     */
    FollowComm findExist(FollowCommPo po);
}
