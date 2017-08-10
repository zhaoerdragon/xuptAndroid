package com.example.library.tools;

import android.content.Context;

/**
 * 将dp,sp转换为px的工具类
 */
public class DisplayUtil {

    /**
     * 工具类不能被初始化
     */
    public DisplayUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 将px值转换为dip或dp值，保证尺寸大小不变
     * @param context
     * @param pxValue px值
     * @return
     */
    public static int px2dip(Context context, float pxValue){
        float scale = context.getResources().getDisplayMetrics().density;
        return (int)(pxValue/scale+0.5f);
    }

    /**
     * 将dp或dip值转换为px值，保证尺寸大小不变
     * @param context
     * @param dipValue dp或dip值
     * @return
     */
    public static int dip2px(Context context, float dipValue) {
        float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5);
    }

    /**
     * 将px值转换为sp值，保证尺寸大小不变
     * @param context
     * @param pxValue px值
     * @return
     */
    public static int px2sp(Context context, float pxValue) {
        float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (pxValue / scale + 0.5f);
    }

    /**
     * 将sp值转换为px值，保证尺寸大小不变
     * @param context
     * @param spValue sp值
     * @return
     */
    public static int sp2px(Context context, float spValue) {
        float scale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * scale + 0.5);
    }

}
