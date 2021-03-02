package com.wisea.transac.common.utils;

public class TimeShowUtil {

    private static final long ONE_MINUTE = 60000L;
    private static final long ONE_HOUR = 3600000L;
    private static final long ONE_DAY = 86400000L;

    private static final String ONE_MINUTE_AGO = "1小时内";
    private static final String ONE_HOUR_AGO = "小时前";
    private static final String ONE_DAY_AGO = "天前";

    /**
     * 返回1小时内,小时前,几天前的信息
     * @param date
     * @return
     */
    public static String timeShow(Long date) {
        String format = format(date);
        return format;
    }

    public static String format(Long date) {
        if (date < 45L * ONE_MINUTE) {
            long minutes = toMinutes(date);
            return  ONE_MINUTE_AGO;
        }
        if (date < 24L * ONE_HOUR) {
            long hours = toHours(date);
            return (hours <= 0 ? 1 : hours) + ONE_HOUR_AGO;
        }
        if (date < 30L * ONE_DAY) {
            long days = toDays(date);
            if (days > 5) {
                return 5 + ONE_DAY_AGO;
            }
            return (days <= 0 ? 1 : days) + ONE_DAY_AGO;
        }
        return 5 + ONE_DAY_AGO;
    }

    private static long toSeconds(long date) {
        return date / 1000L;
    }

    private static long toMinutes(long date) {
        return toSeconds(date) / 60L;
    }

    private static long toHours(long date) {
        return toMinutes(date) / 60L;
    }

    private static long toDays(long date) {
        return toHours(date) / 24L;
    }
}
