package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.RefundCommAppl;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.common.po.tp.trade.BuyerRefundCommApplListPo;
import com.wisea.cultivar.common.po.tp.trade.RefundCommApplListPo;
import com.wisea.cultivar.common.vo.tp.StateTypeVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundCommApplListVo;
import com.wisea.cultivar.common.vo.tp.trade.InitRefundCommApplVo;
import com.wisea.cultivar.common.vo.tp.trade.RefundCommApplInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.RefundCommApplListVo;
import org.apache.ibatis.annotations.Param;

/**
 * refund_comm_appl 表DAO
 * 退货申请
 * 2018/09/30 09:46:17
 */
public interface RefundCommApplMapper extends CrudDao<RefundCommAppl> {
    List<RefundCommApplListVo> findPage(RefundCommApplListPo refundCommApplPagePo);

    List<RefundCommApplListVo> findList(RefundCommApplListPo refundCommApplListPo);

    List<StateTypeVo> findCountByState(RefundCommApplListPo po);

    RefundCommApplInfoVo findInfo(LongIdPo po);

    InitRefundCommApplVo initRefundCommAppl(LongIdPo po);

    List<BuyerRefundCommApplListVo> buyerRefundComList (BuyerRefundCommApplListPo po);

    /*
     * 首先查询该订单是否退款
     * */
    List<RefundCommAppl> getOrderIfRefund(@Param("ordId") Long ordId);

    /**
     * 查询所有的退款编号
     * @param refundNum
     * @return
     */
    List<String> findRefundCommApplNum (String serNum);

    /**
     * @Author jirg
     * @Date 2019/4/23 19:47
     * @Description 根据订单id列表查询退货申请列表
     **/
    List<RefundCommAppl> findListByOrdIds(List<Long> ordList);
}
