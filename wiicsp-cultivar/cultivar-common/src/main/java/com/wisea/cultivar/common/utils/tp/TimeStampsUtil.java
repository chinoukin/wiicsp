package com.wisea.cultivar.common.utils.tp;

import com.wisea.cultivar.common.entity.tp.TimeGenPo;
import org.apache.commons.lang3.StringUtils;

import java.text.SimpleDateFormat;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Auth： yangtao
 * remark:  生成时间戳、时间处理工具类
 */
public class TimeStampsUtil {
    public static Random random = new Random();


    /**
     * 生成一个yyyy-mm-dd+4位随机数的code码
     *
     * @return
     */
    public static String generate4TimeStamps() {
        //获取日期
        OffsetDateTime now = OffsetDateTime.now();
        String formatDateTime = formatDateTime(now, "yyyyMMdd");
        //获取6位随机数
        String random = getFixLenthString(4);

        return formatDateTime.concat(random);
    }

    /**
     * 生成一个yyyy-mm-dd+6位随机数的code码
     *
     * @return
     */
    public static String generate6TimeStamps() {
        //获取日期
        OffsetDateTime now = OffsetDateTime.now();
        String formatDateTime = formatDateTime(now, "yyyyMMdd");
        //获取6位随机数
        String random = getFixLenthString(6);

        return formatDateTime.concat(random);
    }

    /**
     * 返回长度为【strLength】的随机数，数字
     *
     * @param strLength
     * @return
     */
    public static String getFixLenthString(int strLength) {
        Random rm = new Random();
        // 获得随机数
        Long pross = Math.abs(rm.nextLong());
        // 将获得的获得随机数转化为字符串
        String fixLenthString = String.valueOf(pross);
        // 返回固定的长度的随机数
        return fixLenthString.substring(0, strLength);
    }

    /**
     * 格式化时间
     *
     * @param dateTime
     * @param patten
     * @return
     */
    public static String formatDateTime(OffsetDateTime dateTime, String patten) {
        if (dateTime == null) {
            return null;
        }
        if (StringUtils.isEmpty(patten)) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ofPattern(patten));
    }

    /**
     * 根据传入的类型判断应该获取的时间
     * 获取当前时间:yyyy-MM-dd
     * DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
     * String format = now.format(formatter);
     *
     * @param type     0:固定哪天{今天、昨天、前天}
     *                 1:根据所给天数，得到时间区间{最近7天}
     * @param lierTime 向前推移的天数步长
     */
    public static OffsetDateTime[] getDate(String type, Long lierTime) {
        //获取当前时间
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime[] str = new OffsetDateTime[2];
        if (("0".equals(type))) {
            OffsetDateTime aWeekAgo = now.minusDays(lierTime);
            str = new OffsetDateTime[]{aWeekAgo, aWeekAgo};
            return str;
        } else if (("1").equals(type)) {
            OffsetDateTime aWeekAgo = now.minusDays(lierTime);
            str = new OffsetDateTime[]{aWeekAgo, now};
            return str;
        }
        return str;
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
