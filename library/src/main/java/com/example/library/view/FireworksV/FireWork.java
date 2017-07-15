package com.example.library.view.FireworksV;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.animation.AccelerateInterpolator;

import java.util.ArrayList;
import java.util.Random;

/**
 * 一组烟花的属性
 */
public class FireWork {

    private final static int DEFAULT_ELEMENT_COUNT = 5;                 //小点的数量

    private final static float DEFAULT_ELEMENT_SIZE = 10;               //小点的尺寸

    private final static int DEFAULT_DURATION = 1000;                   //小点的持续时间

    private final static float DEFAULT_LAUNCH_SPEED = 16;               //开始的速度

    private final static float DEFAULT_WIND_SPEED = 6;                  //风速

    private final static float DEFAULT_GRAVITY = 6;                     //重力

    /**
     * 小点的颜色
     */
    private static final int[] baseColors = {0xFFFF43, 0x00E500, 0x44CEF6, 0xFF0040, 0xFF00FFB7, 0x008CFF
            , 0xFF5286, 0x562CFF, 0x2C9DFF, 0x00FFFF, 0x00FF77, 0x11FF00, 0xFFB536, 0xFF4618, 0xFF334B, 0x9CFA18};

    private Paint mPaint;

    private ArrayList<Element> elements = new ArrayList<>();
    private ValueAnimator valueAnimator;
    private float animatorValue;
    private AnimationEndListener animationEndListener;

    private int mCount;                     //小点的数量
    private float mSize;                    //小点的尺寸
    private int mDuration;                  //小点的持续时间
    private float mLaunchSpeed;             //小点的开始速度
    private float mWindSpeed;               //小点的风速
    private float mGravity;                 //小点的重力
    private int[] mColors;                //小点的颜色
    private Location mLocation;             //位置
    private int mWindDirection;             //风向

    public FireWork(Location location, int windDirection) {
        this.mLocation = location;
        this.mWindDirection = windDirection;

        this.mCount = DEFAULT_ELEMENT_COUNT;
        this.mSize = DEFAULT_ELEMENT_SIZE;
        this.mDuration = DEFAULT_DURATION;
        this.mLaunchSpeed = DEFAULT_LAUNCH_SPEED;
        this.mWindSpeed = DEFAULT_WIND_SPEED;
        this.mGravity = DEFAULT_GRAVITY;

        this.mColors = baseColors;

        Random random = new Random();
        int color = mColors[random.nextInt(mColors.length)];
        for (int i = 0; i < mCount; i++) {
            elements.add(new Element(color, Math.toRadians(random.nextInt(180)), random.nextFloat() *
                    mLaunchSpeed));
        }
        mPaint = new Paint();
        mPaint.setColor(color);
    }

    public void setAnimationEndListener(AnimationEndListener animationEndListener) {
        this.animationEndListener = animationEndListener;
    }

    /**
     * 点燃烟花，开火
     */
    public void openFire() {
        valueAnimator = ValueAnimator.ofFloat(1, 0);
        valueAnimator.setDuration(mDuration);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                animatorValue = (float) valueAnimator.getAnimatedValue();
                for (Element element : elements) {
                    element.mX = (float) (element.mX + Math.cos(element.mDirection) * element.
                            mSpeed * animatorValue + mWindSpeed * mWindDirection);
                    element.mY = (float) (element.mY - Math.sin(element.mDirection) * element
                            .mSpeed * animatorValue + mGravity * (1 - animatorValue));
                }
            }
        });
        valueAnimator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (animationEndListener != null) {
                    animationEndListener.onAnimationEnd();
                }
            }
        });
        valueAnimator.start();
    }

    /**
     * 画出每一个的烟火
     */
    public void drawFire(Canvas canvas) {
        mPaint.setAlpha((int) (225 * animatorValue));
        for (Element element : elements) {
            canvas.drawCircle(mLocation.x + element.mX, mLocation.y + element.mY, mSize, mPaint);
        }
    }

    /**
     * 外接接口
     */
    interface AnimationEndListener{
        void onAnimationEnd();
    }

    static class Location{
        float x;
        float y;

        public Location(float x, float y) {
            this.x = x;
            this.y = y;
        }
    }
}
