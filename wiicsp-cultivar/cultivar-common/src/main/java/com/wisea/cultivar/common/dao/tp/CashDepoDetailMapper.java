package com.wisea.cultivar.common.dao.tp;


/**
 * cash_depo_detail 表DAO
 * 提现明细
 * 2019/01/22 09:30:04
 */
/**
 * 分页查询
 */

import com.wisea.cultivar.common.entity.tp.CashDepoDetail;
import com.wisea.cultivar.common.po.tp.CashDepoDetailPagePo;
import com.wisea.cultivar.common.vo.tp.CashDepoDetailListVo;
import com.wisea.cloud.common.mybatis.persistence.CrudDao;

import java.util.List;

/**
 * 列表查询
 */
public interface CashDepoDetailMapper extends CrudDao<CashDepoDetail> {

    /**
     * 根据交易流水号修改提现表中的状态
     * @param cashDepoDetail
     */
    void updateByTradeNo(CashDepoDetail cashDepoDetail);

    /**
     * 查询提现明细列表
     * @param cashDepoDetailPagePo
     * @return
     */
    List<CashDepoDetailListVo> findPage(CashDepoDetailPagePo cashDepoDetailPagePo);

//    List<CashDepoDetailListVo> findList(CashDepoDetailListPo cashDepoDetailListPo);

}
