package com.wisea.cultivar.common.dao;

import com.wisea.cultivar.common.po.trade.SerListMageInfoPo;
import com.wisea.cultivar.common.po.trade.SerListMageListPo;
import com.wisea.cultivar.common.vo.trade.SerListMageInfoVo;
import com.wisea.cultivar.common.vo.trade.SerListMageListVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository("NbOrderInfoMapper")
public interface OrderInfoMapper {
    /**
     * 商家（后台）查询订单列表
     * @param po
     * @return
     */
    List<SerListMageListVo> findMerchantOrderList(SerListMageListPo po);


    /**
     * 查询订单详细信息
     * @param orderInfoPo
     * @return
     */
    SerListMageInfoVo findOrderInfo(SerListMageInfoPo orderInfoPo);

}
