package com.wisea.transac.tp.trade.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.cache.jedis.JedisDao;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.redisson.RedissLockUtil;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.transac.common.constants.ConstantCodeMsg;
import com.wisea.transac.common.dao.OrderInfoMapper;
import com.wisea.transac.common.vo.trade.OrderInfoTbVo;
import com.wisea.transac.tp.trade.mss.CultivarBigdataMss;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

/**
 * @Author jirg
 * @Date 2019/8/21 17:12
 * @Description TODO 订单同步Service，此功能为产品项目特有，如代码同步到洪九果品记得删除
 **/
@Service
public class OrderSyncService extends BaseService {
    @Autowired
    private OrderInfoMapper mapper;
    @Autowired
    private JedisDao jedisDao;
    @Autowired
    private CultivarBigdataMss cultivarBigdataMss;

    public static String SYNC_LOCAL_ORDER_START_DATE = "BIG_LOCAL_DATA_SYNC_ORDER_START_DATE";
    public static String SYNC_ORDER_LOCK = "SYNC_ORDER_LOCK";

    /**
     * @Author jirg
     * @Date 2020/9/24 14:38
     * @Description 订单同步
     **/
    public ResultPoJo<Object> orderSync() {
        RedissLockUtil.lock(SYNC_ORDER_LOCK);
        ResultPoJo<Object> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        try {
            List<OrderInfoTbVo> orders = Lists.newArrayList();
            //同步本地订单
            OffsetDateTime endDate = OffsetDateTime.now();
            List<OrderInfoTbVo> localOrders = syncLocal(endDate);
            orders.addAll(localOrders);
            //发送数据到种植服务
            ResultPoJo<String> stringResultPoJo = cultivarBigdataMss.orderSync(orders);
            checkRemoteResult(stringResultPoJo);
            jedisDao.setSerialize(SYNC_LOCAL_ORDER_START_DATE, endDate);
        } finally {
            RedissLockUtil.unlock(SYNC_ORDER_LOCK);
        }
        return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2020/9/24 14:40
     * @Description 同步本地订单
     **/
    private List<OrderInfoTbVo> syncLocal(OffsetDateTime endDate) {
        LoggerUtil.infoWithContext("【syncLocal】同步本地订单：", "");
        Map<String, Object> parameMap = Maps.newHashMap();
        OffsetDateTime startDate = jedisDao.getSerialize(SYNC_LOCAL_ORDER_START_DATE, OffsetDateTime.class);
        parameMap.put("startDate", startDate);
        parameMap.put("endDate", endDate);
        List<OrderInfoTbVo> localOrders = mapper.findSyncOrders(parameMap);
        return localOrders;
    }

    /**
     * 同步天猫订单数据
     * @param po
     * @return
     */
    /*public ResultPoJo<?> syncTmallOrders(TmallOrdersPo po) {
        LoggerUtil.infoWithContext("【syncTmallOrders】同步天猫订单数据：", po);
        ResultPoJo<?> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);
        if (ConverterUtil.isNotEmpty(po.getTmallOrders())){
            List<OrderInfoMiddle> tmallOrders = po.getTmallOrders();
            saveOrders(tmallOrders);
        }
        return resultPoJo;
    }*/

    /**
     *  保存订单数据
     * @param orders
     */
    /*public void saveOrders(List<OrderInfoMiddle> orders){
        if(ConverterUtil.isNotEmpty(orders)){
            HashSet<String> orderNums = jedisDao.getSerialize(ORDER_NUM_LIST, HashSet.class);
            if(ConverterUtil.isEmpty(orderNums)){
                orderNums = Sets.newHashSet();
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
    }*/
}
