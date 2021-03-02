package com.wisea.cultivar.plant.controller;

import com.wisea.cloud.common.constants.ConstantError;
import com.wisea.cloud.common.pojo.ResultPoJo;
import com.wisea.cultivar.common.entity.tp.TimeGenPo;
import com.wisea.cultivar.plant.po.TimePo;
import com.wisea.cultivar.plant.utils.OffsetDateTimeUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.util.*;
import java.util.stream.Collectors;

/**
 * @Auther: Administrator
 * @Date: 2020/8/31 16:16
 * @Description:
 */
@RestController
@Api(tags = "三级时间")
@RequestMapping("/w/Time")
public class TimeController {



    @RequestMapping(value = "/findTime", method = RequestMethod.POST)
    @ApiOperation(nickname = "查看一个年内的时间", value = "查看一个年内的时间", notes = "查看一个年内的时间", httpMethod = "POST")
    public static ResultPoJo  findTime() {

        ResultPoJo<Object> objectResultPoJo = new ResultPoJo<>(ConstantError.NOMAL);
        objectResultPoJo.setResult(findDates());
        return objectResultPoJo;
    }








    public static ArrayList<TimePo> findDates()
    {

        Calendar calBegin = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calBegin.setTime(new Date());
        calBegin.add(Calendar.DAY_OF_MONTH, -1);
        Calendar calEnd = Calendar.getInstance();
        // 使用给定的 Date 设置此 Calendar 的时间
        calEnd.setTime(new Date());
        calEnd.add(Calendar.YEAR, +1);
        // 测试此日期是否在指定日期之后
        ArrayList<TimePo> objYear = new ArrayList<>();

        while (calEnd.getTime().after(calBegin.getTime()))
        {
            // 根据日历的规则，为给定的日历字段添加或减去指定的时间量
            calBegin.add(Calendar.DAY_OF_MONTH, 1);
            // 获取年
            int year = calBegin.get(Calendar.YEAR);
            // 获取月
            int month = calBegin.get(Calendar.MONTH)+1;
            // 获取日
            int day = calBegin.get(Calendar.DATE);

            TimePo timePo = new TimePo();
            timePo.setYear(year);
            timePo.setMonth(month);
            timePo.setDay(day);
            objYear.add(timePo);
        }

        ArrayList<TimePo> yearlist = new ArrayList<>();
        Map<Integer, List<TimePo>> YearCollect = objYear.stream().collect(Collectors.groupingBy(TimePo::getYear));
        YearCollect.keySet().stream().forEach(e->{
            List<TimePo> monthPO = YearCollect.get(e);
            TimePo timePo = new TimePo();
            timePo.setName(e+"");
            ArrayList<TimePo> monthlist = new ArrayList<>();
            Map<Integer, List<TimePo>> monthCollect = monthPO.stream().collect(Collectors.groupingBy(TimePo::getMonth));
            monthCollect.keySet().stream().forEach(x->{
                TimePo timePo1 = new TimePo();
                timePo1.setName((x>=10?x:"0"+x)+"");
                timePo1.setChildren(monthCollect.get(x).stream().map(y->{ y.setName((y.getDay()>=10?y.getDay():"0"+y.getDay())+"");return y;}).collect(Collectors.toList()));
                monthlist.add(timePo1);

            });
            timePo.setChildren(monthlist);
            yearlist.add(timePo);
        });

        return yearlist;
    }



    /**
     * 得到每个月的上旬、中旬、下旬
     *
     * @param lierTime 月份向前推移的步长
     */
    public static Map<Integer, List<TimeGenPo>> getDateSurname(Long lierTime) {

        //获取当前时间
        OffsetDateTime now = OffsetDateTime.now();
        //value返回模型
        List<TimeGenPo> returnList = new ArrayList<>();
        //循环时间数组
        String[] nameArr = {"月上旬", "月中旬", "月下旬"};

        /**
         * 循环处理
         * */
        for (int i = 0; i < lierTime; i++) {

            //对象模型
            TimeGenPo obj = new TimeGenPo();
            //对象内数组模型
            List<TimeGenPo.ChildTime> childTimeList = new ArrayList<>();

            //获取当前月的最后一天
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            Calendar cale = Calendar.getInstance();
            cale.add(Calendar.MONTH, i + 1);
            cale.set(Calendar.DAY_OF_MONTH, 0);
            String lastDay = format.format(cale.getTime());

            if (i < 1) {
                //最终生成当月
                obj.setYearNum(now.getYear());
                String nowFormat = OffsetDateTimeUtils.formatDateTimeToYmd(now);
                String[] nowSplit = nowFormat.split("-");
                String[] nowTimeArr =
                        {nowSplit[0] + "-" + nowSplit[1] + "-" + "01" + "_" +
                                nowSplit[0] + "-" + nowSplit[1] + "-" + "10"
                                , nowSplit[0] + "-" + nowSplit[1] + "-" + "11" + "_" +
                                nowSplit[0] + "-" + nowSplit[1] + "-" + "20"
                                , nowSplit[0] + "-" + nowSplit[1] + "-" + "21" + "_" + lastDay};
                if (now.getDayOfMonth() <= 10) {
                    for (int k = 0; k < nameArr.length; k++) {
                        TimeGenPo.ChildTime child = obj.new ChildTime();
                        child.setTimeName(now.getMonth().getValue() + nameArr[k]);
                        String[] time = nowTimeArr[k].split("_");
                        child.setStartTime(time[0]);
                        child.setEndTime(time[1]);
                        childTimeList.add(child);
                    }
                } else if (now.getDayOfMonth() > 10 && now.getDayOfMonth() <= 21) {
                    for (int k = 1; k < nameArr.length; k++) {
                        TimeGenPo.ChildTime child = obj.new ChildTime();
                        child.setTimeName(now.getMonth().getValue() + nameArr[k]);
                        String[] time = nowTimeArr[k].split("_");
                        child.setStartTime(time[0]);
                        child.setEndTime(time[1]);
                        childTimeList.add(child);
                    }
                } else if (now.getDayOfMonth() > 21) {
                    for (int k = 2; k < nameArr.length; k++) {
                        TimeGenPo.ChildTime child = obj.new ChildTime();
                        child.setTimeName(now.getMonth().getValue() + nameArr[k]);
                        String[] time = nowTimeArr[k].split("_");
                        child.setStartTime(time[0]);
                        child.setEndTime(time[1]);
                        childTimeList.add(child);
                    }
                }
                obj.setChildTime(childTimeList);
            } else {
                //非当月月份累加
                OffsetDateTime plusMonths = now.plusMonths(i);
                String plusFormat = OffsetDateTimeUtils.formatDateTimeToYmd(plusMonths);
                String[] plusSplit = plusFormat.split("-");
                String[] timeArr =
                        {plusSplit[0] + "-" + plusSplit[1] + "-" + "01" + "_" +
                                plusSplit[0] + "-" + plusSplit[1] + "-" + "10"
                                , plusSplit[0] + "-" + plusSplit[1] + "-" + "11" + "_" +
                                plusSplit[0] + "-" + plusSplit[1] + "-" + "20"
                                , plusSplit[0] + "-" + plusSplit[1] + "-" + "21" + "_" + lastDay};
                obj.setYearNum(plusMonths.getYear());
                for (int k = 0; k < nameArr.length; k++) {
                    TimeGenPo.ChildTime child = obj.new ChildTime();
                    child.setTimeName(plusMonths.getMonth().getValue() + nameArr[k]);
                    String[] time = timeArr[k].split("_");
                    child.setStartTime(time[0]);
                    child.setEndTime(time[1]);
                    childTimeList.add(child);
                }
                obj.setChildTime(childTimeList);
            }
            returnList.add(obj);
        }

        //分组处理
        Map<Integer, List<TimeGenPo>> collect = returnList.stream().collect(Collectors.groupingBy(TimeGenPo::getYearNum));

        return collect;
    }
}
