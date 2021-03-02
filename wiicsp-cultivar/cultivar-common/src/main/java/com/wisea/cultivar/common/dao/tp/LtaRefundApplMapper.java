package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.LtaRefundAppl;
import com.wisea.cultivar.common.po.tp.LongIdPo;
import com.wisea.cultivar.common.po.tp.lta.LtaBuyerRefundApplListPo;
import com.wisea.cultivar.common.po.tp.lta.LtaRefundApplListPo;
import com.wisea.cultivar.common.vo.tp.StateTypeVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaBuyerRefundApplInfoVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaBuyerRefundApplListVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaRefundApplInfoVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaRefundApplListVo;
import com.wisea.cultivar.common.vo.tp.lta.LtaRefundCommApplCitVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.BuyerRefundApplInfoVo;

public interface LtaRefundApplMapper extends CrudDao<LtaRefundAppl> {
    /**
     * @Author jirg
     * @Date 2019/5/9 16:56
     * @Description 查询长期协议订单退款申请列表
     **/
    List<LtaRefundApplListVo> findPageList(LtaRefundApplListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/9 16:57
     * @Description 查询个状态下订单数量列表
     **/
    List<StateTypeVo> findCountByState(LtaRefundApplListPo po);

    /**
     * @Author jirg
     * @Date 2019/5/9 17:18
     * @Description 查询长期协议退款申请详细信息
     **/
    LtaRefundApplInfoVo findInfo(LongIdPo po);

    LtaRefundAppl findByOrderId(Long id);

    /**
     * 查询所有的退款编号
     * @param refundNum
     * @return
     */
    List<String> findLtaRefundApplNum (String refundNum);

    /**
     * 买家端查询退款列表
     * @param po
     * @return
     */
    List<LtaBuyerRefundApplListVo> buyerLtaRefundList (LtaBuyerRefundApplListPo po);

    /**
     * 买家端查询退款列表(小程序)
     * @param po
     * @return
     */
    List<LtaBuyerRefundApplListVo> buyerLtaRefundListApp (LtaBuyerRefundApplListPo po);

    /**
     * 买家端查询退款详情
     * @param id
     * @return
     */
    LtaBuyerRefundApplInfoVo buyerRefundInfo (Long id);

    /**
     * 买家端根据订单id查询最新一条退款信息
     * @param id
     * @return
     */
    BuyerRefundApplInfoVo selNewRefundByOrdId (Long id);

    /**
     * 查询退款申请详情
     * @param ordId
     * @return
     */
    List<LtaRefundCommApplCitVo> commitRefundCommInvo (Long ordId);
}
