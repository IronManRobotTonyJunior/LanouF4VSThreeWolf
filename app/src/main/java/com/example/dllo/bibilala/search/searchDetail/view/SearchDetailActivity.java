package com.example.dllo.bibilala.search.searchdetail.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.dllo.bibilala.R;

public class SearchDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private String title = null;
    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);
        initView();
        initData();
    }

    private void initView() {
        TabLayout tb = (TabLayout) findViewById(R.id.search_detail_tab);
        ViewPager vp = (ViewPager) findViewById(R.id.search_detail_vp);
        mTv = (TextView) findViewById(R.id.text_search);
        ImageButton imgBack = (ImageButton) findViewById(R.id.search_detail_img_back);
        imgBack.setOnClickListener(this);
    }

    private void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("keyWord");
        mTv.setText(title);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_detail_img_back:
                finish();
                break;
        }
    }
}
