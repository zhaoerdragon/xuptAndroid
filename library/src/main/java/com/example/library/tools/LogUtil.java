package com.example.library.tools;

import android.util.Log;

/**
 * Log工具类
 */
public class LogUtil {

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
    public LogUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    public static void i(String msg) {
        if (isDebug)
            Log.i(TAG, msg);
    }

    public static void d(String msg) {
        if (isDebug)
            Log.d(TAG, msg);
    }

    public static void e(String msg) {
        if (isDebug)
            Log.e(TAG, msg);
    }

    public static void v(String msg) {
        if (isDebug)
            Log.v(TAG, msg);
    }

    public static void i(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void d(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void e(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    public static void v(String tag, String msg) {
        if (isDebug)
            Log.i(tag, msg);
    }

    /**
     * 方便的打印出每个的值
     * @param id
     * @param msg
     */
    public static void iInt(int id, String msg) {
        if (isDebug) {
            LogUtil.i("第 " + id + " 的值为" + msg);
        }
    }
}
