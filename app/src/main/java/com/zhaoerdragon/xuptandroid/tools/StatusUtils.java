package com.zhaoerdragon.xuptandroid.tools;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.zhaoerdragon.xuptandroid.R;

/**
 * 状态栏工具类
 */
public class StatusUtils {

    /**
     * 工具类不能被初始化
     */
    public StatusUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }


    /**
     * 改变状态栏的颜色，系统版本必须在19及以上。
     * 此方法使用时需要在 android:theme 属性中加上 <item name ="android:fitsSystemWindows">true</item>这一条。
     * 否则整个内容布局会拓展至状态栏，造成拉伸效果
     * @param activity
     * @param color
     * @return
     */
    public static boolean setStatusColor(Activity activity, int color) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            //设置状态栏为透明
            activity.getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            //找到内容控件
            ViewGroup viewGroup = (ViewGroup) activity.findViewById(android.R.id.content);
            //设置新的状态栏颜色
            View statsuBarView = new View(activity.getApplicationContext());
            statsuBarView.setBackgroundColor(color);
            //将内容栏拓展为整个屏幕
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(ViewGroup
                    .LayoutParams.MATCH_PARENT, ScreenUtils.getStatusHeight(activity.getApplicationContext()));
            viewGroup.addView(statsuBarView, layoutParams);

            return true;
        }
        return false;
    }

}
