package com.example.dllo.bibilala.zone;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;

public class ZoneFragment extends BaseFragment {

    private RecyclerView mRecyclerView;
    @Override
    protected int setLayout() {
        return R.layout.fragment_zone;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.zone_recycler);


    }

    @Override
    protected void initData() {
        GridLayoutManager manager = new GridLayoutManager(mContext, 3);
        ZoneAdapter adapter = new ZoneAdapter(mContext, R.layout.item_zone, ZoneInfo.getData());
        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(manager);
    }


}
