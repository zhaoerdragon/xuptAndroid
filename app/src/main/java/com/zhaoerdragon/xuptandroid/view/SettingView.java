package com.zhaoerdragon.xuptandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.zhaoerdragon.xuptandroid.tools.ScreenUtils;

/**
 * 设置类自定义控件
 */
public class SettingView extends View {
    private Paint mPaint;
    private Context mContext;

    public SettingView(Context context) {
        super(context);
        initPaint();
        mContext = context;
    }

    public SettingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initPaint();
        mContext = context;
    }

    public SettingView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initPaint();
        mContext = context;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

        int width = measureWidth(widthMeasureSpec);
        int height = measureHeight(heightMeasureSpec);

        setMeasuredDimension(width, height);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    /**
     * 测量控件的高度
     */
    private int measureHeight(int heightSpec){
        int size = MeasureSpec.getSize(heightSpec);
        int mode = MeasureSpec.getMode(heightSpec);
        int result = 0;
        if(mode == MeasureSpec.EXACTLY){
            result = size;
        }else {
            result = 100;
            if(mode == MeasureSpec.AT_MOST){
                result = Math.min(result, size);
            }
        }

        return result;
    }

    /**
     * 测量控件的宽度
     */
    private int measureWidth(int widthSpec){
        int size = MeasureSpec.getSize(widthSpec);
        int mode = MeasureSpec.getMode(widthSpec);
        int result = 0;
        if(mode == MeasureSpec.EXACTLY){
            result = size;
        }else {
            result = ScreenUtils.getScreenWidth(mContext);
            if(mode == MeasureSpec.AT_MOST){
                result = Math.min(result, size);
            }
        }

        return result;
    }

    /**
     * 设置画笔
     */
    private void initPaint(){
        mPaint = new Paint();
        mPaint.setStyle(Paint.Style.FILL);
    }

}
