package com.wisea.cultivar.plant.utils;

import com.mysql.cj.util.StringUtils;
import com.wisea.cloud.common.util.ConverterUtil;

import java.time.LocalDate;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;


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
     * 判断两个日期是否相等
     * @param time1
     * @param time2
     * @return
     */
    public static boolean isEqualTime(OffsetDateTime time1, OffsetDateTime time2){

    	String str1 = formatDateTimeToYmd(time1);
    	String str2 = formatDateTimeToYmd(time2);
    	boolean isEq = false;
    	if (str1.equals(str2)) {
    		isEq = true;
    	}

    	return isEq;
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
     * 判断两个日期差多少天，day1是大值
     * @param day1
     * @param day2
     * @return
     */
    public static int getTimeDiv (OffsetDateTime day1, OffsetDateTime day2) {

    	long long1 = day1.getLong(ChronoField.INSTANT_SECONDS);
    	long long2 = day2.getLong(ChronoField.INSTANT_SECONDS);

    	int days = (int)(long1-long2)/(3600*24);
    	if (day2.plusDays(days).isBefore(day1)) {
    		days += 1;
    	}
    	return days;
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
        if (StringUtils.isNullOrEmpty(patten)) {
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
}
