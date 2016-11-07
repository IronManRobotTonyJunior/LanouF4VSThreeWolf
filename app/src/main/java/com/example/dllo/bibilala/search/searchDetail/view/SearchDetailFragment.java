package com.example.dllo.bibilala.search.searchdetail.view;


import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.SearchView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.example.dllo.bibilala.search.searchdetail.presenter.SearchDetailPresent;
import com.example.dllo.bibilala.search.view.ISearchView;
import com.example.dllo.bibilala.url.UrlClass;
import com.zhy.adapter.abslistview.CommonAdapter;

public class SearchDetailFragment extends BaseFragment implements ISearchView<SearchDetailEntity> {

    private SearchDetailPresent mPresent;
    private ListView mListView;

    public static SearchDetailFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        SearchDetailFragment fragment = new SearchDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_search_detail;
    }

    @Override
    protected void initView() {
        mPresent = new SearchDetailPresent(this);
        mListView = bindView(R.id.search_detail_lv);
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        String keyWord = intent.getStringExtra("keyWord");
        Log.d("SearchDetailFragment", keyWord);
//        mPresent.startRequest(UrlClass.SEARCH_DETAIL(1, keyWord, getArguments().getInt("type")), SearchDetailEntity.class);
    }

    @Override
    public void onResponse(SearchDetailEntity result) {
        Log.d("SearchDetailFragment", "result.getData():" + result.getData());

    }

    @Override
    public void error() {

    }
}
