package com.wisea.cultivar.bigdata.service;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cultivar.common.dao.bigdata.OrdCommRelaTbMapper;
import com.wisea.cultivar.common.dao.bigdata.OrderInfoTbMapper;
import com.wisea.cultivar.common.entity.bigdata.OrdCommRelaTb;
import com.wisea.cultivar.common.entity.bigdata.OrderInfoTb;
import com.wisea.cultivar.common.entity.tp.OrderInfoMiddle;
import com.wisea.cultivar.common.po.bigdata.OrdCommRelaTbPo;
import com.wisea.cultivar.common.po.bigdata.OrderInfoTbPo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author jirg
 * @Date 2020/12/23 9:07
 * @Description 订单同步Service
 **/
@Service
public class OrderInfoTbService extends BaseService {
    @Autowired
    private JedisDao jedisDao;
    @Autowired
    private OrderInfoTbMapper orderInfoTbMapper;
    @Autowired
    private OrdCommRelaTbMapper ordCommRelaTbMapper;

    public static String ORDER_NUM_LIST = "big_data_order_num_list";

    /**
     * 同步订单
     * @param po
     * @return
     */
    public ResultPoJo<?> orderSync(List<OrderInfoTbPo> po) {
        ResultPoJo<?> result = new ResultPoJo<>();
        if(ConverterUtil.isNotEmpty(po)){
            HashSet<String> orderNums = jedisDao.getSerialize(ORDER_NUM_LIST, HashSet.class);
            if(ConverterUtil.isEmpty(orderNums)){
                orderNums = orderInfoTbMapper.findOrderNums();
            }

            HashSet<String> finalOrderNums = orderNums;
            List<OrderInfoTbPo> newOrders = po.stream().filter(e -> {
                return !finalOrderNums.contains(e.getOrdNum());
            }).collect(Collectors.toList());

            if(ConverterUtil.isNotEmpty(newOrders)){
                List<OrderInfoTb> orderInfoTbs = Lists.newArrayList();
                List<OrdCommRelaTb> ordCommRelaTbs = Lists.newArrayList();
                newOrders.forEach(e->{
                    OrderInfoTb orderInfoTb = new OrderInfoTb();
                    BeanUtils.copyProperties(e, orderInfoTb);
                    orderInfoTb.preInsert();
                    orderInfoTbs.add(orderInfoTb);

                    List<OrdCommRelaTbPo> ordCommRelas = e.getOrdCommRelaTbs();
                    if(ConverterUtil.isNotEmpty(ordCommRelas)){
                        ordCommRelas.forEach(oc -> {
                            OrdCommRelaTb ordCommRelaTb = new OrdCommRelaTb();
                            BeanUtils.copyProperties(oc, ordCommRelaTb);
                            ordCommRelaTb.setOrdId(orderInfoTb.getId());
                            ordCommRelaTb.preInsert();
                            ordCommRelaTbs.add(ordCommRelaTb);
                        });
                    }
                    finalOrderNums.add(e.getOrdNum());
                });
                //批量查如订单同步表数据
                orderInfoTbMapper.batchInsert(orderInfoTbs);
                //批量插入订单商品同步表数据
                ordCommRelaTbMapper.batchInsert(ordCommRelaTbs);
                //更新订单编号列表缓存
                jedisDao.setSerialize(ORDER_NUM_LIST, finalOrderNums);
            }
        }
        return result;
    }
}
