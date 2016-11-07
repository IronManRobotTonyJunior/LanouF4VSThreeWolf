package com.example.dllo.bibilala.search.searchdetail.view;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.example.dllo.bibilala.search.searchdetail.presenter.SearchDetailPresent;
import com.example.dllo.bibilala.search.view.ISearchView;
import com.example.dllo.bibilala.search.view.SearchActivity;
import com.example.dllo.bibilala.url.UrlClass;

public class SearchDetailActivity extends FragmentActivity implements View.OnClickListener
        , ISearchView<SearchDetailEntity> {
    private String title = null;
    private TextView mTv;
    private ViewPager mVp;
    private TabLayout mTb;
    private SearchActivityAdapter mAdapter;
    private SearchDetailPresent mPresent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_detail);
        initView();
        initData();
    }

    private void initView() {
        LinearLayout detailLinearLayout = (LinearLayout) findViewById(R.id.detail_ll);
        detailLinearLayout.setOnClickListener(this);
        mTb = (TabLayout) findViewById(R.id.search_detail_tab);
        mVp = (ViewPager) findViewById(R.id.search_detail_vp);
        mTv = (TextView) findViewById(R.id.text_search);
        ImageButton imgBack = (ImageButton) findViewById(R.id.search_detail_img_back);
        imgBack.setOnClickListener(this);
        mPresent = new SearchDetailPresent(this);
        mAdapter = new SearchActivityAdapter(getSupportFragmentManager());
        mVp.setAdapter(mAdapter);
    }

    private void initData() {
        Intent intent = getIntent();
        title = intent.getStringExtra("keyWord");
        mTv.setText(title);
        mPresent.startRequest(UrlClass.SEARCH_DETAIL(1, title, 0), SearchDetailEntity.class);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.search_detail_img_back:
                finish();
                break;
            case R.id.detail_ll:
                Intent intent = new Intent(SearchDetailActivity.this, SearchActivity.class);
                startActivity(intent);
                break;
        }
    }


    @Override
    public void onResponse(SearchDetailEntity result) {
        mAdapter.setTitleBean(result.getData().getNav());
        mTb.setupWithViewPager(mVp);
    }

    @Override
    public void error() {

    }
}
