package com.zhaoerdragon.xuptandroid.tools;

import android.util.Log;

/**
 * Log工具类
 */
public class LogUtils {

    /**
     * 测试标志，应用发布时可以将值设置为false，则不会打印出Log
     */
    public static boolean isDebug = true;

    /**
     * 打印标志
     */
    private static final String TAG = "hahaha";

    /**
     * 工具类不能被初始化
     */
    public LogUtils()
    {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void i(String msg)
    {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg)
    {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg)
    {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg)
    {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void i(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg)
    {
        if (isDebug)
            Log.i(tag, msg);
    }

}
