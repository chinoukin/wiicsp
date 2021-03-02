package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wisea.cultivar.common.entity.tp.FollowShopMage;
import com.wisea.cultivar.common.po.tp.FollowShopMageListPo;
import com.wisea.cultivar.common.po.tp.FollowShopMagePagePo;
import com.wisea.cultivar.common.po.tp.FollowShopMageUpdatePo;
import com.wisea.cultivar.common.vo.tp.FollowShopMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * follow_shop_mage 表DAO
 * 关注店铺管理
 * 2019/12/24 11:10:18
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
@Repository
public interface FollowShopMageMapper extends CrudDao<FollowShopMage> {
    List<FollowShopMageListVo> findPage(FollowShopMagePagePo followShopMagePagePo);

    List<FollowShopMageListVo> findList(FollowShopMageListPo followShopMageListPo);

    /**
     * 查询店铺列表
     * @param followShopMageListPo
     * @return
     */
    List<FollowShopMageListVo> followShopList(FollowShopMageListPo followShopMageListPo);

    FollowShopMageListVo ifHavaList(FollowShopMageListPo followShopMageListPo);

    /**
     * 取消关注
     * @param po
     */
    void qxgzFollow (FollowShopMageUpdatePo po);

    /**
     * 查询登录会员对当前店铺的关注情况
     * @param followShopMage
     * @return
     */
    FollowShopMage getfollowShopInfo(FollowShopMage followShopMage);
}
