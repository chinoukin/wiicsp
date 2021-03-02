package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.RefundAppl;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.common.po.tp.RefundApplPagePo;
import com.wisea.cultivar.common.po.tp.trade.BuyerRefundApplListPo;
import com.wisea.cultivar.common.po.tp.trade.RefundApplListPo;
import com.wisea.cultivar.common.vo.tp.StateTypeVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundApplInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundApplListVo;
import com.wisea.cultivar.common.vo.tp.trade.RefundApplInfoVo;
import com.wisea.cultivar.common.vo.tp.trade.RefundApplListVo;

/**
 * refund_appl 表DAO
 * 退款申请
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface RefundApplMapper extends CrudDao<RefundAppl> {
    List<RefundApplListVo> findPage(RefundApplPagePo refundApplPagePo);

    List<RefundApplListVo> findList(RefundApplListPo refundApplListPo);

    List<RefundApplListVo> findPageList(RefundApplListPo po);

    List<StateTypeVo> findCountByState(RefundApplListPo po);

    RefundApplInfoVo findInfo(LongIdPo po);

    RefundAppl findByOrderId(Long id);

    /**
     * 买家端查询退款列表
     * @param po
     * @return
     */
    List<BuyerRefundApplListVo> buyerRefundList (BuyerRefundApplListPo po);

    /**
     * 买家端查询退款列表(小程序)
     * @param po
     * @return
     */
    List<BuyerRefundApplListVo> buyerRefundListApp (BuyerRefundApplListPo po);

    /**
     * 买家端查询退款详情
     * @param id
     * @return
     */
    BuyerRefundApplInfoVo buyerRefundInfo (Long id);

    /**
     * 买家端根据订单id查询最新一条退款信息
     * @param id
     * @return
     */
    BuyerRefundApplInfoVo selNewRefundByOrdId (Long id);

    /**
     * 查询所有的退款编号
     * @param refundNum
     * @return
     */
    List<String> findRefundApplNum (String refundNum);
}
