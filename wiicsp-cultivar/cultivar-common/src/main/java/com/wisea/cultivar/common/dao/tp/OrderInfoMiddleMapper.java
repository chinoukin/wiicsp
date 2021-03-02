package com.wisea.cultivar.common.dao.tp;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.OrderInfoMiddle;
import com.wisea.cultivar.common.vo.tp.trade.TotalSalesVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.HashSet;
import java.util.List;

@Mapper
@Repository
public interface OrderInfoMiddleMapper extends CrudDao<OrderInfoMiddle> {
    TotalSalesVo findTotalSales ();

    List<OrderInfoMiddle> findNewOrders();

    HashSet<String> findOrderNums();
}
