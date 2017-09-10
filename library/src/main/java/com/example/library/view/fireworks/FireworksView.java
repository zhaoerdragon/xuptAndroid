package com.example.library.view.fireworks;

import android.content.Context;
import android.graphics.Canvas;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.example.library.tools.CursorUtil;

import java.util.ArrayList;

public class FireworksView extends View {

    private View mView;
    private EditText mEditText;                                         //绑定的EditText
    private TextWatcher mTextWatcher;                                   //绑定TextWatcher
    private ArrayList<FireWork> fireWorks = new ArrayList<>();          //存储的Fireworks

    public FireworksView(Context context) {
        super(context);
        mView = this;
    }

    public FireworksView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mView = this;
    }

    public FireworksView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        mView = this;
    }

    /**
     * 绑定EditText
     * @param editText
     */
    public void bindEdittext(EditText editText) {
        this.mEditText = editText;
        mEditText.addTextChangedListener(mTextWatcher =new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                float[] cursorPlace = CursorUtil.getCursorPosition(mView, mEditText);
                launchAction(cursorPlace[0], cursorPlace[1], i1 == 0 ? -1 : 1);
            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

    /**
     * 移除绑定的EditText
     */
    public void removeEdittext() {
        mEditText.removeTextChangedListener(mTextWatcher);
        mEditText = null;
    }

    /**
     * 开始表演
     * @param x
     * @param y
     * @param duration
     */
    private void launchAction(float x, float y, int direction) {
        final FireWork fireWork = new FireWork(new FireWork.Location(x, y), direction);
        fireWork.setAnimationEndListener(new FireWork.AnimationEndListener() {
            @Override
            public void onAnimationEnd() {
                fireWorks.remove(fireWork);
            }
        });
        fireWorks.add(fireWork);
        fireWork.openFire();
        invalidate();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        for (int i = 0; i < fireWorks.size(); i++) {
            fireWorks.get(i).drawFire(canvas);
        }
        if (fireWorks.size() > 0) {
            invalidate();
        }
    }
}
