package com.wisea.cultivar.common.dao.bigdata;

import com.wisea.cloud.common.mybatis.persistence.CrudDao;
import com.wisea.cultivar.common.entity.bigdata.JyOrdMage;
import com.wisea.cultivar.common.po.bigdata.HeadquartersCategoryTransactionTrendsPo;
import com.wisea.cultivar.common.po.bigdata.HeadquartersTransactionRankingPo;
import com.wisea.cultivar.common.po.bigdata.JyOrdMageListPo;
import com.wisea.cultivar.common.po.bigdata.JyOrdMagePagePo;
import com.wisea.cultivar.common.vo.bigdata.HeadquartersCategoryTransactionTrendsVo;
import com.wisea.cultivar.common.vo.bigdata.HeadquartersTransactionRankingVo;
import com.wisea.cultivar.common.vo.bigdata.JyOrdMageListVo;
import com.wisea.cultivar.common.vo.bigdata.TotalOrderSalesVo;

import java.util.List;

/**
 * jy_ord_mage 表DAO
 * 交易订单管理
 * 2019/12/02 11:02:14
 */
/**
 * 分页查询
 */

/**
 * 列表查询
 */
public interface JyOrdMageMapper extends CrudDao<JyOrdMage> {
    List<JyOrdMageListVo> findPage(JyOrdMagePagePo jyOrdMagePagePo);

    List<JyOrdMageListVo> findList(JyOrdMageListPo jyOrdMageListPo);

    /**
     * @Author jirg
     * @Date 2019/12/4 14:42
     * @Description 查询所有订单编号列表
     **/
    List<String> findOrdNums();

    /**
     * @Author jirg
     * @Date 2019/12/6 11:26
     * @Description 国内/国外单品交易排行列表
     **/
    List<HeadquartersTransactionRankingVo> transactionRanking(HeadquartersTransactionRankingPo po);

    /**
     * @Author jirg
     * @Date 2019/12/6 14:36
     * @Description 国内/国外品类交易走势分析
     **/
    List<HeadquartersCategoryTransactionTrendsVo> categoryTransactionTrends(HeadquartersCategoryTransactionTrendsPo po);

    /**
     * @Author jirg
     * @Date 2019/12/9 15:52
     * @Description 获取当前年国内外订单销售总额
     **/
    List<TotalOrderSalesVo> getTotalOrderSales();

    /**
     * @Author jirg
     * @Date 2020/2/5 14:32
     * @Description 获取订单年份列表
     **/
    List<String> getOrdYears();
}
