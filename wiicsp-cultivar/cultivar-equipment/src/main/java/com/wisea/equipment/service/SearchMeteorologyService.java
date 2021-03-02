package com.wisea.equipment.service;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cloud.common.service.BaseService;
import com.wisea.cloud.common.util.ConverterUtil;
import com.wisea.cloud.common.util.HttpClientUtil;
import com.wisea.cloud.common.util.LoggerUtil;
import com.wisea.cloud.common.util.OffsetDateTimeUtils;
import com.wisea.cloud.influxdb.config.InfluxDBClient;
import com.wisea.cloud.model.po.LongIdPo;
import com.wisea.equipment.constants.ConstantCodeMsg;
import com.wisea.equipment.constants.InfluxDBTableEnum;
import com.wisea.equipment.dao.EquInfoMapper;
import com.wisea.equipment.entity.EquInfo;
import com.wisea.equipment.po.EquDataPointPo;
import com.wisea.equipment.vo.MeteorologyInfluxVo;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author jirg
 * @version 1.0
 * @className SearchService
 * @date 2020/7/13 17:45
 * @Description
 */
@Service
public class SearchMeteorologyService extends BaseService {
    @Autowired
    private EquInfoMapper equInfoMapper;
    @Autowired
    private InfluxDBClient influxDBClient;
    /**
     * @author jirg
     * @date 2020/7/9 14:18
     * @Description 获取设备最近一条数据点
     */
    public ResultPoJo<MeteorologyInfluxVo> getLastDataPoint(EquDataPointPo po) {
        LoggerUtil.infoWithContext("【getLastDataPoint】获取设备最近一条数据点：", po);
        ResultPoJo<MeteorologyInfluxVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        //查询设备是否存在
        EquInfo equInfo = equInfoMapper.findByEntpIdAndNum(po.getEquEntpId(), po.getEquNum());

        if(ConverterUtil.isNotEmpty(equInfo)){
            //搜索，只查询第一条数据
            String sql = "select * from "+ InfluxDBTableEnum.METEOROLOGY_TABLE.table() +" where equId = '" + equInfo.getId() + "' order by time desc limit 1";
            List<MeteorologyInfluxVo> points = influxDBClient.query(sql, MeteorologyInfluxVo.class);
            if(ConverterUtil.isNotEmpty(points)){
                MeteorologyInfluxVo meteorologyInfluxVo = points.get(0);
                meteorologyInfluxVo.setEquEntpId(equInfo.getEquEntpId());
                meteorologyInfluxVo.setEquModelId(equInfo.getEquModelId());
                meteorologyInfluxVo.setEquNum(equInfo.getEquNum());
                resultPoJo.setResult(meteorologyInfluxVo);
            }
            return resultPoJo;
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_302);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_302);
        }
        return resultPoJo;
    }

    /**
     * 调用糯米蕉设备数据
     * @param po
     * @return
     */
    public ResultPoJo<MeteorologyInfluxVo> getLastDataPointTmp(LongIdPo po) {
        LoggerUtil.infoWithContext("【getLastDataPoint】调用糯米蕉设备数据：", po);
        ResultPoJo<MeteorologyInfluxVo> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        String address = "http://119.253.63.20/ori/n/dashboard/findEquInfoMonitorInfo";
        String httpResult = HttpClientUtil.sendPost(address, po);
        //请求成功
        try {
            JSONObject jsonObject = new JSONObject(httpResult);
            String code = jsonObject.getString("code");
            if(ConstantError.NOMAL.equals(code)){
                JSONObject result = jsonObject.getJSONObject("result");
                JSONObject latestDate = result.getJSONObject("latestDate");
                MeteorologyInfluxVo vo = new MeteorologyInfluxVo();
                vo.setId(latestDate.optLong("id"));
                vo.setEquId(latestDate.optLong("equId"));
                vo.setTemperature(latestDate.optDouble("temperature", 0));
                vo.setHumidity(latestDate.optDouble("humidity", 0));
                vo.setPressure(latestDate.optDouble("atmPress", 0));
                vo.setIllumination(latestDate.optDouble("intenIllum", 0));
                vo.setRainfall(latestDate.optDouble("rainfall", 0));
                vo.setWind_speed(latestDate.optDouble("flFx", 0));
                vo.setWindDirectionStr(latestDate.optString("fx"));
                vo.setSoilTemper(latestDate.optDouble("soilTemper", 0));
                vo.setSoilMois(latestDate.optDouble("soilMois", 0));
                resultPoJo.setResult(vo);
            }else{
                resultPoJo.setCode(code);
                resultPoJo.setMsg(jsonObject.getString("msg"));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/8/12 18:00
     * @Description 获取设备图片列表
     */
    public ResultPoJo<List<MeteorologyInfluxVo>> getGrowAlbum(EquDataPointPo po) {
        LoggerUtil.infoWithContext("【getGrowAlbum】获取设备图片列表：", po);
        ResultPoJo<List<MeteorologyInfluxVo>> resultPoJo = new ResultPoJo<>(ConstantError.NOMAL);

        //查询设备是否存在
        EquInfo equInfo = equInfoMapper.findByEntpIdAndNum(po.getEquEntpId(), po.getEquNum());

        if(ConverterUtil.isNotEmpty(equInfo)){
            if (ConverterUtil.isEmpty(po.getStartDate())) {
                //默认最近七天图片
                OffsetDateTime now = OffsetDateTime.now();
                po.setEndDate(OffsetDateTimeUtils.getDayMaxTime(now));
                po.setStartDate(OffsetDateTimeUtils.getDayMinTime(now.minusDays(6)));
            }

            String startDateStr = po.getStartDate().withNano(0).format(DateTimeFormatter.ISO_INSTANT);
            String endDateStr =  po.getEndDate().format(DateTimeFormatter.ISO_INSTANT);

            String sql = "select * from "+ InfluxDBTableEnum.METEOROLOGY_TABLE.table() +" where equId = '" + equInfo.getId() + "' and equDateType = '2' and time >= '"+ startDateStr +"' and time<= '"+ endDateStr +"' order by time desc";

            List<MeteorologyInfluxVo> points = influxDBClient.query(sql, MeteorologyInfluxVo.class);
            points.forEach(e->{
                e.setEquEntpId(equInfo.getEquEntpId());
                e.setEquModelId(equInfo.getEquModelId());
                e.setEquNum(equInfo.getEquNum());
            });
            resultPoJo.setResult(points);
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_302);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_302);
        }
        return resultPoJo;
    }

    /**
     * @author jirg
     * @date 2020/7/9 16:59
     * @Description 设备按 天、周、月统计
     */
    public ResultPoJo<List<MeteorologyInfluxVo>> datePointStatistics(EquDataPointPo po) {
        ResultPoJo<List<MeteorologyInfluxVo>> resultPoJo = new ResultPoJo<>(ConstantCodeMsg.NOMAL);

        //数据校验
        Assert.notNull(po.getStatisticsFlag(), "Parameter [statisticsFlag] must not be null.");

        //查询设备是否存在
        EquInfo equInfo = equInfoMapper.findByEntpIdAndNum(po.getEquEntpId(), po.getEquNum());
        if(ConverterUtil.isNotEmpty(equInfo)){
            //计算查询开始和结束时间
            OffsetDateTime now = OffsetDateTime.now();
            OffsetDateTime startDate = OffsetDateTimeUtils.getDayMinTime(now);
            OffsetDateTime endDate = OffsetDateTimeUtils.getDayMaxTime(now);
            if (!"0".equals(po.getStatisticsFlag())) {
                endDate = OffsetDateTimeUtils.getDayMaxTime(now);
                if (po.getStatisticsFlag().equals("1")) {
                    //最近7天
                    startDate = OffsetDateTimeUtils.getDayMinTime(now.minusDays(6));
                } else if (po.getStatisticsFlag().equals("2")) {
                    //最近30天
                    startDate = OffsetDateTimeUtils.getDayMinTime(now.minusDays(29));
                }
            }

            String startDateStr = startDate.withNano(0).format(DateTimeFormatter.ISO_INSTANT);
            String endDateStr = endDate.format(DateTimeFormatter.ISO_INSTANT);

            String sql = "select * from "+ InfluxDBTableEnum.METEOROLOGY_TABLE.table() +" where equId = '" + equInfo.getId() + "' and time >= '"+ startDateStr +"' and time<= '"+ endDateStr +"' order by time desc";

            //搜索
            List<MeteorologyInfluxVo> dataPoints = influxDBClient.query(sql, MeteorologyInfluxVo.class);
            dataPoints.forEach(e->{
                e.setEquEntpId(equInfo.getEquEntpId());
                e.setEquModelId(equInfo.getEquModelId());
                e.setEquNum(equInfo.getEquNum());
            });

            //数据封装
            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH");
            DateTimeFormatter dayFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            DateTimeFormatter monthFormatter = DateTimeFormatter.ofPattern("yyyy-MM");
            //温度Map
            Map<String, List<Double>> temperatureMap = Maps.newLinkedHashMap();
            //湿度Map
            Map<String, List<Double>> humidityMap = Maps.newLinkedHashMap();
            //气压Map
            Map<String, List<Double>> atmPressMap = Maps.newLinkedHashMap();
            //光强Map
            Map<String, List<Double>> intenIllumMap = Maps.newLinkedHashMap();

            //返回结果
            List<MeteorologyInfluxVo> list = Lists.newArrayList();

            if ("0".equals(po.getStatisticsFlag())) {
                Map<String, List<MeteorologyInfluxVo>> collect = dataPoints.stream().collect(Collectors.groupingBy(e -> e.getTime().format(timeFormatter)));
                collect.forEach((k, v) -> {
                    temperatureMap.put(k, v.stream().filter(e -> ConverterUtil.isNotEmpty(e.getTemperature())).map(MeteorologyInfluxVo::getTemperature).collect(Collectors.toList()));
                    humidityMap.put(k, v.stream().filter(e -> ConverterUtil.isNotEmpty(e.getHumidity())).map(MeteorologyInfluxVo::getHumidity).collect(Collectors.toList()));
                    atmPressMap.put(k, v.stream().filter(e -> ConverterUtil.isNotEmpty(e.getPressure())).map(MeteorologyInfluxVo::getPressure).collect(Collectors.toList()));
                    intenIllumMap.put(k, v.stream().filter(e -> ConverterUtil.isNotEmpty(e.getIllumination())).map(MeteorologyInfluxVo::getIllumination).collect(Collectors.toList()));
                });
                list = dayAverage(temperatureMap, humidityMap, atmPressMap, intenIllumMap);
                resultPoJo.setResult(list);
            } else {
                //温度Map(月)
                Map<String, Map<String, List<Double>>> temperatureMonthMap = Maps.newLinkedHashMap();
                //湿度Map(月)
                Map<String, Map<String, List<Double>>> humidityMonthMap = Maps.newLinkedHashMap();
                //气压Map(月)
                Map<String, Map<String, List<Double>>> atmPressMonthMap = Maps.newLinkedHashMap();
                //光强Map(月)
                Map<String, Map<String, List<Double>>> intenIllumMonthMap = Maps.newLinkedHashMap();

                dataPoints.forEach(e -> {
                    String timeFormat = e.getTime().format(timeFormatter);
                    //if (timeFormat.equals("02") || timeFormat.equals("08") || timeFormat.equals("14") || timeFormat.equals("20")) {
                        //温度-天
                        List<Double> temperatureList = temperatureMap.get(e.getTime().format(dayFormatter));
                        if (ConverterUtil.isEmpty(temperatureList)) {
                            temperatureList = Lists.newArrayList();
                            temperatureMap.put(e.getTime().format(dayFormatter), temperatureList);
                        }
                        if(ConverterUtil.isNotEmpty(e.getTemperature())){
                            temperatureList.add(e.getTemperature());
                        }
                        //温度-月
                        temperatureMonthMap.put(e.getTime().format(monthFormatter), temperatureMap.entrySet().stream().filter((es) -> es.getKey().startsWith(e.getTime().format(monthFormatter))).collect(Collectors.toMap((es) -> es.getKey(), (es) -> es.getValue())));

                        //湿度-天
                        List<Double> humidityList = humidityMap.get(e.getTime().format(dayFormatter));
                        if (ConverterUtil.isEmpty(humidityList)) {
                            humidityList = Lists.newArrayList();
                            humidityMap.put(e.getTime().format(dayFormatter), humidityList);
                        }
                        if(ConverterUtil.isNotEmpty(e.getHumidity())){
                            humidityList.add(e.getHumidity());
                        }
                        //湿度-月
                        humidityMonthMap.put(e.getTime().format(monthFormatter), humidityMap.entrySet().stream().filter((es) -> es.getKey().startsWith(e.getTime().format(monthFormatter))).collect(Collectors.toMap((es) -> es.getKey(), (es) -> es.getValue())));
                    //}

                    //气压-天
                    List<Double> atmPressList = atmPressMap.get(e.getTime().format(dayFormatter));
                    if (ConverterUtil.isEmpty(atmPressList)) {
                        atmPressList = Lists.newArrayList();
                        atmPressMap.put(e.getTime().format(dayFormatter), atmPressList);
                    }
                    if(ConverterUtil.isNotEmpty(e.getPressure())){
                        atmPressList.add(e.getPressure());
                    }
                    //气压-月
                    atmPressMonthMap.put(e.getTime().format(monthFormatter), atmPressMap.entrySet().stream().filter((es) -> es.getKey().startsWith(e.getTime().format(monthFormatter))).collect(Collectors.toMap((es) -> es.getKey(), (es) -> es.getValue())));

                    //光强-天
                    List<Double> intenIllumList = intenIllumMap.get(e.getTime().format(dayFormatter));
                    if (ConverterUtil.isEmpty(intenIllumList)) {
                        intenIllumList = Lists.newArrayList();
                        intenIllumMap.put(e.getTime().format(dayFormatter), intenIllumList);
                    }
                    if(ConverterUtil.isNotEmpty(e.getIllumination())){
                        intenIllumList.add(e.getIllumination());
                    }
                    //光强-月
                    intenIllumMonthMap.put(e.getTime().format(monthFormatter), intenIllumMap.entrySet().stream().filter((es) -> es.getKey().startsWith(e.getTime().format(monthFormatter))).collect(Collectors.toMap((es) -> es.getKey(), (es) -> es.getValue())));
                });

                //结果封装
                if (po.getStatisticsFlag().equals("1") || po.getStatisticsFlag().equals("2")) {
                    // 以天为单位计算平均值
                    list = dayAverage(temperatureMap, humidityMap, atmPressMap, intenIllumMap);
                } else {
                    // 以月为单位计算平均值
                    Set<String> set = atmPressMonthMap.keySet();
                    List<MeteorologyInfluxVo> finalList = list;
                    set.forEach(e -> {
                        MeteorologyInfluxVo dataPoint = new MeteorologyInfluxVo();
                        Map<String, List<Double>> temperatureDayMap = ConverterUtil.isNotEmpty(temperatureMonthMap.get(e)) ? temperatureMonthMap.get(e) : Maps.newHashMap();
                        Map<String, List<Double>> humidityDayMap = ConverterUtil.isNotEmpty(humidityMonthMap.get(e)) ? humidityMonthMap.get(e) : Maps.newHashMap();
                        Map<String, List<Double>> atmPressDayhMap = ConverterUtil.isNotEmpty(atmPressMonthMap.get(e)) ? atmPressMonthMap.get(e) : Maps.newHashMap();
                        Map<String, List<Double>> intenIllumDayMap = ConverterUtil.isNotEmpty(intenIllumMonthMap.get(e)) ? intenIllumMonthMap.get(e) : Maps.newHashMap();
                        List<MeteorologyInfluxVo> dayAverageDataPoint = dayAverage(temperatureDayMap, humidityDayMap, atmPressDayhMap, intenIllumDayMap);
                        if(dayAverageDataPoint.size() > 0){
                            //每月-温度
                            dataPoint.setTemperature(ConverterUtil.div(dayAverageDataPoint.stream().mapToDouble(MeteorologyInfluxVo::getTemperature).sum(), dayAverageDataPoint.size(), 2));
                            //每月-湿度
                            dataPoint.setHumidity(ConverterUtil.div(dayAverageDataPoint.stream().mapToDouble(MeteorologyInfluxVo::getHumidity).sum(), dayAverageDataPoint.size(), 4));
                            //每月-气压
                            dataPoint.setPressure(ConverterUtil.div(dayAverageDataPoint.stream().mapToDouble(MeteorologyInfluxVo::getPressure).sum(), dayAverageDataPoint.size(), 2));
                            //每月-光强
                            dataPoint.setIllumination(ConverterUtil.div(dayAverageDataPoint.stream().mapToDouble(MeteorologyInfluxVo::getIllumination).sum(), dayAverageDataPoint.size(), 0));
                            dataPoint.setXaxis(e);
                            finalList.add(dataPoint);
                        }
                    });
                }
                resultPoJo.setResult(list);
            }
        }else{
            resultPoJo.setCode(ConstantCodeMsg.ERR_302);
            resultPoJo.setMsg(ConstantCodeMsg.MSG_302);
        }
        return resultPoJo;
    }

    /**
     * @Author jirg
     * @Date 2019/3/1 10:37
     * @Description 计算每天个指标的平均值
     **/
    public List<MeteorologyInfluxVo> dayAverage(Map<String, List<Double>> temperatureMap, Map<String, List<Double>> humidityMap, Map<String, List<Double>> atmPressMap, Map<String, List<Double>> intenIllumMap) {
        List<MeteorologyInfluxVo> list = Lists.newArrayList();
        List<Double> tempList = Lists.newArrayList();
        Set<String> set = temperatureMap.keySet();
        set.forEach(e -> {
            MeteorologyInfluxVo dataPoint = new MeteorologyInfluxVo();
            //温度
            double temperature = 0D;
            if (ConverterUtil.isNotEmpty(temperatureMap.get(e)) && temperatureMap.get(e).size() > 0) {
                temperature = ConverterUtil.div(temperatureMap.get(e).stream().mapToDouble(Double::doubleValue).sum(), temperatureMap.get(e).size(), 2);
            }
            dataPoint.setTemperature(temperature);

            //湿度
            double humidity = 0D;
            if (ConverterUtil.isNotEmpty(humidityMap.get(e)) && humidityMap.get(e).size() > 0) {
                humidity = ConverterUtil.div(humidityMap.get(e).stream().mapToDouble(Double::doubleValue).sum(), humidityMap.get(e).size(), 4);
            }
            dataPoint.setHumidity(humidity);

            //气压
            Double atmPress = 0D;
            List<Double> atmPressList = atmPressMap.get(e);
            if (ConverterUtil.isNotEmpty(atmPressList) && atmPressList.size() > 0) {
                Collections.sort(atmPressList);
                if (atmPressList.size() <= 4) {
                    atmPress = ConverterUtil.div(atmPressList.stream().mapToDouble(Double::doubleValue).sum(), atmPressList.size(), 2);
                } else {
                    tempList.clear();
                    tempList.add(atmPressList.get(0));
                    tempList.add(atmPressList.get(1));
                    tempList.add(atmPressList.get(atmPressList.size() - 1));
                    tempList.add(atmPressList.get(atmPressList.size() - 2));
                    atmPress = ConverterUtil.div(tempList.stream().mapToDouble(Double::doubleValue).sum(), 4, 2);
                }
            }
            dataPoint.setPressure(atmPress);

            //光强
            Double intenIllum = 0D;
            List<Double> intenIllumList = intenIllumMap.get(e);
            if (ConverterUtil.isNotEmpty(intenIllumList) && intenIllumList.size() > 0) {
                Collections.sort(intenIllumList);
                if (intenIllumList.size() <= 8) {
                    intenIllum = ConverterUtil.div(intenIllumList.stream().mapToDouble(Double::doubleValue).sum(), intenIllumList.size(), 0);
                } else {
                    tempList.clear();
                    tempList.add(intenIllumList.get(intenIllumList.size() - 1));
                    tempList.add(intenIllumList.get(intenIllumList.size() - 2));
                    tempList.add(intenIllumList.get(intenIllumList.size() - 3));
                    tempList.add(intenIllumList.get(intenIllumList.size() - 4));
                    tempList.add(intenIllumList.get(intenIllumList.size() - 5));
                    tempList.add(intenIllumList.get(intenIllumList.size() - 6));
                    tempList.add(intenIllumList.get(intenIllumList.size() - 7));
                    tempList.add(intenIllumList.get(intenIllumList.size() - 8));
                    intenIllum = ConverterUtil.div(tempList.stream().mapToDouble(Double::doubleValue).sum(), 8, 0);
                }
            }
            dataPoint.setIllumination(intenIllum);
            dataPoint.setXaxis(e);
            list.add(dataPoint);
        });
        return list;
    }
}
