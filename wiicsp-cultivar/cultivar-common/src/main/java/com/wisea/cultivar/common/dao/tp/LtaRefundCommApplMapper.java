package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.LtaRefundCommAppl;
import com.wisea.cultivar.common.entity.tp.RefundCommAppl;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.common.po.tp.lta.LtaRefundCommApplListPo;
import com.wisea.cultivar.common.po.tp.trade.BuyerRefundCommApplListPo;
import com.wisea.cultivar.common.vo.tp.StateTypeVo;
import com.wisea.cultivar.common.vo.tp.lta.InitLtaRefundCommApplVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaRefundCommApplInfoVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaRefundCommApplListVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundCommApplListVo;

public interface LtaRefundCommApplMapper extends CrudDao<LtaRefundCommAppl> {

    /**
     * @Author jirg
     * @Date 2019/5/10 10:24
     * @Description 查询个状态数量
     **/
    List<StateTypeVo> findCountByState(LtaRefundCommApplListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/10 10:24
     * @Description 查询长期协议退货申请列表
     **/
    List<LtaRefundCommApplListVo> findList(LtaRefundCommApplListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/10 16:15
     * @Description 查询长期协议退货申请详细信息
     **/
    LtaRefundCommApplInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2019/5/13 9:31
     * @Description 初始化退货拒绝退款
     **/
    InitLtaRefundCommApplVo initRefundCommAppl(LongIdPo po);

    /**
     * 查询所有的退款编号
     * @param refundNum
     * @return
     */
    List<String> findLtaRefundCommApplNum (String serNum);

    /**
     * @Author jirg
     * @Date 2019/5/14 11:22
     * @Description 根据订单id查询已完成的退货申请列表
     **/
    List<LtaRefundCommAppl> findListByOrdIds(List<Long> ltaOrdIdList);

    /**
     * @Author jirg
     * @Date 2019/5/15 15:29
     * @Description 根据订单ID查询未完成的退货申请
     **/
    List<RefundCommAppl> getOrderIfRefund(@Param("ordId") Long ltaOrdId);

    /**
     * 买家查询退货列表
     * @param po
     * @return
     */
    List<BuyerRefundCommApplListVo> buyerLtaRefundComList(BuyerRefundCommApplListPo po);
}
