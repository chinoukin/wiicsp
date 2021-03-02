package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.SubEntpMage;
import com.wisea.cultivar.common.po.bigdata.BuyerSalesRankPo;
import com.wisea.cultivar.common.po.bigdata.QueryTotalPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMageListPo;
import com.wisea.cultivar.common.po.bigdata.SubEntpMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.AreaReportVo;
import com.wisea.cultivar.common.vo.bigdata.BuyerSalesRankVo;
import com.wisea.cultivar.common.vo.bigdata.GetJxRankVo;
import com.wisea.cultivar.common.vo.bigdata.QueryTotalVo;
import com.wisea.cultivar.common.vo.bigdata.SubEntpMageListVo;
import com.wisea.cultivar.common.vo.bigdata.XlRankVo;
import com.wisea.cultivar.common.vo.bigdata.XsAnalysisVo;

import java.util.List;

/**
 * sub_entp_mage 表DAO
 * 分公司名录管理
 * 2019/12/02 11:02:15
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface SubEntpMageMapper extends CrudDao<SubEntpMage> {
    List<SubEntpMageListVo> findPage(SubEntpMagePagePo subEntpMagePagePo);

    List<SubEntpMageListVo> findList(SubEntpMageListPo subEntpMageListPo);

	QueryTotalVo getTotal(QueryTotalPo po);

	List<BuyerSalesRankVo> getXsRank(BuyerSalesRankPo buyerSalesRankPo);

	List<XsAnalysisVo> getXsAnalysisMonth(BuyerSalesRankPo buyerSalesRankPo);

	List<XsAnalysisVo> getXsAnalysisYear(BuyerSalesRankPo buyerSalesRankPo);

	List<GetJxRankVo> getJxRank(BuyerSalesRankPo buyerSalesRankPo);

	List<AreaReportVo> getAreaReportYear(BuyerSalesRankPo buyerSalesRankPo);

	List<AreaReportVo> getAreaReportMonth(BuyerSalesRankPo buyerSalesRankPo);

	List<XlRankVo> getXlRankYear(BuyerSalesRankPo buyerSalesRankPo);

	List<XlRankVo> getXlRankMonth(BuyerSalesRankPo buyerSalesRankPo);

}
