package com.wisea.cultivar.supply.mapper;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.CommMage;
import com.wisea.cultivar.supply.entity.ZhfwCommPubInfo;
import com.wisea.cultivar.supply.po.CommodityGetPo;
import com.wisea.cultivar.supply.po.CommodityListPo;
import com.wisea.cultivar.supply.vo.CertVo;
import com.wisea.cultivar.supply.vo.CommodityDetailsVo;
import com.wisea.cultivar.supply.vo.CommodityEchoVo;
import com.wisea.cultivar.supply.vo.ShopCommodityVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ZhfwCommPubInfoMapper extends CrudDao<ZhfwCommPubInfo> {

    /**
     * 产品列表
     * @param commodityListPo 条件
     * @return 商品列表
     */
    List<ShopCommodityVo> findCommodityList(CommodityListPo commodityListPo);

    /**
     * 通过商品名称查询
     * @param commTitle 商品名称
     */
    ZhfwCommPubInfo selectByCommTitle(String commTitle);

    /**
     * 商品信息
     */
    CommodityEchoVo getCommodityInfo(CommodityGetPo commodityGetPo);

    /**
     * 商品详情
     */
    CommodityDetailsVo getCommodityDetails(CommodityGetPo commodityGetPo);

    /**
     * 查询证书
     */
    List<CertVo> findCerts(Long userId);

    /**
     * 通过状态查询商品状态数量
     * @param userId 用户id
     * @param state 状态
     */
    String selectCountByState(@Param("userId") Long userId, @Param("state") String state);

    /**
     * 查询父分类
     */
    List<CommMage> selectAttriParent();

    List<CommMage> selectAttriChildren(Long pid);

    /**
     * 通过id插叙分类
     */
    CommMage selectAttriById(Long selectAttriById);
}
