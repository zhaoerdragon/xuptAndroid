package com.example.library.view.FireworksV;

/**
 * 每个小点的属性
 */
public class Element {

    public int mColor;                      //小点的属性
    public double mDirection;               //小点的运动方向
    public float mSpeed;                    //小点的加速度
    public float mX = 0;
    public float mY = 0;

    public Element(int color, double direction, float speed) {
        this.mColor = color;
        this.mDirection = direction;
        this.mSpeed = speed;
    }

}
