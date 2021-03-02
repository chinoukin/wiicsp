package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.ShopInfo;
import com.wisea.transac.common.po.seller.ShopInfoPageListPo;
import com.wisea.transac.common.vo.seller.SellerTotalAmountAndTotalCountVo;
import com.wisea.transac.common.vo.seller.ShopInfoInfoVo;
import com.wisea.transac.common.vo.seller.ShopInfoPageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface ShopInfoMapper extends CrudDao<ShopInfo> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 分页查询ShopInfo
     */
    List<ShopInfoPageListVo> findPageList(ShopInfoPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:28
     * @Description 查询详细信息ShopInfo
     */
    ShopInfoInfoVo findInfo(LongIdPo po);

    /**
     * 根据merchantId会员id查询店铺信息
     * @param merchantId 会员id
     * @return
     */
    ShopInfoInfoVo findInfoByMerchantId(Long merchantId);

    /**
     * 按卖家ID查询所有订单总金额和订单总数
     * @param sellerId 卖家ID
     * @return
     */
    SellerTotalAmountAndTotalCountVo findTotalAmountAndTotalCountBySellerId(Long sellerId);

    /**
     * 按商户Id查询总客户数
     * @param merchantId 商户ID
     * @return
     */
    Long findCustomerCountByMerchantId(Long merchantId);

    /**
     * 按商户ID查询关注用户总数
     * @param merchantId 商户ID
     * @return
     */
    Long findFollowCountByMerchantId(Long merchantId);

    /**
     * 根据商户Id和店铺名称查询数据
     * @param shopInfo
     * @return
     */
    Integer countByMerchantIdAndShopName(ShopInfo shopInfo);
}
