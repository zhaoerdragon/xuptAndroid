package com.zhaoerdragon.xuptandroid.view;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * 通过自己的方式显示datas，并可以水平滑动
 */

public class HorizontalScrollView extends View {

    private int[] datas = new int[10];
    private float itemSize;
    private float dx;
    private float move;
    private int height;
    private int width;

    public HorizontalScrollView(Context context) {
        this(context, null);
    }

    public HorizontalScrollView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public HorizontalScrollView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        setClickable(true);
        setOnTouchListener(new OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()){
                    case MotionEvent.ACTION_DOWN:
                        dx = event.getX();
                        break;
                    case MotionEvent.ACTION_MOVE:
                        move = move + event.getX() - dx;
                        dx = event.getX();
                        if (move < -(datas.length * itemSize - itemSize - width + 50)) {
                            move = -(datas.length * itemSize - itemSize - width + 50);
                        } else if (move > 50) {
                            move = 50;
                        }
                        invalidate();
                        break;
                    default:break;
                }

                return true;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        height = getHeight() - 50;
        width = getWidth();
    }

}
