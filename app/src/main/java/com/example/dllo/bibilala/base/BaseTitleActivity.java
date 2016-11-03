package com.example.dllo.bibilala.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dllo.bibilala.R;


public abstract class BaseTitleActivity extends BaseActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_include_title);
        LinearLayout mLinearLayout = bindView(R.id.base_ll);
        View view = LayoutInflater.from(this).inflate(setLayout(), mLinearLayout, false);
        mLinearLayout.addView(view);
        mToolbar = (Toolbar) findViewById(R.id.base_tool);
        mToolbar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    protected Toolbar getToolbar() {
        return mToolbar;
    }
}
