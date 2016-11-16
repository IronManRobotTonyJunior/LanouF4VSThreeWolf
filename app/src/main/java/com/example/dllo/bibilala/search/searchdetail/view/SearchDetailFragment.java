package com.example.dllo.bibilala.search.searchdetail.view;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.ListView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.example.dllo.bibilala.entity.search.detail.SearchTypeEntity;
import com.example.dllo.bibilala.search.searchdetail.presenter.SearchDetailPresent;
import com.example.dllo.bibilala.values.UrlClass;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

public class SearchDetailFragment<T> extends BaseFragment implements ISearchDetailView<T> {

    private SearchDetailPresent mPresent;
    private ListView mListView;
    private Context mContext;
    private int type;

    public static SearchDetailFragment newInstance(int type) {
        Bundle args = new Bundle();
        args.putInt("type", type);
        SearchDetailFragment fragment = new SearchDetailFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }

    @Override
    protected int setLayout() {
        return R.layout.fragment_search_detail;
    }

    @Override
    protected void initView() {
        mPresent = new SearchDetailPresent(this);
        mListView = bindView(R.id.search_detail_lv);
        // 获取是哪个界面
        type = getArguments().getInt("type");
    }

    @Override
    protected void initData() {
        Intent intent = getActivity().getIntent();
        String keyWord = intent.getStringExtra("keyWord");
        if (type == 0) {
            // 首页发出的接口请求 返回的SearchDetailEntity实体类
            mPresent.startRequest(UrlClass.SEARCH_DETAIL(1, keyWord, type), SearchDetailEntity.class);
        } else {
            // 其他分类的借口请求 返回的SearchTypeEntity实体类
            mPresent.startRequest(UrlClass.SEARCH_DETAIL(1, keyWord, type), SearchTypeEntity.class);
        }
    }


    @Override
    public void onResponse(T result) {
        if (result instanceof SearchDetailEntity) {
            Log.d("SearchDetailFragment", "首页");
            SearchDetailEntity entity = (SearchDetailEntity) result;
            try {
                Log.d("SearchDetailFragment", entity.getData().getItems().getArchive() + "");
                mListView.setAdapter(new CommonAdapter<SearchDetailEntity.DataBean.ItemsBean.ArchiveBean>(mContext, R.layout.item_search_detail_lv, entity.getData().getItems().getArchive()) {
                    @Override
                    protected void convert(ViewHolder viewHolder, SearchDetailEntity.DataBean.ItemsBean.ArchiveBean item, int position) {
                        Glide.with(mContext).load(item.getCover()).into((ImageView) viewHolder.getView(R.id.item_search_detail_img));
                        viewHolder.setText(R.id.item_search_detail_title, item.getTitle());
                        viewHolder.setText(R.id.item_search_detail_audience, item.getPlay() + "");
                        viewHolder.setText(R.id.item_search_detail_time, item.getDuration());
                        viewHolder.setText(R.id.item_search_detail_owner, item.getAuthor());
                        viewHolder.setText(R.id.item_search_detail_comment, item.getDanmaku() + "");
                    }
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
//           Log.d("SearchDetailFragment", ((SearchDetailEntity) result).getData().getItems().getSeason().get(0).getTitle());

        } else if (result instanceof SearchTypeEntity) {
            Log.d("SearchDetailFragment", "扉页");
        }

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


}
