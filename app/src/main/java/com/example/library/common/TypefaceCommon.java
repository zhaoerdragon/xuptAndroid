package com.example.library.common;

import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Typeface;

/**
 * 字体公共类
 * 将字体内部的操作封装起来，只有一个暴露给外部的接口
 */
public class TypefaceCommon {

    /**
     * 微软雅黑
     */
    private static Typeface yaheiTypeface;

    /**
     * 方正兰亭纤黑
     */
    private static Typeface lantingTypeface;

    /**
     * 初始化字体,建议在应用刚开启时使用
     */
    public static void initTypeface(Context context) {
        if (context != null) {
            yaheiTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/微软雅黑.TTF");
            lantingTypeface = Typeface.createFromAsset(context.getAssets(), "fonts/方正兰亭纤黑.TTF");
        }

    }

    /**
     * 获取微软雅黑字体
     * @return
     */
    public static Typeface getYaheiTypeface() {
        if (yaheiTypeface != null) {
            return yaheiTypeface;
        }
        return null;
    }

    /**
     * 获取方正兰亭纤黑字体
     * @return
     */
    public static Typeface getLantingTypeface() {
        if (lantingTypeface != null) {
            return lantingTypeface;
        }
        return null;
    }
}
