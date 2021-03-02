package com.wisea.cultivar.common.utils.tp;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.time.temporal.ChronoUnit;
import java.util.Calendar;
import java.util.List;

import com.google.common.collect.Lists;
import com.wisea.cloud.common.util.ConverterUtil;

/**
 * Auth： itudou
 * CreateDate:  2017/12/14
 * projectName:  wtp
 * remark:
 */
public class OffsetDateTimeUtils {
    /**
     * 获取一天的最小时间
     * @param offsetDateTime
     * @return
     */
    public static OffsetDateTime getDayMinTime(OffsetDateTime offsetDateTime){
        if(ConverterUtil.isNotEmpty(offsetDateTime)){
            return offsetDateTime.withHour(0).withMinute(0).withSecond(0);
        }else{
            return null;
        }
    }

    /**
     * 获取一天的最大时间
     * @param offsetDateTime
     * @return
     */
    public static OffsetDateTime getDayMaxTime(OffsetDateTime offsetDateTime){
        if(ConverterUtil.isNotEmpty(offsetDateTime)){
            return offsetDateTime.withHour(23).withMinute(59).withSecond(59);
        }else{
            return null;
        }
    }

    /**
     * 获取当前时间到当天最晚时间的秒数
     * @return
     */
    public static Integer getExpiration(){
        OffsetDateTime odt = OffsetDateTime.now();
        OffsetDateTime maxDate = OffsetDateTimeUtils.getDayMaxTime(odt);
        long between = ChronoUnit.SECONDS.between(odt, maxDate);
        return Integer.valueOf(between + "");
    }

    /**
     * 设置指定的月份第几天
     * @param mouth
     * @param day
     * @return
     */
    public static OffsetDateTime getMouthAndDay(String mouth, String day){

    	OffsetDateTime now = OffsetDateTime.now();

        if(mouth != null){
        	now = now.withMonth(ConverterUtil.toInteger(mouth));
        }
        if(day != null){
        	now = now.withDayOfMonth(ConverterUtil.toInteger(day));
        }
        return now.withHour(0).withMinute(0).withSecond(0);
    }

    /**
     * 获取当前的年份
     *
     * @author wangh(wisea)
     *
     * @date 2018年3月8日
     * @version 1.0
     */
    public static int getNowYear(){
    	LocalDate today = LocalDate.now();
		int year = today.getYear();
    	return year;
    }

    /**
     * 获取某月的最后一天日期
     *
     */
    public static OffsetDateTime getLastDayOfMonth (int year,int month) {
        Calendar cal = Calendar.getInstance();
        //设置年份
        cal.set(Calendar.YEAR,year);
        //设置月份
        cal.set(Calendar.MONTH, month-1);
        //获取某月最大天数
        int lastDay = cal.getActualMaximum(Calendar.DAY_OF_MONTH);
        //设置日历中月份的最大天数
        OffsetDateTime now = OffsetDateTime.now();
        now = now.withYear(year).withMonth(month).withDayOfMonth(lastDay);

        return now.withHour(0).withMinute(0).withSecond(0);
    }

    /**
     * 获取某月的开始一天日期
     * @param mouth
     * @param day
     * @return
     */
    public static OffsetDateTime getFirstDayOfMonth(int year,int month){

    	OffsetDateTime now = OffsetDateTime.now();

    	now = now.withYear(year);
    	now = now.withMonth(month);

        return now.withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
    }

    /**
     *
     * 获取几个月之前的日期
     * @param mouth
     * @return
     */
    public static OffsetDateTime getLastTime (int mouth) {

    	OffsetDateTime now = OffsetDateTime.now();
    	now = getDayMinTime(now);
    	//获取月份
    	int nowMonth = now.getMonthValue();
    	//当指定的过去月份大于当前月份
    	if (ConverterUtil.toInteger(mouth) >= nowMonth) {

    		now = now.plusYears(-1);
    		now = now.withMonth(12 - (ConverterUtil.toInteger(mouth) - nowMonth));
    		return now;
    	}else {

    		now = now.withMonth(nowMonth - ConverterUtil.toInteger(mouth));
    		return now;
    	}
    }

    /**
     * 格式化时间（默认格式yyyy-MM-dd HH:mm:ss）
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTimeToYmdhms(OffsetDateTime dateTime) {
        return formatDateTime(dateTime, "yyyy-MM-dd HH:mm:ss");
    }

    /**
     * 格式化时间（默认格式yyyy-MM-dd）
     *
     * @param dateTime
     * @return
     */
    public static String formatDateTimeToYmd(OffsetDateTime dateTime) {
        return formatDateTime(dateTime, "yyyy-MM-dd");
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
        if (ConverterUtil.isEmpty(patten)) {
            return null;
        }
        return dateTime.format(DateTimeFormatter.ofPattern(patten));
    }

    /**
     * 获取long时间戳
     */
    public static long getLong() {

    	long time = OffsetDateTime.now().getLong(ChronoField.INSTANT_SECONDS);

        return time;
    }

    /**
     * 获取近多少天（包含当天）的年月日列表
     * @return
     */
    public static List<String> getDaysYmd(Integer days){
        OffsetDateTime now = OffsetDateTime.now();
        OffsetDateTime startDate = now.minusDays(days - 1);
        return getStartAndEndYmd(startDate, now);
    }

    /**
     * 获取开始时间到结束时间年月日列表
     * @return
     */
    public static List<String> getStartAndEndYmd(OffsetDateTime startDate, OffsetDateTime endDate){
        List<String> ymdList = Lists.newArrayList();
        startDate = getDayMinTime(startDate);
        endDate = getDayMaxTime(endDate);
        do {
            ymdList.add(startDate.format(DateTimeFormatter.ofPattern("yyyy-MM-dd")));
        }while ((startDate = startDate.plusDays(1)).isBefore(endDate));
        return ymdList;
    }

    /**
     * 获取某年的年月列表
     * @return
     */
    public static List<String> getYearEndYm(Integer year){
        List<String> ymdList = Lists.newArrayList();
        OffsetDateTime now = OffsetDateTime.now();
        now = now.withYear(year).withMonth(1).withDayOfMonth(1).withHour(0).withMinute(0).withSecond(0);
        do {
            ymdList.add(now.format(DateTimeFormatter.ofPattern("yyyy-MM")));
        }while ((now = now.plusMonths(1)).isBefore(now.withYear(year).withMonth(12).withDayOfMonth(31)));
        return ymdList;
    }
}
