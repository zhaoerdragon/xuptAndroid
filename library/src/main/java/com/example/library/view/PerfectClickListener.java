package com.example.library.view;

import android.view.View;

import java.util.Calendar;

/**
 * 更好的点击接口，避免在1秒内出现多次点击
 */
public abstract class PerfectClickListener implements View.OnClickListener {

    public static final int MIN_CLICK_DELAY_TIME = 1000;
    private long lastClickTime = 0;
    private int id = -1;

    @Override
    public void onClick(View view) {
        long currentTime = Calendar.getInstance().getTimeInMillis();
        int mId = view.getId();
        if (id != mId) {
            id = mId;
            lastClickTime = currentTime;
            onNewClick(view);
            return;
        }
        if (currentTime - lastClickTime > MIN_CLICK_DELAY_TIME) {
            lastClickTime = currentTime;
            onNewClick(view);
        }
    }

    protected abstract void onNewClick(View view);
}
