package com.wisea.cultivar.common.dao.tp;

import java.util.List;

import com.wisea.cultivar.common.entity.tp.IncomeDetail;
import com.wisea.cultivar.common.po.tp.IncomeDetailListPo;
import com.wisea.cultivar.common.po.tp.IncomeDetailPagePo;
import com.wisea.cultivar.common.po.tp.trade.BuyerIncomeDetailListPo;
import com.wisea.cultivar.common.po.tp.trade.IncomeDListPo;
import com.wisea.cultivar.common.vo.tp.IncomeDetailListVo;
import org.apache.ibatis.annotations.Param;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.vo.tp.trade.BuyerIncomeDetailListVo;
import com.wisea.cultivar.common.vo.tp.trade.IncomeDListVo;

/**
 * income_detail 表DAO
 * 收入明细
 * 2019/01/23 10:21:32
 */
/**
 * 分页查询
 */
/**
 * 列表查询
 */
public interface IncomeDetailMapper extends CrudDao<IncomeDetail> {
    List<IncomeDetailListVo> findPage(IncomeDetailPagePo incomeDetailPagePo);

    List<IncomeDetailListVo> findList(IncomeDetailListPo incomeDetailListPo);

    List<IncomeDListVo> selIncomeDList (IncomeDListPo incomeDListPo);

    List<BuyerIncomeDetailListVo> incomeDetailList (BuyerIncomeDetailListPo po);

    BuyerIncomeDetailListVo selTotalIncome (@Param("membId")Long membId);
}
