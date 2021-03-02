package com.wisea.cultivar.bigdata.service;

import java.time.OffsetDateTime;
import java.util.*;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.wisea.cultivar.common.dao.bigdata.OrdCommRelaTbMapper;
import com.wisea.cultivar.common.dao.bigdata.OrderInfoTbMapper;
import com.wisea.cultivar.common.vo.bigdata.*;
import com.wisea.cultivar.common.dao.CommVarietMageMapper;
import com.wisea.cultivar.common.vo.product.CommVarietMageListVo;
import com.wisea.cultivar.common.vo.tp.OrderInfoListVo;
import com.wisea.cultivar.common.vo.tp.trade.OrderInfoVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cultivar.common.dao.tp.OrderInfoMapper;
import com.wisea.cultivar.common.po.tp.StaticOrderPo;
import com.wisea.cultivar.common.vo.tp.statistics.ChartVo;
import com.wisea.cultivar.common.vo.tp.statistics.TransactionDataChartVo;

import static com.wisea.cultivar.common.vo.bigdata.EchartsMapDataVo.getDetail;
import static com.wisea.cultivar.common.vo.bigdata.EchartsMapDataVo.getNode;
import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 *
 * 采购商名录管理 Service
 * 2019/12/02 11:02:14
 */
@Service
public class TransDataService extends BaseService {
    @Autowired
    protected OrderInfoMapper mapper;

    @Autowired
    protected OrderInfoTbMapper orderInfoTbMapper;

    @Autowired
    protected OrdCommRelaTbMapper ordCommRelaTbMapper;

    @Autowired
    private CommVarietMageMapper commVarietMageMapper;

    /**
     * 查询分页列表
     */
    public ResultPoJo<Map<String, List<TransactionDataChartVo>>> ordTransData() {

        ResultPoJo<Map<String, List<TransactionDataChartVo>>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //构造list用于返回两个图标
        Map<String, List<TransactionDataChartVo>> returnMap = Maps.newHashMap();
        /**  查询近30天  **/
        StaticOrderPo moth = new StaticOrderPo();
        moth.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusDays(-29)));
        moth.setEndDate(OffsetDateTime.now());
        moth.setPlat("%Y-%m-%d");
        //查询图表
        List<TransactionDataChartVo> mouthChartVo = orderInfoTbMapper.transMouthChartVo(moth);
        //构造30天
        List<String> daysYmd = Lists.newArrayList();
        daysYmd = OffsetDateTimeUtils.getStartAndEndYmd(moth.getStartDate(), moth.getEndDate());

        returnMap.put("0", chartVoPlant(mouthChartVo, daysYmd));
        /***  查询近12月得交易  ***/
        StaticOrderPo yearPo = new StaticOrderPo();
        yearPo.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusYears(-1).plusMonths(1)));
        yearPo.setEndDate(OffsetDateTime.now());
        yearPo.setPlat("%Y-%m");
        //查询图表
        List<TransactionDataChartVo> yearChartVo = orderInfoTbMapper.transMouthChartVo(yearPo);
        //构造12月
        List<String>  mothny = Lists.newArrayList();
        mothny = OffsetDateTimeUtils.getStartAndEndYm(yearPo.getStartDate(), yearPo.getEndDate());

        returnMap.put("1", chartVoPlant(yearChartVo, mothny));
        resultPoJo.setResult(returnMap);
        return resultPoJo;
    }

    /**
     * 查询销售排行
     */
    public ResultPoJo<Map<String,List<ChartVo>>> salePlant () {

        ResultPoJo<Map<String,List<ChartVo>>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        StaticOrderPo salePo = new StaticOrderPo();
        salePo.setStartDate(OffsetDateTimeUtils.getDayMinTime(OffsetDateTime.now().plusMonths(-5)));
        salePo.setEndDate(OffsetDateTime.now());
        salePo.setPlat("%Y-%m");
        //查询图表
        List<TransactionDataChartVo> vo = orderInfoTbMapper.transSaleCatgData(salePo);
        //构造6月
        List<String>  saleny = Lists.newArrayList();
        saleny = OffsetDateTimeUtils.getStartAndEndYm(salePo.getStartDate(), salePo.getEndDate());

        List<ChartVo> chartVos = Lists.newArrayList();
        Map<String,List<ChartVo>> ml = Maps.newHashMap();
        for (TransactionDataChartVo e :vo) {
            if (ml.containsKey(e.getSaleCatg())) {
                List<ChartVo> chartVo = ml.get(e.getSaleCatg());
                for (ChartVo str :chartVo) {
                    if (e.getxPoint().equals(str.getxPoint())) {
                        str.setyValue(e.getTotalPayAmount());
                    }
                }
            }else {
                List<ChartVo> chartVo = Lists.newArrayList();
                for (String str :saleny) {
                    ChartVo cc = new ChartVo();
                    cc.setxPoint(str);
                    if (e.getxPoint().equals(str)) {
                        cc.setyValue(e.getTotalPayAmount());
                    }else {
                        cc.setyValue(0);
                    }
                    chartVo.add(cc);
                    ml.put(e.getSaleCatg(),chartVo);
                }
            }
        }
        resultPoJo.setResult(ml);
        return resultPoJo;
    }

    public List<TransactionDataChartVo> chartVoPlant (List<TransactionDataChartVo> vo, List<String> ymd) {
        Map<String, TransactionDataChartVo> resultMap = Maps.newHashMap();
        if (vo != null && vo.size() > 0) {
            resultMap = vo.stream().collect(Collectors.toMap(TransactionDataChartVo::getxPoint, Function.identity()));
        }
        List<TransactionDataChartVo> chartVos = Lists.newArrayList();
        for (String e : ymd) {
            if (resultMap.containsKey(e)) {
                chartVos.add(resultMap.get(e));
            } else {
                TransactionDataChartVo chartVo = new TransactionDataChartVo();
                chartVo.setxPoint(e);
                chartVo.setPayBuyerCount(0);
                chartVo.setPayOrdCommRelaCount(0);
                chartVo.setTotalPayAmount(0D);
                chartVo.setTotalRefund(0D);
                chartVos.add(chartVo);
            }
        }
        return chartVos;
    }

    /**
     * 采购等级、品牌、规格、价格、供应商排名占比
     * @return
     */
    public ResultPoJo<Map<String,List<ChartVo>>> transLevelData () {
        ResultPoJo<Map<String,List<ChartVo>>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        Map<String,List<ChartVo>> vo = Maps.newHashMap();
        //热销品类榜单
        List<ChartVo> transSpecData = orderInfoTbMapper.transCategoryData();
        //查询品牌
        List<ChartVo> transBrandData = orderInfoTbMapper.transBrandData();
        //查询价格占比
        List<ChartVo> transAmountData = orderInfoTbMapper.transOrdAmount();
        //查询供应商热销排行
        List<ChartVo> transSerllerPm = orderInfoTbMapper.transSerllerPm();
        vo.put("1", transBrandData);
        vo.put("2", transSpecData);
        vo.put("3", transAmountData);
        vo.put("4", transSerllerPm);
        resultPoJo.setResult(vo);
        return resultPoJo;
    }
    /**
     * 全球销量、全球销售总金额、热卖品种
     * @return
     */
    public ResultPoJo<HeadNumAndSearchVo> headNumAndSearch() {
        ResultPoJo<HeadNumAndSearchVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        HeadNumAndSearchVo vo = new HeadNumAndSearchVo();
        //查询订单的总金额和数量
        List<OrderNumVo> orderNumVos = orderInfoTbMapper.orderCountSum();
        if (orderNumVos.size() < 2) {
            List num = new ArrayList();
            for (OrderNumVo orderNumVo : orderNumVos) {
                num.add(orderNumVo.getSource());
            }

            if (!num.contains("果品交易平台")) {
                orderNumVos.add(new OrderNumVo(0, 0l, "果品交易平台"));
            }
            if(!num.contains("天猫平台")) {
                orderNumVos.add(new OrderNumVo(0, 0l, "天猫平台"));
            }


        }
        vo.setOrderNumVos(orderNumVos);
        //查询热卖品种
        List<String> commVarietMageListVos = ordCommRelaTbMapper.findSearchName();
        vo.setCommVarietMageListVos(commVarietMageListVos);
        //获取总订单数据量总订单金额
        vo.setOrderCounts(orderNumVos.stream().collect(Collectors.summingInt(OrderNumVo::getOrderCount)));
        vo.setOrderAmouns(orderNumVos.stream().collect(Collectors.summingLong(OrderNumVo::getOrderAmoun)));

        resultPoJo.setResult(vo);
        return resultPoJo;
    }

    private List<ChartVo> getDays(StaticOrderPo moth, List<ChartVo> chartVoList) {
        //构造30天
        List<String> daysYmd = Lists.newArrayList();
        daysYmd = OffsetDateTimeUtils.getStartAndEndYmd(moth.getStartDate(), moth.getEndDate());
        Map<String, ChartVo> resultMap = chartVoList.stream().collect(Collectors.toMap(ChartVo::getxPoint, Function.identity()));
        List<ChartVo> chartVos = Lists.newArrayList();
        daysYmd.forEach(e -> {
            if (resultMap.containsKey(e)){
                chartVos.add(resultMap.get(e));
            }else{
                ChartVo chartVo = new ChartVo();
                chartVo.setxPoint(e);
                chartVo.setyValue(0);
                chartVos.add(chartVo);
            }
        });
        return chartVos;
    }


    /**
     * 全国热销城市占比分析
     * @return
     */
    public ResultPoJo<List<ChartVo>> transRxCityData () {
        ResultPoJo<List<ChartVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        //查询热销城市
        List<ChartVo> cityList = orderInfoTbMapper.transRxCityData();
        //计算总和
        double sum = 0;
        for (ChartVo chac : cityList) {
            sum += (double)chac.getyValue();
        }
        //计算百分比
        for (ChartVo e : cityList) {
            e.setyValue(ConverterUtil.div((double)e.getyValue()*100, sum, 2));
        }
        resultPoJo.setResult(cityList);
        return resultPoJo;
    }

    /**
     * 封装交易地图数据
     *
     * @return EchartsMapDataVo
     */
    public ResultPoJo<List<TransMapVo>> findMapData() {
        ResultPoJo<List<TransMapVo>> result = new ResultPoJo<>();
//        EchartsMapDataVo vo = new EchartsMapDataVo();
        //获取所需数据
        List<TransMapVo> list = mapper.findMapList();
        if (list.size() == 0) {
            return new ResultPoJo<>();
        }

//        Supplier<Stream<TransMapVo>> supplier = list::stream;
//
////        //聚合所有起点相同的数据
//        Map<String, List<TransMapVo>> groupByQd = supplier.get().collect(groupingBy(TransMapVo::getQd));
//        Set<String> qdName = groupByQd.keySet();
//        List<List<Object>> dataArr = new ArrayList<>();
//        for (String qd : qdName) {
//            List<TransMapVo> datas = groupByQd.get(qd);
//            dataArr.add(getNode(qd,
//                    datas.stream().map(i -> getDetail(new EchartsMapDataVo.Place(qd),//起点
//                            new EchartsMapDataVo.Place(i.getZd()),//终点
//                            new EchartsMapDataVo.OrderInfo(i.getOrdNum(), i.getOrdDate(), i.getSendCommDate(),i.getReceName(),i.getUserName(),i.getCommTotalPrice())))//订单详情
//                            .collect(toList())));
//        }
//        vo.setDataArr(dataArr);
        result.setResult(list);

        return result;

    }

    /**
     * 交收方式分析
     * @return
     */
    public ResultPoJo<List<OrderSettlement>> modeSettlement() {
        ResultPoJo<List<OrderSettlement>> result = new ResultPoJo<>();
        List<OrderSettlement> mode = orderInfoTbMapper.modeSettlement();
        if (mode.size() == 0) {
            return new ResultPoJo<>();
        }
        result.setResult(mode);
        return result;
    }
}
