package com.example.library.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

/**
 * BaseActivity，封装与业务无关的共用逻辑
 */
public abstract class XuptActivity extends AppCompatActivity{

    private static final String TAG = "XuptActivity";

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d(TAG, getClass().getSimpleName());
        ActivityCollector.addActivity(this);

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
     * 业务相关操作
     */
    protected abstract void doBusiness();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        ActivityCollector.removeActivity(this);
    }
}
