package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.transac.common.entity.LocalityOrderInfo;
import com.wisea.transac.common.po.trade.BuyerOrderInfoListPo;
import com.wisea.transac.common.po.trade.LocalityOrderInfoListPo;
import com.wisea.transac.common.po.trade.OrderInfoPo;
import com.wisea.transac.common.vo.StateTypeVo;
import com.wisea.transac.common.vo.seller.ProcurDynamicVo;
import com.wisea.transac.common.vo.trade.BuyerOrderInfoListVo;
import com.wisea.transac.common.vo.trade.MerchantOrderInfoListVo;
import com.wisea.transac.common.vo.trade.OrderInfoVo;

@Mapper
@Repository
public interface LocalityOrderInfoMapper extends CrudDao<LocalityOrderInfo> {

    /**
     * 查询分页信息
     * @param po
     * @return
     */
    List<BuyerOrderInfoListVo> findBuyerPage (BuyerOrderInfoListPo po);

    /**
     * 买家端查询各个状态下订单数量
     * @param po
     * @return
     */
    List<StateTypeVo> orderNumb(BuyerOrderInfoListPo po);

    /**
     * 查询订单信息
     * @param po
     * @return
     */
    List<BuyerOrderInfoListVo> findBuyerList (BuyerOrderInfoListPo po);

    /**
     * 根据IDS查询订单s
     * @param ordIds
     * @return
     */
    List<LocalityOrderInfo> findOrderByIds (@Param("ordIds") String ordIds);
    /**
     * 根据基地ID查询信息列表
     * @param baseId
     * @return
     */
    List<ProcurDynamicVo> findListByBaseId(@Param("baseId") Long baseId);
    List<StateTypeVo> findCountByState(LocalityOrderInfoListPo po);

    List<MerchantOrderInfoListVo> findMerchantOrderList(LocalityOrderInfoListPo po);

    OrderInfoVo findOrderInfo(OrderInfoPo po);
}
