package com.example.dllo.bibilala.live.view;

import android.app.ProgressDialog;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.live.liveentity.LiveTypeEntity;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.LiveAllEntity;
import com.example.dllo.bibilala.live.presenter.LivePresenter;
import com.example.dllo.bibilala.url.UrlClass;

import java.util.List;

public class LiveFragment extends BaseFragment implements ILiveView {
    private ProgressDialog mProgressDialog;
    private LivePresenter mLivePresenter;
    private RecyclerView mRecyclerView;
    private List<LiveAllEntity> mLiveAllEntities;

    @Override
    protected int setLayout() {
        return R.layout.fragment_live;
    }

    @Override
    protected void initView() {
        mProgressDialog = createDialog();
        mRecyclerView = bindView(R.id.live_recycler);


    }


    @Override
    protected void initData() {
        mLivePresenter = new LivePresenter(this);
        mLivePresenter.startRequest(UrlClass.URL_LIVE, LiveAllEntity.class);
        mLivePresenter.startRequest(UrlClass.URL_RECOMMEND_ANCHOR, LiveTypeEntity.class);
        LiveAdapter adapter = new LiveAdapter(mContext,R.layout.item_live_recommand,mLiveAllEntities);

    }

    @Override
    public void showDialog() {
        mProgressDialog.show();
    }

    @Override
    public void dismissDialog() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onTypeResponse(LiveTypeEntity result) {

    }

    @Override
    public void onAllResponse(LiveAllEntity result) {

    }


    @Override
    public void onError() {

    }

    private ProgressDialog createDialog() {
        ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
        dialog.setTitle("数据加载中");
        dialog.setMessage("请稍后...");
        return dialog;
    }

}
