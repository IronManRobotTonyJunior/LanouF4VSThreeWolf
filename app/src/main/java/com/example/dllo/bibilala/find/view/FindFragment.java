package com.example.dllo.bibilala.find.view;

import android.content.Intent;
import android.support.v4.widget.NestedScrollView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.activity.login.DownLoadActivity;
import com.example.dllo.bibilala.activity.login.SignActivity;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.find.FindEntity;
import com.example.dllo.bibilala.find.presenter.FindPresenter;
import com.example.dllo.bibilala.search.searchdetail.view.SearchDetailActivity;
import com.example.dllo.bibilala.search.view.SearchActivity;
import com.example.dllo.bibilala.tool.DensityUtils;
import com.example.dllo.bibilala.url.UrlClass;
import com.zhy.view.flowlayout.FlowLayout;
import com.zhy.view.flowlayout.TagAdapter;
import com.zhy.view.flowlayout.TagFlowLayout;

public class FindFragment extends BaseFragment implements IFindView, View.OnClickListener {

    private FindPresenter mFindPresenter;
    private LinearLayout mLinearLayout;
    private NestedScrollView mChildNestedScrollView;
    private CheckBox mCbMore;
    private TagFlowLayout mFlowLayout;
    private TextView mTvSearch;
    private LayoutInflater mFrom;
    private TextView tvInterest,tvTopic,tvActivity,tvOriginal;

    @Override
    protected int setLayout() {
        return R.layout.fragment_find;
    }

    @Override
    protected void initView() {
        mFindPresenter = new FindPresenter(this);
        mLinearLayout = bindView(R.id.find_ll_main);
        mFrom = LayoutInflater.from(mContext);
        View headView = mFrom.inflate(R.layout.head_find_nested, null);
        mLinearLayout.addView(headView, 0);
        mCbMore = bindView(R.id.find_cb_more, headView);
        mChildNestedScrollView = bindView(R.id.find_head_nested, headView);
        mFlowLayout = bindView(R.id.find_flow, headView);
        mTvSearch = bindView(R.id.head_tv_search, headView);
        mTvSearch.setOnClickListener(this);
        mChildNestedScrollView.setNestedScrollingEnabled(false);
        tvInterest = bindView(R.id.find_item_interest);
        tvTopic = bindView(R.id.find_item_topic);
        tvActivity = bindView(R.id.find_item_activity);
        tvOriginal = bindView(R.id.find_item_rank_original);
    }

    @Override
    protected void initData() {
        mFindPresenter.startRequest(UrlClass.URL_FIND_LABEL, FindEntity.class);
        tvInterest.setOnClickListener(this);
        tvTopic.setOnClickListener(this);
        tvActivity.setOnClickListener(this);
        tvOriginal.setOnClickListener(this);
        mCbMore.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    mCbMore.setText("收起");
                    ViewGroup.LayoutParams params = mChildNestedScrollView.getLayoutParams();
                    params.height = DensityUtils.dp2px(mContext, 300f);
                    mChildNestedScrollView.setLayoutParams(params);
                    mChildNestedScrollView.setNestedScrollingEnabled(true);
                } else {
                    mCbMore.setText("查看更多");
                    ViewGroup.LayoutParams params = mChildNestedScrollView.getLayoutParams();
                    params.height = DensityUtils.dp2px(mContext, 100f);
                    mChildNestedScrollView.setLayoutParams(params);
                    mChildNestedScrollView.setNestedScrollingEnabled(false);
                    mChildNestedScrollView.smoothScrollTo(0, 0);
                }
            }
        });


    }

    @Override
    public void onResponse(FindEntity result) {
        mFlowLayout.setAdapter(new TagAdapter<FindEntity.ListBean>(result.getList()) {
            @Override
            public View getView(FlowLayout parent, int position, FindEntity.ListBean listBean) {
                final TextView tvTag = (TextView) mFrom.inflate(R.layout.find_tv_tag, mFlowLayout, false);
                tvTag.setText(listBean.getKeyword());
                tvTag.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getActivity(), SearchDetailActivity.class);
                        intent.putExtra("keyWord", tvTag.getText());
                        getActivity().startActivity(intent);
                    }
                });
                return tvTag;
            }
        });

    }



    @Override
    public void onError() {

    }

    @Override
    public void onClick(View v) {
        Intent intentTopic = new Intent(getActivity(), TopicActivity.class);
        switch (v.getId()) {
            case R.id.head_tv_search:
                Intent intentSearch = new Intent(getActivity(), SearchActivity.class);
                startActivity(intentSearch);
                break;
            case R.id.find_item_interest:
                Intent intent = new Intent(getActivity(), SignActivity.class);
                startActivity(intent);
                break;
            case R.id.find_item_topic:
                intentTopic.putExtra("topic",UrlClass.URL_FIND_TOPIC);
                intentTopic.putExtra("to","活动中心");
                startActivity(intentTopic);

                break;
            case R.id.find_item_activity:
                intentTopic.putExtra("topic",UrlClass.URL_ACTIVYTY);
                intentTopic.putExtra("to","话题中心");
                startActivity(intentTopic);
                break;
            case R.id.find_item_rank_original:
                Intent intentOriginal = new Intent(getActivity(), DownLoadActivity.class);
                startActivity(intentOriginal);
                break;
        }
    }
}
