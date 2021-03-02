package com.wisea.cultivar.bigdata.service;

import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.model.Page;
import com.wisea.cultivar.common.po.bigdata.*;
import com.wisea.cultivar.common.vo.bigdata.*;
import com.wisea.cultivar.common.dao.bigdata.JyOrdMageMapper;
import com.wisea.cultivar.common.dao.bigdata.LockSourceInfoMapper;
import com.wisea.cultivar.common.dao.bigdata.RkSourceInfoMapper;
import com.wisea.cultivar.common.dao.bigdata.ZtSourceInfoMapper;
import com.wisea.cultivar.bigdata.utils.CacheUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author jirg
 * @version 1.0
 * @className HeadquartersTransactionsService
 * @date 2019/12/5 16:45
 * @Description 总部交易动态展示相关接口（大数据前端展示接口集合）
 */
@Service
public class HeadTradingDynamicService extends BaseService {
    @Autowired
    protected JyOrdMageMapper jyOrdMageMapper;
    @Autowired
    protected LockSourceInfoMapper lockSourceInfoMapper;
    @Autowired
    protected RkSourceInfoMapper rkSourceInfoMapper;
    @Autowired
    protected ZtSourceInfoMapper ztSourceInfoMapper;

    /**
     * @Author jirg
     * @Date 2019/12/5 16:55
     * @Description 国内/国外货源各列表查询
     **/
    public ResultPoJo<HeadquartersSupplyVo> findSupplyList(HeadquartersSupplyPo po) {
        ResultPoJo<HeadquartersSupplyVo> result = new ResultPoJo<>();
        HeadquartersSupplyVo vo = new HeadquartersSupplyVo();
        Page page = new Page();
        page.setPageNo(1);
        page.setPageSize(20);
        //查询在途货源列表
        LockSourceInfoPagePo lockSourceInfoPagePo = new LockSourceInfoPagePo();
        lockSourceInfoPagePo.setPage(page);
        lockSourceInfoPagePo.setSourceType(po.getSourceType());
        List<LockSourceInfoListVo> lockSourceInfoVos = lockSourceInfoMapper.findPage(lockSourceInfoPagePo);
        vo.setLockSourceInfoVos(lockSourceInfoVos);
        //查询在途货源列表
        RkSourceInfoPagePo rkSourceInfoPagePo = new RkSourceInfoPagePo();
        rkSourceInfoPagePo.setPage(page);
        rkSourceInfoPagePo.setSourceType(po.getSourceType());
        List<RkSourceInfoListVo> rkSourceInfoVos = rkSourceInfoMapper.findPage(rkSourceInfoPagePo);
        vo.setRkSourceInfoVos(rkSourceInfoVos);
        //查询在途货源列表
        ZtSourceInfoPagePo ztSourceInfoPagePo = new ZtSourceInfoPagePo();
        ztSourceInfoPagePo.setPage(page);
        ztSourceInfoPagePo.setSourceType(po.getSourceType());
        List<ZtSourceInfoListVo> ztSourceInfoVos = ztSourceInfoMapper.findPage(ztSourceInfoPagePo);
        vo.setZtSourceInfoVos(ztSourceInfoVos);
        result.setResult(vo);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/6 11:21
     * @Description 国内/国外单品交易排行列表
     **/
    public ResultPoJo<List<HeadquartersTransactionRankingVo>> transactionRanking(HeadquartersTransactionRankingPo po) {
        ResultPoJo<List<HeadquartersTransactionRankingVo>> result = new ResultPoJo<>();
        List<HeadquartersTransactionRankingVo> vo = jyOrdMageMapper.transactionRanking(po);
        result.setResult(vo);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/6 14:36
     * @Description 国内/国外品类交易走势分析
     **/
    public ResultPoJo<List<HeadquartersCategoryTransactionTrendsVo>> categoryTransactionTrends(HeadquartersCategoryTransactionTrendsPo po) {
        ResultPoJo<List<HeadquartersCategoryTransactionTrendsVo>> result = new ResultPoJo<>();
        /*if(po.getShowType().equals("1")){
            //按月展示，展示最近12个月的数据
            OffsetDateTime startQueryDate = OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().withDayOfMonth(1));
            po.setStartQueryDate(startQueryDate);
        }*/
        List<HeadquartersCategoryTransactionTrendsVo> vo = jyOrdMageMapper.categoryTransactionTrends(po);
        /*OffsetDateTime startQueryDate = po.getStartQueryDate();
        if(ConverterUtil.isNotEmpty(startQueryDate)){
            List<HeadquartersCategoryTransactionTrendsVo> list = Lists.newArrayList();
            Map<String, HeadquartersCategoryTransactionTrendsVo> collect = vo.stream().collect(Collectors.toMap(HeadquartersCategoryTransactionTrendsVo::getYearOrMonth, Function.identity()));
            do {
                String ymStr = startQueryDate.format(DateTimeFormatter.ofPattern("yy-MM"));
                if(collect.containsKey(ymStr)){
                    list.add(collect.get(ymStr));
                }else{
                    HeadquartersCategoryTransactionTrendsVo trendsVo = new HeadquartersCategoryTransactionTrendsVo();
                    trendsVo.setSalesAmount(0.0);
                    trendsVo.setSalesCount(0.0);
                    trendsVo.setYearOrMonth(ymStr);
                    list.add(trendsVo);
                }
            }while ((startQueryDate = startQueryDate.plusMonths(1)).isBefore(OffsetDateTime.now()));
            vo = list;
        }*/
        result.setResult(vo);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2019/12/9 16:30
     * @Description 国内外销售总额统计
     **/
    public ResultPoJo<TotalSalesVo> totalSales(TotalSalesPo po) {
        ResultPoJo<TotalSalesVo> result = new ResultPoJo<>();
        TotalSalesVo vo = new TotalSalesVo();

        TotalOrderSalesVo totalOrderSales = CacheUtil.getTotalOrderSales(po.getYear());

        Double domesticTotalOrderSales = ConverterUtil.isNotEmpty(totalOrderSales) ? totalOrderSales.getDomesticTotalOrderSales() : 0.0;//国内订单销售总额
        Double foreignTotalOrderSales = ConverterUtil.isNotEmpty(totalOrderSales) ? totalOrderSales.getForeignTotalOrderSales() : 0.0;//国外订单销售总额

        Double domesticTransactionsIncreasingTotal = CacheUtil.getDomesticTransactionsIncreasingTotal();//国内交易已递增金额
        Double foreignTransactionsIncreasingTotal = CacheUtil.getForeignTransactionsIncreasingTotal();//国外交易已递增金额

        vo.setDomesticTotalSales(ConverterUtil.getRoundValue(ConverterUtil.add(domesticTotalOrderSales, ConverterUtil.isEmpty(domesticTransactionsIncreasingTotal) ? 0 : domesticTransactionsIncreasingTotal), 2));
        vo.setForeignTotalSales(ConverterUtil.getRoundValue(ConverterUtil.add(foreignTotalOrderSales, ConverterUtil.isEmpty(foreignTransactionsIncreasingTotal) ? 0 : foreignTransactionsIncreasingTotal), 2));
        vo.setTotalSales(ConverterUtil.getRoundValue(ConverterUtil.add(vo.getDomesticTotalSales(), vo.getForeignTotalSales()), 2));
        vo.setYear(po.getYear());

        result.setResult(vo);
        return result;
    }

    /**
     * @Author jirg
     * @Date 2020/2/5 10:45
     * @Description 获取订单年份列表
     **/
    public ResultPoJo<List<String>> getOrdYears() {
        ResultPoJo<List<String>> result = new ResultPoJo<>();
        List<String> years = jyOrdMageMapper.getOrdYears();
        result.setResult(years);
        return result;

    }
}
