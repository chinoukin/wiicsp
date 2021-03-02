package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Sets;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.dao.tp.OrderInfoMiddleMapper;
import com.wisea.cultivar.common.entity.tp.OrderInfoMiddle;
import com.wisea.cultivar.common.vo.bigdata.OrdYjInfoListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author jirg
 * @Date 2020/12/18 11:04
 * @Description 交易中间表操作Service
 **/
@Service
public class OrderInfoMiddleService extends BaseService {
    @Autowired
    private JedisDao jedisDao;
    @Autowired
    private OrderInfoMiddleMapper middleMapper;

    public static String ORDER_NUM_LIST = "big_data_order_num_list";

    /**
     * 同步订单
     * @param po
     * @return
     */
    public ResultPoJo<?> orderSync(List<OrderInfoMiddle> po) {
        ResultPoJo<?> result = new ResultPoJo<>();
        if(ConverterUtil.isNotEmpty(po)){
            saveOrders(po);
        }
        return result;
    }


    /**
     *  保存订单数据
     * @param orders
     */
    public void saveOrders(List<OrderInfoMiddle> orders){
        if(ConverterUtil.isNotEmpty(orders)){
            HashSet<String> orderNums = jedisDao.getSerialize(ORDER_NUM_LIST, HashSet.class);
            if(ConverterUtil.isEmpty(orderNums)){
                orderNums = middleMapper.findOrderNums();
            }

            HashSet<String> finalOrderNums = orderNums;
            List<OrderInfoMiddle> newOrders = orders.stream().filter(e -> {
                return !finalOrderNums.contains(e.getOrdNum());
            }).collect(Collectors.toList());

            if(ConverterUtil.isNotEmpty(newOrders)){
                newOrders.forEach(e->{
                    e.preInsert();
                    finalOrderNums.add(e.getOrdNum());
                });
                jedisDao.setSerialize(ORDER_NUM_LIST, finalOrderNums);
                //批量插入订单中间表
                middleMapper.batchInsert(newOrders);
            }
        }
    }
}
