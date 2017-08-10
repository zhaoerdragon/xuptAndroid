package com.example.library.tools;

import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 光标工具类
 */
public class CursorUtil {

    /**
     * 光标工具类，获取当前光标的位置
     * float[0]为x轴坐标，float[1]为y轴坐标
     * @param view
     * @param editText
     * @return
     */
    public static float[] getCursorPosition(View view, EditText editText) {

        int xOffset = 0;
        int yOffset = 0;
        Class<?> clazz = EditText.class;
        clazz = clazz.getSuperclass();
        try {
            Field editor = clazz.getDeclaredField("mEditor");
            editor.setAccessible(true);
            Object mEditor = editor.get(editText);

            Class<?> editorClazz = Class.forName("android.widget.Editor");
            Field drawables = editorClazz.getDeclaredField("mCursorDrawable");
            drawables.setAccessible(true);
            Drawable[] drawable = (Drawable[]) drawables.get(mEditor);

            Method getVerticalOffset = clazz.getDeclaredMethod("getVerticalOffset", boolean.class);
            Method getCompoundPaddingLeft = clazz.getDeclaredMethod("getCompoundPaddingLeft");
            Method getExtendedPaddingTop = clazz.getDeclaredMethod("getExtendedPaddingTop");

            getVerticalOffset.setAccessible(true);
            getCompoundPaddingLeft.setAccessible(true);
            getExtendedPaddingTop.setAccessible(true);

            if (drawable != null) {
                Rect bounds = drawable[0].getBounds();
                xOffset = (int) getCompoundPaddingLeft.invoke(editText) + bounds.left;
                yOffset = (int) getExtendedPaddingTop.invoke(editText) +
                        (int) getVerticalOffset.invoke(editText, false) + bounds.bottom;

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        float x = editText.getX() + xOffset;
        float y = editText.getY() + yOffset;

        //当EditText的父view与FireworkView的坐标（左上角的坐标值）不一致时进行修正
        int[] positionE = new int[2];
        if (editText.getParent() != null) {
            ((ViewGroup) editText.getParent()).getLocationInWindow(positionE);
        }
        int[] positionF = new int[2];
        view.getLocationInWindow(positionF);
        x = x + positionE[0] - positionF[0];
        y = y + positionE[1] - positionF[1];

        return new float[]{x, y};
    }

}
