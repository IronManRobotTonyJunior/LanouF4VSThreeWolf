package com.example.dllo.bibilala.base;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.example.dllo.bibilala.main.MainAdapter;
import com.example.dllo.bibilala.R;

import java.util.List;

public abstract class BaseTitleActivity extends BaseActivity {
    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_include_title);
        LinearLayout mLinearLayout = bindView(R.id.base_ll);
        View view = LayoutInflater.from(this).inflate(setLayout(), mLinearLayout, false);
        mLinearLayout.addView(view);
        mCoordinatorLayout = bindView(R.id.main_coordinator);
        mTabLayout = (TabLayout) findViewById(R.id.include_tab);
        mViewPager = (ViewPager) findViewById(R.id.include_vp);
        mToolbar = (Toolbar) findViewById(R.id.include_toolbar);
        mToolbar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
        mToolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    public void setTitle(String title) {
        mToolbar.setTitle(title);
    }

    public void setMenu(int resId) {
        mToolbar.inflateMenu(resId);
    }

}
