package com.wisea.transac.common.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.transac.common.entity.RefundAppl;
import com.wisea.transac.common.po.RefundApplPageListPo;
import com.wisea.transac.common.po.trade.BuyerRefundListPo;
import com.wisea.transac.common.vo.RefundApplInfoVo;
import com.wisea.transac.common.vo.RefundApplPageListVo;
import com.wisea.transac.common.vo.StateTypeVo;
import com.wisea.transac.common.vo.trade.BuyerRefundInfoVo;
import com.wisea.transac.common.vo.trade.BuyerRefundListVo;
import com.wisea.transac.common.vo.trade.RefundHandleInfoVo;

public interface RefundApplMapper extends CrudDao<RefundAppl> {
    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 分页查询RefundAppl
     */
    List<RefundApplPageListVo> findPageList(RefundApplPageListPo po);

    /**
     * @author wbf-code-generator
     * @date 2020/04/27 17:01:29
     * @Description 查询详细信息RefundAppl
     */
    RefundApplInfoVo findInfo(LongIdPo po);

    /**
     * @Author jirg
     * @Date 2020/5/9 10:50
     * @Description 查询最大退款申请编号
     **/
    List<String> findRefundMaxNum(@Param("refundNumFix") String refundNum);

    /**
     * @Author jirg
     * @Date 2020/5/9 14:45
     * @Description 查询个状态下的数量
     **/
    List<StateTypeVo> findCountByState(RefundApplPageListPo po);

    /**
     * @Author jirg
     * @Date 2020/5/11 9:39
     * @Description 查询处理信息
     **/
    RefundHandleInfoVo findRefundHandleInfo(LongIdPo po);

    RefundAppl findByOrderId(Long id);

    /**
     * @Author jirg
     * @Date 2020/5/14 9:47
     * @Description 根据订单列表查询退款列表
     **/
    List<RefundAppl> findListByOrdIds(List<Long> ordIdList);

    /**
     * 买家查询退款列表
     * @param po
     * @return
     */
    List<BuyerRefundListVo> buyerRefundList(BuyerRefundListPo po);

    /**
     * 查询角标
     * @param po
     * @return
     */
    List<StateTypeVo> refundNumb(BuyerRefundListPo po);

    /**
     * 买家查询退款详情
     * @param po
     * @return
     */
    BuyerRefundInfoVo buyerRefundInfo (LongIdPo po);
}
