package com.example.dllo.bibilala.base;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
        initView();
        initData(savedInstanceState);
    }

    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData(Bundle savedInstanceState);

    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

}
