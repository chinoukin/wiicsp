package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.OrdCancelReasonMage;
import com.wisea.cultivar.common.po.tp.OrdCancelReasonMageListPo;
import com.wisea.cultivar.common.po.tp.OrdCancelReasonMagePagePo;
import com.wisea.cultivar.common.vo.tp.OrdCancelReasonMageListVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;

/**
 * ord_cancel_reason_mage 表DAO
 * 订单取消原因管理
 * 2018/10/10 14:42:38
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface OrdCancelReasonMageMapper extends CrudDao<OrdCancelReasonMage> {
    List<OrdCancelReasonMageListVo> findPage(OrdCancelReasonMagePagePo ordCancelReasonMagePagePo);

    List<OrdCancelReasonMageListVo> findList(OrdCancelReasonMageListPo ordCancelReasonMageListPo);

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    OrdCancelReasonMageListVo findById(@Param("id") Long id);

    /**
     * 分页查询
     * @param ordCancelReasonMagePagePo
     * @return
     */
    List<OrdCancelReasonMageListVo> findForPage(OrdCancelReasonMagePagePo ordCancelReasonMagePagePo);

    /**
     * 查询订单取消原因
     * @return
     */
    List<OrdCancelReasonMageListVo> findAllReason();
}
