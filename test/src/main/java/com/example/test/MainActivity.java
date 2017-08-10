package com.example.test;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

import com.example.library.view.fireworks.FireworksView;

public class MainActivity extends AppCompatActivity {

    private EditText mEditText;
    private FireworksView fireworksView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fireworksView = (FireworksView) findViewById(R.id.activity_main_fireworks);
        mEditText = (EditText) findViewById(R.id.activity_main_edittext);

        fireworksView.bindEdittext(mEditText);
    }
}
