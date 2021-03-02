package com.wisea.cultivar.common.vo.tp;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @Author:liangzy(Wisea)
 * @Date:Create in 2018/5/19 16:11
 * @Description:日期类型处理工具类
 */
public class ForwardDate {

    /**
     * 用来计算获取一个时间的字符串,然后向前推几个月的算法
     *
     * @param beginDate 开始时间
     * @param month     推进的步长
     * @return 毫秒数
     * @author liangzy
     */
    public static Date getDate(Date beginDate, int month) {
        Calendar beginCal = Calendar.getInstance();
        beginCal.setTime(beginDate);
        GregorianCalendar calendar = new GregorianCalendar(beginCal.get(Calendar.YEAR),
                beginCal.get(Calendar.MONTH), beginCal.get(Calendar.DATE));
        calendar.add(GregorianCalendar.MONTH, -month);
        String begin = new java.sql.Date(calendar.getTime().getTime()).toString();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date endDate = null;
        try {
            endDate = sdf.parse(begin);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return endDate;
    }

    /**
     * 计算一个时间的毫秒数
     *
     * @param date 当前时间
     * @return 毫秒数
     * @author liangzy
     */
    public static Long getMillByDate(String date) throws Exception {
        //格式化
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
        //将字符串转为日期格式
        Date d = sdf.parse(date);
        //换算成的毫秒
        long time = d.getTime();
        return time;
    }

    /**
     * 判断当前时间是否在[startTime, endTime]区间，注意时间格式要一致
     *
     * @param nowTime   当前时间
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return
     */
    public static boolean isEffectiveDate(Date nowTime, Date startTime, Date endTime) {
        if (nowTime.getTime() == startTime.getTime()
                || nowTime.getTime() == endTime.getTime()) {
            return true;
        }
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);
        Calendar begin = Calendar.getInstance();
        begin.setTime(startTime);
        Calendar end = Calendar.getInstance();
        end.setTime(endTime);
        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * 计算两个日期相差的月份数
     *
     * @param date1   日期1
     * @param date2   日期2
     * @param pattern 日期1和日期2的日期格式
     * @return 相差的月份数
     * @throws ParseException
     */
    public static int countMonths(String date1, String date2, String pattern) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat(pattern);
        Calendar c1 = Calendar.getInstance();
        Calendar c2 = Calendar.getInstance();
        c1.setTime(sdf.parse(date1));
        c2.setTime(sdf.parse(date2));
        int year = c2.get(Calendar.YEAR) - c1.get(Calendar.YEAR);
        //开始日期若小月结束日期
        if (year < 0) {
            year = -year;
            return year * 12 + c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
        }
        return year * 12 + c2.get(Calendar.MONTH) - c1.get(Calendar.MONTH);
    }

    /**
     * 计算一个时间节点加上几个月得到一个月的算法
     *
     * @param num  日期1
     * @param date 日期2
     * @return 相差的月份数
     * @throws Exception
     * @author liangzy
     */
    public static String dateAddDate(int num, String date) throws Exception {
        int renewalsdata = num;
        String validatetime = date;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM");
        Date now = sdf.parse(validatetime);
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(now);
        calendar.add(Calendar.MONTH, renewalsdata);
        String format = sdf.format(calendar.getTime());
        return format;
    }

    /**
     * 计算一个时间和另外一个时间相差多少天
     */
    public static Long differDays(String date1, String date2) throws ParseException {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-mm-dd");
        Date d1 = sdf.parse(date1);
        Date d2 = sdf.parse(date2);
        long daysBetween = (d2.getTime() - d1.getTime() + 1000000) / (60 * 60 * 24 * 1000) + 1;
        return daysBetween;
    }
}
