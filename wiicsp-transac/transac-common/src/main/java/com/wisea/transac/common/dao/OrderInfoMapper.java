package com.wisea.transac.common.dao;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.OrderInfo;
import com.wisea.transac.common.po.trade.*;
import com.wisea.transac.common.vo.StateTypeVo;
import com.wisea.transac.common.vo.TransactionDataChartVo;
import com.wisea.transac.common.vo.trade.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface OrderInfoMapper extends CrudDao<OrderInfo> {
    /**
     * 商家（后台）查询订单列表
     * @param po
     * @return
     */
    List<MerchantOrderInfoListVo> findMerchantOrderList(MerchantOrderInfoListPo po);

    /**
     * 查询各个状态下订单数量
     * @param po
     * @return
     */
    List<StateTypeVo> findCountByState(MerchantOrderInfoListPo po);

    /**
     * 查询订单详细信息
     * @param orderInfoPo
     * @return
     */
    OrderInfoVo findOrderInfo(OrderInfoPo orderInfoPo);

    /**
     * @Author jirg
     * @Date 2020/6/9 16:54
     * @Description 卖家/买家查询提货信息详情
     */
    DeliveryInfoVo findDeliveryInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2020/5/7 10:50
     * @Description 查询提货单信息
     **/
    BillOfLadingVo findBillOfLad(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2020/5/7 15:00
     * @Description 根据自提码查询自提订单详情
     **/
    ZtOrderInfoVo findByZtNum(@Param("ztNum") String ztNum);

    List<String> findOrderNum(String ordNum);

    /**
     * 查询分页信息
     * @param po
     * @return
     */
    List<BuyerOrderInfoListVo> findBuyerPage (BuyerOrderInfoListPo po);

    /**
     * 查询订单信息
     * @param po
     * @return
     */
    List<BuyerOrderInfoListVo> findBuyerList (BuyerOrderInfoListPo po);

    /**
     * 买家端查询各个状态下订单数量
     * @param po
     * @return
     */
    List<StateTypeVo> orderNumb(BuyerOrderInfoListPo po);

    /**
     * @Author jirg
     * @Date 2020/5/14 9:44
     * @Description 查询未结算的订单列表
     **/
    List<OrderInfo> findNotSettledOrds(Map<String, Object> parameter);

    /**
     * @Author jirg
     * @Date 2020/5/14 9:43
     * @Description 更新订单结算单生成状态
     **/
    void updateSettleBillGenerateType(SettleBillGenerateTypePo updatePo);

    /**
     * @Author jirg
     * @Date 2020/5/18 15:09
     * @Description 根据买卖方ID查询未出账结订单列表
     **/
    List<SettleOrdRelaInfoVo> findUnsettlementList(@Param("sellerId") Long sellerId, @Param("buyerId") Long buyerId);

    /**
     * 根据IDS查询订单s
     * @param ordIds
     * @return
     */
    List<OrderInfo> findOrderByIds (@Param("ordIds") String ordIds);

    /**
     * @Author jirg
     * @Date 2020/5/19 14:48
     * @Description 查询未出账单列表
     */
    List<OutstandingBillVo> outstandingBill(OutstandingBillPo po);

    /**
     * @Author jirg
     * @Date 2020/5/19 14:48
     * @Description 查询未出账单详细信息
     */
    OutstandingBillInfoVo outstandingBillInfo(OutstandingBillInfoPo po);

    /**
     * 买家查询未出账单列表
     * @param po
     * @return
     */
    List<BuyerNotSettleListVo> buyerNotSettleList(BuyerNotSettleListPo po);

    /**
     * 查询订单退了信息
     * @param id
     * @return
     */
    BuyerOrdRefundInfoVo findOrdRefundInfo (Long id);

    /**
     * @Author jirg
     * @Date 2020/5/25 14:32
     * @Description 昨日交易统计
     */
    YesterdayStatisticsVo yesterdayStatistics(Map<String, Object> paramMap);

    /**
     * @Author jirg
     * @Date 2020/5/25 16:29
     * @Description 服务费统计
     */
    ServiceFeeStatisticsVo serviceFeeStatistics(ServiceFeeStatisticsPo po);

    /**
     * @Author jirg
     * @Date 2020/5/26 9:43
     * @Description 交易首页-订单状态数量
     */
    OrderStatisticsVo orderStatistics(Map<String, Object> paramMap);

    /**
     * @Author jirg
     * @Date 2020/5/26 16:50
     * @Description 查询超时待自提的订单列表
     */
    List<OrderInfo> findDeliveryTimeoutOrders();

    /**
     * 查询超时待确认和超时代付款的订单
     * @return
     */
    List<OrderInfo> findPreOutTimeOrders();

    /**
     * 统计订单总额
     * @param po
     * @return
     */
    List<StatisOrderVo> statisOrder (StaticOrderPo po);

    /**
     * 统计付款订单数量
     * @param po
     * @return
     */
    StatisOrderVo statisPayOrd (StaticOrderPo po);

    /**
     * 统计退款金额
     * @param po
     * @return
     */
    Double statisRefund (StaticOrderPo po);

    /**
     * 订单金额分布
     * @param po
     * @return
     */
    List<ChartVo> ordAmountStatics (StaticOrderPo po);

    /**
     * 档口成交金额
     * @param po
     * @return
     */
    List<ChartVo> stallAmountStatis (StaticOrderPo po);

    /**
     * @Date 2019/5/7 17:26
     * @Description 查询自提码列表
     **/
    List<String> findOrdZtNum(@Param("ztNum") String parameter);

    /**
     * 采购商消费金额分布
     * @param po
     * @return
     */
    List<ChartVo> cgsPayCountStatics (StaticOrderPo po);

    /**
     * 金额分布
     * @param po
     * @return
     */
    List<TransactionDataChartVo> selectTransactionDataChartVo (StaticOrderPo po);

    /**
     * 根据买家Id查询未完成订单数量，订单完成状态有：  已完成2，已取消3，待评价5
     * @param buyerId
     * @return
     */
    Integer countOrderNoCompleteByBuyerId(Long buyerId);

    /**
     * 查询订单列表，同步订单使用
     * @param parameMap
     * @return
     */
    List<OrderInfoTbVo> findSyncOrders(Map<String, Object> parameMap);
}
