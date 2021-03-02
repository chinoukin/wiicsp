package com.wisea.cultivar.common.dao.tp;

import java.util.List;
import java.util.Map;

import com.wisea.cultivar.common.entity.tp.LtaOrdInfo;
import com.wisea.cultivar.common.entity.tp.LtaRefundCommAppl;
import com.wisea.cultivar.common.po.tp.lta.LtaBuyerOrderInfoListPo;
import com.wisea.cultivar.common.po.tp.lta.LtaOrderListPo;
import com.wisea.cultivar.common.po.tp.trade.OrderInfoPo;
import com.wisea.cultivar.common.vo.tp.StateTypeVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaBuyerOrderInfoListVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaOrderInfoVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaOrderInventoryVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaOrderListVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.OrderInfoZtVo;

public interface LtaOrdInfoMapper extends CrudDao<LtaOrdInfo> {
    /**
     * @Author jirg
     * @Date 2019/5/7 14:57
     * @Description 查询个状态下订单数量
     **/
    List<StateTypeVo> findCountByState(LtaOrderListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/7 14:57
     * @Description 卖家/后台查询长期协议订单列表
     **/
    List<LtaOrderListVo> findList(LtaOrderListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/7 17:30
     * @Description 查询自提码列表
     **/
    List<String> findOrdZtNum(@Param("ztNum") String parameter);

    /**
     * @Author jirg
     * @Date 2019/5/8 14:46
     * @Description 查询订单详细信息
     **/
    LtaOrderInfoVo findOrderInfo(OrderInfoPo po);

    /**
     * 买家查询订单列表，带分页
     * @return
     */
    List<LtaBuyerOrderInfoListVo> buyerLtaOrdListPage (LtaBuyerOrderInfoListPo po);

    /**
     * 买家查询订单列表
     * @return
     */
    List<LtaBuyerOrderInfoListVo> buyerLtaOrdList (LtaBuyerOrderInfoListPo po);

    /**
	 * 买家端查询各个状态下订单数量
	 * @param po
	 * @return
	 */
    List<StateTypeVo> orderNumb(LtaBuyerOrderInfoListPo po);
    /**
     * @Author jirg
     * @Date 2019/5/9 9:45
     * @Description 根据ids和订单状态查询订单列表
     **/
    List<LtaOrdInfo> findByIdsAndStateType(@Param("list") List<Long> orderIds, @Param("orderStateType") String orderStateType, @Param("sellerId") Long sellerId);

    /**
     * @Author jirg
     * @Date 2019/5/9 9:47
     * @Description 查询发货单列表
     **/
    List<LtaOrderInventoryVo> findOrderInventory(List<Long> orderIds2);

    /**
     * @Author jirg
     * @Date 2019/5/9 10:01
     * @Description 根据ids 查询有待处理退款申请订单列表
     **/
    List<LtaOrdInfo> selectByIds(List<Long> ids);
    /**
     * @Author jirg
     * @Date 2019/5/13 18:04
     * @Description 查询自提订单
     **/
    OrderInfoZtVo findOrdByZtNum(@Param("ztNum") String ztNum);

    List<String> findOrderNum(@Param("ordNum") String ordNum);

    /**
     * @Author jirg
     * @Date 2019/5/14 10:27
     * @Description 查询结算单周期内订单列表
     **/
    List<LtaOrdInfo> findNotSettledOrds(Map<String, Object> parameter);

    List<LtaRefundCommAppl> checkLtaRefundComm (Long orderId);

    Double refundMoneyFinish (Long ordId);

    /**
	 * 根据IDS查询订单s
	 * @param ordIds
	 * @return
	 */
	List<LtaOrdInfo> findOrderByIds (@Param("ordIds") String ordIds);

	/**
	 * 查询所有超时的订单id
	 * @return
	 */
	List<Long> selOutofPayDeadDate ();

	/**
	 * 订单超时未支付定时任务
	 */
	void orderPayTask ();

	/**
	 * 查询所有超时为收货的订单id
	 * @return
	 */
	List<Long> selOutofConfimDeadDate ();

	List<LtaRefundCommAppl> checkRefundComm (Long orderId);

	/**
	 * 订单自动确认收货定时任务
	 */
	void orderConfirmTask ();
}
