package com.example.dllo.bibilala.search.searchdetail.view;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.example.dllo.bibilala.search.scan.ScanActivity;
import com.example.dllo.bibilala.search.searchdetail.presenter.SearchDetailPresent;
import com.example.dllo.bibilala.search.view.SearchActivity;
import com.example.dllo.bibilala.values.UrlClass;

public class SearchDetailActivity extends BaseActivity implements View.OnClickListener
        , ISearchDetailView<SearchDetailEntity> {
    private String title = null;
    private TextView mTv;
    private ViewPager mVp;
    private TabLayout mTb;
    private SearchActivityAdapter mAdapter;
    private SearchDetailPresent mPresent;


    @Override
    protected int setLayout() {
        return R.layout.activity_search_detail;
    }

    @Override
    protected void initView() {
        ImageButton scan = (ImageButton) findViewById(R.id.detail_scan);
        LinearLayout detailLinearLayout = (LinearLayout) findViewById(R.id.detail_ll);
        detailLinearLayout.setOnClickListener(this);
        mTb = (TabLayout) findViewById(R.id.search_detail_tab);
        mVp = (ViewPager) findViewById(R.id.search_detail_vp);
        mTv = (TextView) findViewById(R.id.text_search);
        ImageButton imgBack = (ImageButton) findViewById(R.id.search_detail_img_back);
        imgBack.setOnClickListener(this);
        scan.setOnClickListener(this);
        mPresent = new SearchDetailPresent(this);
        mAdapter = new SearchActivityAdapter(getSupportFragmentManager());
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
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
            case R.id.detail_scan:
                Intent intentScan = new Intent(SearchDetailActivity.this, ScanActivity.class);
                startActivity(intentScan);
                break;
            default:
                break;
        }
    }


    @Override
    public void onResponse(SearchDetailEntity result) {
        if (result.getCode() != -500) {
            mAdapter.setTitleBean(result.getData().getNav());
            mVp.setAdapter(mAdapter);
        }
        mTb.setupWithViewPager(mVp);
        mTb.setTabMode(TabLayout.MODE_SCROLLABLE);
    }

    @Override
    public void onError() {

    }

    @Override
    public void showAnimator() {

    }

    @Override
    public void dismissAnimator() {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mAdapter.setInfos(null);
    }
}
