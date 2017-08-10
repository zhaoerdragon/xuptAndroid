package com.example.library.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * BaseActivity，封装与业务无关的共用逻辑
 */
public abstract class XuptActivity extends AppCompatActivity{

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        initVariables();
        initViews(savedInstanceState);
        doBusiness();
    }

    /**
     * 从外部获取数据
     */
    protected abstract void initVariables();

    /**
     * 进行视图的相关操作
     * @param savedInstanceState
     */
    protected abstract void initViews(Bundle savedInstanceState);

    /**
     * 业务操作
     */
    protected abstract void doBusiness();
}
