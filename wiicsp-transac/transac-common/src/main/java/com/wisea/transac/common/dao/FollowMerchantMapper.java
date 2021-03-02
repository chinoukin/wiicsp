package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.FollowMerchant;
import com.wisea.transac.common.po.FollowMerchantPageListPo;
import com.wisea.transac.common.po.FollowMerchantPo;
import com.wisea.transac.common.po.seller.FindLocalityPageListPo;
import com.wisea.transac.common.po.seller.FocusPo;
import com.wisea.transac.common.po.seller.FollowMerchantBasePo;
import com.wisea.transac.common.po.seller.FollowMerchantminiPageListPo;
import com.wisea.transac.common.vo.FollowMerchantInfoVo;
import com.wisea.transac.common.vo.FollowMerchantPageListVo;
import com.wisea.transac.common.vo.seller.FindLocalityPageListVo;
import com.wisea.transac.common.vo.seller.FollowMerchantminiPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface FollowMerchantMapper extends CrudDao<FollowMerchant> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询FollowMerchant
     */
    List<FollowMerchantPageListVo> findPageList(FollowMerchantPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息FollowMerchant
     */
    FollowMerchantInfoVo findInfo(LongIdPo po);

    /**
     * 查询关注的店铺
     * @param po
     * @return
     */
    List<FollowMerchantminiPageListVo> findminiPageList(FollowMerchantminiPageListPo po);

    /**
     *  查询关注数量
     * @param po
     * @return
     */
    Long findSumByUserId(FocusPo po);

    /**
     *根据用户ID 和店铺id 查询
     * @param po
     * @return
     */
    FollowMerchant findExist(FollowMerchantPo po);

    /**
     * 产地交易商家
     * @param po
     * @return
     */
    List<FindLocalityPageListVo> findLocalityPageList(FindLocalityPageListPo po);

    /**
     * 根据用户ID 和基地id 查询
     * @param po
     * @return
     */
    FollowMerchant findBaseExist(FollowMerchantBasePo po);

    FollowMerchant findBaseByBaseIdAndMembId(FollowMerchantBasePo po);
}
