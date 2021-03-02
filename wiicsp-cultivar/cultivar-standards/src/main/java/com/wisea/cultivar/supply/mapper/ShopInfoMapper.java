package com.wisea.cultivar.supply.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.MembInfoInfoVo;
import com.wisea.cultivar.supply.entity.ShopInfo;
import com.wisea.cultivar.supply.vo.CertPictureVo;
import com.wisea.cultivar.supply.vo.MembAuthVo;
import com.wisea.cultivar.supply.vo.ShopHomeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopInfoMapper extends CrudDao<ShopInfo> {

    /**
     * 根据服务商id查询首页店铺信息
     * @param membId 服务商id
     */
    ShopHomeVo selectShopHomeByMembId(Long membId);

    /**
     * 店铺证书
     * @param membId 服务商id
     * @return 证书
     */
    List<CertPictureVo> findShopCert(Long membId);

    /**
     * 根据服务商id查询首页店铺信息
     * @param membId 服务商id
     */
    ShopInfo selectByMembId(Long membId);

    /**
     * 通过名称查询店铺信息
     * @param shopName 店铺名称
     */
    ShopInfo selectByShopName(String shopName);

    /**
     * 查询用户认证信息
     */
    MembAuthVo getMembBaseInfo(Long id);

    /**
     * 查询认证状态
     * @param membId 用户id
     */
    MembAuthVo getAuthState(@Param("membId") Long membId, @Param("tableName") String tableName);

    /**
     * 服务单金额
     */
    String selectSerListPrice(Long membId);

    /**
     * 客户数
     */
    String selectClientCount(Long membId);

    /**
     * 关注数
     */
    String selectFocusCount(Long membId);

    /**
     * 服务单总数
     */
    String selectSerListCount(Long membId);

    /**
     * 查询账号信息
     */
    MembInfoInfoVo findAccount(Long membId);
}
