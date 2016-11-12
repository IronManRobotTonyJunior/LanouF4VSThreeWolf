package com.example.dllo.bibilala.live.view;


import android.os.Bundle;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;

public class LiveDetailFragment extends BaseFragment {


    public static LiveDetailFragment newInstance() {
        Bundle args = new Bundle();
        LiveDetailFragment fragment = new LiveDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    protected int setLayout() {
        return R.layout.live_detail_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    protected void initData() {

    }
}
