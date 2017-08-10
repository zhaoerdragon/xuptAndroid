package com.example.library.tools;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 自定义Toast工具类
 */
public class ToastUtil {

    /**
     * ToastUtils是否显示，默认为显示
     */
    private static boolean isShown = true;

    /**
     * 工具类不能被初始化
     */
    public ToastUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 显示出一个矩形的Toast，时间长度为SHORT
     * @param context
     * @param string
     */
    public static void toastRectShort(Context context, String string) {

        if (isShown && (context != null)) {
            /**
             * 用代码来动态生成布局，降低各个组件之间的耦合性。
             */
            ViewGroup toastView = new LinearLayout(context);
            toastView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                    .WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            toastView.setBackgroundColor(Color.BLACK);
            toastView.setAlpha(0.618f);

            TextView textView = new TextView(context);
            textView.setText(string);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(17);
            textView.setPadding(7, 7, 7, 7);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout
                    .LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            toastView.addView(textView, layoutParams);

            final Toast toast = new Toast(context);
            toast.setGravity(Gravity.BOTTOM, 0, ScreenUtil.getScreenWidth(context) / 6);
            toast.setDuration(Toast.LENGTH_SHORT);
            toast.setView(toastView);
            toast.show();
        }

    }

    /**
     * 显示自定义Toast，时间单位是毫秒，time不能超过3500,否则Toast会提前消失
     * @param context
     * @param string
     * @param time 单位毫秒
     */
    public static void toastRectShort(Context context, String string,int time) {

        if (isShown && (context != null)) {
            /**
             * 用代码来动态生成布局，降低各个组件之间的耦合性。
             */
            ViewGroup toastView = new LinearLayout(context);
            toastView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams
                    .WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT));
            toastView.setBackgroundColor(Color.BLACK);
            toastView.setAlpha(0.618f);

            TextView textView = new TextView(context);
            textView.setText(string);
            textView.setTextColor(Color.WHITE);
            textView.setTextSize(17);
            textView.setPadding(7, 7, 7, 7);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout
                    .LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);

            toastView.addView(textView, layoutParams);

            final Toast toast = new Toast(context);
            toast.setGravity(Gravity.BOTTOM, 0, ScreenUtil.getScreenWidth(context) / 6);
            toast.setDuration(Toast.LENGTH_LONG);
            toast.setView(toastView);
            toast.show();
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    toast.cancel();
                }
            }, time);
        }
    }

}
