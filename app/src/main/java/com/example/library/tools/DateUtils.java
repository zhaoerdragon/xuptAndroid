package com.example.library.tools;

import java.util.Calendar;

/**
 * 日期数据的工具类
 */
public class DateUtils {

    /**
     * 工具类不能被初始化
     */
    public DateUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 返回现在的年份
     * @return
     */
    public static int getIntYear() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.YEAR);
    }

    /**
     * 返回现在的月份
     * @return
     */
    public static int getIntMonth() {
        Calendar calendar = Calendar.getInstance();
        return (calendar.get(Calendar.MONTH) + 1);
    }

    /**
     * 返回现在是几号
     * @return
     */
    public static int getIntDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }

    /**
     * 返回现在的小时
     * @return
     */
    public static int getIntHour() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.HOUR_OF_DAY);
    }

    /**
     * 返回现在的分钟
     * @return
     */
    public static int getMinute() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.MINUTE);
    }

    /**
     * 返回今天日期的字符串，用'/'隔开
     * @return
     */
    public static String getStringToday() {
        Calendar calendar = Calendar.getInstance();
        String today = getIntYear() + "/" + getIntMonth() + "/" + getIntDay();
        return today;
    }
}
