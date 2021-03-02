package com.wisea.cultivar.origin.util;

import java.time.LocalDate;
import java.time.OffsetDateTime;

import com.wisea.cloud.common.util.ConverterUtil;


/**
 * 时间相关的共同部分
 *
 * @author wangh(wisea)
 *
 * @date 2018年8月29日
 * @version 1.0
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
     * 设置指定的月份第几天
     * @param offsetDateTime
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

}
