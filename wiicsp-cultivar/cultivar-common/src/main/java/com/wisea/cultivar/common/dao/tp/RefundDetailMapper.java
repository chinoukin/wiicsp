package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.RefundDetail;
import com.wisea.cultivar.common.po.tp.RefundDetailListPo;
import com.wisea.cultivar.common.po.tp.RefundDetailPagePo;
import com.wisea.cultivar.common.po.tp.trade.RefundDListPo;
import com.wisea.cultivar.common.vo.tp.RefundDetailListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.RefundDListVo;

/**
 * refund_detail 表DAO
 * 退款明细
 * 2019/01/23 10:21:32
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface RefundDetailMapper extends CrudDao<RefundDetail> {
    List<RefundDetailListVo> findPage(RefundDetailPagePo refundDetailPagePo);

    List<RefundDetailListVo> findList(RefundDetailListPo refundDetailListPo);

    List<RefundDListVo> selRefundDList (RefundDListPo po);
}
