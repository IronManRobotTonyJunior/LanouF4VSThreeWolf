package com.example.dllo.bibilala.search.searchdetail.view;


import android.content.Context;

import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

public class SearchFragmentAdapter extends CommonAdapter<SearchDetailEntity.DataBean.ItemsBean> {

    public SearchFragmentAdapter(Context context, int layoutId, List<SearchDetailEntity.DataBean.ItemsBean> datas) {
        super(context, layoutId, datas);
    }

    @Override
    protected void convert(ViewHolder viewHolder, SearchDetailEntity.DataBean.ItemsBean item, int position) {

    }
}
