package com.wisea.cultivar.common.dao.tp;

import com.wisea.cultivar.common.entity.tp.RefundReasonMage;
import com.wisea.cultivar.common.po.tp.RefundReasonMageListPo;
import com.wisea.cultivar.common.po.tp.RefundReasonMagePagePo;
import com.wisea.cultivar.common.vo.tp.RefundReasonMageListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * refund_reason_mage 表DAO
 * 退货退款原因管理
 * 2018/09/18 14:36:47
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface RefundReasonMageMapper extends CrudDao<RefundReasonMage> {
    List<RefundReasonMageListVo> findPage(RefundReasonMagePagePo refundReasonMagePagePo);

    List<RefundReasonMageListVo> findList(RefundReasonMageListPo refundReasonMageListPo);

    /**
     * 按ID查询
     * @param id
     * @return
     */
    RefundReasonMageListVo findById(@Param("id") Long id);

    /**
     * 分页查询
     * @param refundReasonMagePagePo
     * @return
     */
    List<RefundReasonMageListVo> findForPage(RefundReasonMagePagePo refundReasonMagePagePo);

}
