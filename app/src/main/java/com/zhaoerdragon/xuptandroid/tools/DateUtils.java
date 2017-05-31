package com.zhaoerdragon.xuptandroid.tools;

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
        return calendar.get(Calendar.MONTH);
    }

    /**
     * 返回现在是几号
     * @return
     */
    public static int getIntDay() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(Calendar.DAY_OF_MONTH);
    }
}
