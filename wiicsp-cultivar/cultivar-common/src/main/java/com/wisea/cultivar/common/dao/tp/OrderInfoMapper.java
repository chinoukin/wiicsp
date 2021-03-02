package com.wisea.cultivar.common.dao.tp;

import java.time.OffsetDateTime;
import java.util.List;
import java.util.Map;

import com.wisea.cultivar.common.vo.bigdata.OrderNumVo;
import com.wisea.cultivar.common.vo.bigdata.TransMapVo;
import com.wisea.cultivar.common.vo.bigdata.TypeTrendVo;
import com.wisea.cultivar.common.entity.tp.OrderInfoMiddle;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.tp.OrderInfo;
import com.wisea.cultivar.common.entity.tp.RefundCommAppl;
import com.wisea.cultivar.common.po.tp.OrderInfoListPo;
import com.wisea.cultivar.common.po.tp.OrderInfoPagePo;
import com.wisea.cultivar.common.po.tp.StaticOrderPo;
import com.wisea.cultivar.common.po.tp.statistics.BuyerTopNumPo;
import com.wisea.cultivar.common.po.tp.statistics.MembStaticsPo;
import com.wisea.cultivar.common.po.tp.statistics.StatisticsPo;
import com.wisea.cultivar.common.po.tp.trade.BuyerOrderInfoListPo;
import com.wisea.cultivar.common.po.tp.trade.MerchantOrderInfoListPo;
import com.wisea.cultivar.common.po.tp.trade.OrderInfoPo;
import com.wisea.cultivar.common.po.tp.trade.RefundInfoPo;
import com.wisea.cultivar.common.vo.tp.OrderDataVo;
import com.wisea.cultivar.common.vo.tp.OrderInfoForSettleVo;
import com.wisea.cultivar.common.vo.tp.OrderInfoListVo;
import com.wisea.cultivar.common.vo.tp.StateTypeVo;
import com.wisea.cultivar.common.vo.tp.statistics.AdminToBeProcessedVo;
import com.wisea.cultivar.common.vo.tp.statistics.AdminTodayStatisticsVo;
import com.wisea.cultivar.common.vo.tp.statistics.BuyerTopNumVo;
import com.wisea.cultivar.common.vo.tp.statistics.ChartVo;
import com.wisea.cultivar.common.vo.tp.statistics.OrderAmounStatisticsVo;
import com.wisea.cultivar.common.vo.tp.statistics.OrderCountStatisticsVo;
import com.wisea.cultivar.common.vo.tp.statistics.OrderStatatcsVo;
import com.wisea.cultivar.common.vo.tp.statistics.SellerSalesStatisticsVo;
import com.wisea.cultivar.common.vo.tp.statistics.SellerToBeProcessedVo;
import com.wisea.cultivar.common.vo.tp.statistics.TransactionDataChartVo;
import com.wisea.cultivar.common.vo.tp.statistics.TransactionDataVo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerOrderInfoListVo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.MerchantOrderInfoListVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderDeliveryListVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderInfoZtVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderInventoryVo;

/**
 * order_info 表DAO
 * 冗余商品发布id
 * 2018/09/18 17:40:35
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface OrderInfoMapper extends CrudDao<OrderInfo> {

	/**
	 * 买家端查询列表（分页用）
	 * @param orderInfoPagePo
	 * @return
	 */
    List<BuyerOrderInfoListVo> findPage(BuyerOrderInfoListPo orderInfoPagePo);

    /**
	 * 买家端查询列表（带商品信息）
	 * @param orderInfoListPo
	 * @return
	 */
    List<BuyerOrderInfoListVo> findList(BuyerOrderInfoListPo orderInfoListPo);
    /**
     * 商家（后台）查询订单列表
     * @param po
     * @return
     */
    List<MerchantOrderInfoListVo> findMerchantOrderList(MerchantOrderInfoListPo po);

	/**
	 * 查询订单详细信息
	 * @param orderInfoPo
	 * @return
	 */
	OrderInfoVo findOrderInfo(OrderInfoPo orderInfoPo);

	/**
	 * 根据ids 查询未付款和待发货的订单列表
	 * @param ids
	 * @return
	 */
    List<OrderInfo> selectByIds(List<Long> ids);

	/**
	 * 批量修改订单状态为已取消
	 * @param orderIds
	 */
	void batchUpdateStatus(List<Long> orderIds);

	/**
	 * 根据ids查询订单列表
	 * @param orderIds
	 * @return
	 */
	List<OrderInfo> findByIds(@Param("list") List<Long> orderIds, @Param("orderStateType") String orderStateType, @Param("sellerId") Long sellerId);

	/**
	 * 批量修改订单发货信息
	 * @param parameterMap
	 */
	void batchDeliveOrder(Map<String, Object> parameterMap);

	/**
	 * 查询发货单列表
	 * @param orderIds2
	 * @return
	 */
	List<OrderInventoryVo> findOrderInventory(List<Long> orderIds2);

	/**
	 * 查询退款详情
	 * @param refundInfoPo
	 * @return
	 */
	BuyerRefundInfoVo selRefundByOrdId (RefundInfoPo refundInfoPo);

	/**
	 * 查询各个状态下订单数量
	 * @param po
	 * @return
	 */
    List<StateTypeVo> findCountByState(MerchantOrderInfoListPo po);

	/**
	 * 买家端查询各个状态下订单数量
	 * @param po
	 * @return
	 */
    List<StateTypeVo> orderNumb(BuyerOrderInfoListPo po);

	/**
	 * 查询批量发货订单列表
	 * @param orderIds2
	 * @return
	 */
	List<OrderDeliveryListVo> findDeliveryList(List<Long> orderIds2);

	/**
	* 得到订单的基础信息
	* */
    OrderDataVo getOrderBaseData(OrderInfoListPo po);

    /**
	 * 得到退款退货金额
	 * */
	List<OrderDataVo> getRefundMoney(Long ordId);

	/**
	 * 按结算单ID和结算单中订单类型分页查询订单
	 * @param po
	 * @return
	 */
	List<OrderInfoListVo> findNormalOrdBySettleId(OrderInfoPagePo po);

	List<OrderInfoListVo> findRefundOrdBySettleIdByOrdType(OrderInfoPagePo po);

	/**
	 * 按确认日期和type=3查询所有订单
	 * @param map 包含startDate、endDate,都不能为空
	 * @return
	 */
	List<OrderInfoForSettleVo> findAllOrderInfoByDateAndType3(Map<String,Object> map);

	/**
	 * 按退货处理完成时间查询退货的订单
	 * @param map 包含startDate、endDate，都不能为空
	 * @return
	 */
	List<OrderInfoForSettleVo> findRefundCommOrderInfoByDate(Map<String,Object> map);

	/**
	 * 根据IDS查询订单s
	 * @param ordIds
	 * @return
	 */
	List<OrderInfo> findOrderByIds (@Param("ordIds") String ordIds);

	/**
	 * 订单超时未支付定时任务
	 */
	void orderPayTask (@Param("ordIds") String ordIds);

	/**
	 * 查询所有超时的订单id
	 * @return
	 */
	List<Long> selOutofPayDeadDate ();

	/**
	 * 查询所有超时为收货的订单id
	 * @return
	 */
	List<Long> selOutofConfimDeadDate ();

	/**
	 * 订单自动确认收货定时任务
	 */
	void orderConfirmTask ();

	/**
	 * 根据订单id查询退款总金额
	 * @param ordId
	 * @return
	 */
	OrderDataVo totalRefundMonuy(@Param("ordId") Long ordId);

	List<String> findOrderNum(String ordNum);

	/**
	 * 后台今日销售/用户统计
	 * @param paramMap
	 * @return
	 */
    AdminTodayStatisticsVo adminTodayStatistics(Map<String, OffsetDateTime> paramMap);

	/**
	 * 后台待处理事务
	 * @return
	 */
	AdminToBeProcessedVo adminToBeProcessed();

	/**
	 * 卖家今近几日销售统计统计
	 * @param paramMap
	 * @return
	 */
    SellerSalesStatisticsVo sellerSalesStatistics(Map<String, Object> paramMap);

	/**
	 * 卖家待处理事务
	 * @param paramMap
	 * @return
	 */
	SellerToBeProcessedVo sellerToBeProcessed(Map<String, Object> paramMap);

	/**
	 * 订单数量统计
	 * @param paramMap
	 * @return
	 */
	OrderCountStatisticsVo orderCountStatistics(Map<String, Object> paramMap);

	/**
	 * 销售金额统计
	 * @param paramMap
	 * @return
	 */
	OrderAmounStatisticsVo orderAmounStatistics(Map<String, Object> paramMap);

	/**
	 * 订单统计
	 * @param paramMap
	 * @return
	 */
    TransactionDataVo transactionData(StatisticsPo paramMap);

	/**
	 * 查询订单金额区间
	 * @param po
	 * @return
	 */
	Integer findOrderAmountInterval(StatisticsPo po);

	/**
	 * 订单金额分布
	 * @param paramMap
	 * @return
	 */
	List<ChartVo> orderAmountDistributed(Map<String, Object> paramMap);

	/**
     * 查询会员消费统计横坐标间隔
     * @param membStaticsPo
     * @return
     */
    String membBuyStaticsCut (MembStaticsPo membStaticsPo);

    /**
     * 会员消费统计
     * @param membStaticsPo
     * @return
     */
    List<ChartVo> membBuyStatics (MembStaticsPo membStaticsPo);

    /**
     * 用户排行
     * @param buyerTopNumPo
     * @return
     */
    List<BuyerTopNumVo> buyerTopNumber (BuyerTopNumPo buyerTopNumPo);

    /**
     * 订单统计
     * @param buyerTopNumPo
     * @return
     */
    List<OrderStatatcsVo> orderStatics (BuyerTopNumPo buyerTopNumPo);

    List<RefundCommAppl> checkRefundComm (Long orderId);

    Integer getRefundNotes(OrderInfoListPo po);

    /**
     * @Author jirg
     * @Date 2019/4/19 15:51
     * @Description 根据自提码查询订单信息
     **/
	OrderInfoZtVo findOrdByZtNum(@Param("ztNum") String ztNum);

	/**
	 * @Author jirg
	 * @Date 2019/4/23 19:13
	 * @Description 查询指定时间范围内未结算的订单列表
	 **/
	List<OrderInfo> findNotSettledOrds(Map<String, Object> parameter);

	Double refundMoneyFinish (Long ordId);

	/**
	 * @Author jirg
	 * @Date 2019/5/7 17:26
	 * @Description 查询自提码列表
	 **/
    List<String> findOrdZtNum(@Param("ztNum") String parameter);

    List<TransactionDataChartVo> transMouthChartVo (StaticOrderPo po);



    /**
     *采购等级占比
     * @return
     */
    List<ChartVo> transLevelData ();

    /**
     *采购规格占比
     * @return
     */
    List<ChartVo> transSpecData ();

    /**
     *采购品牌占比
     * @return
     */
    List<ChartVo> transBrandData ();

    /**
     *采购价格占比
     * @return
     */
    List<ChartVo> transOrdAmount();

    /**
     *供应商热销排行
     * @return
     */
    List<ChartVo> transSerllerPm ();

    /**
     *热销城市占比
     * @return
     */
    List<ChartVo> transRxCityData ();
	/**
	 *采购类别占比分析
	 * @return
	 */
//	List<ChartVo> categoryScale();
    /**
     *采购类型走势分析
     * @return
     */
//	List<TypeTrendVo> typeTrend(StaticOrderPo po);
	/**
	 * 封装交易地图数据
	 * */
	List<TransMapVo> findMapList();

	/**
	 * 查询同步订单列表
	 * @param parameMap
	 * @return
	 */
    List<OrderInfoMiddle> findSyncOrders(Map<String, Object> parameMap);
}
