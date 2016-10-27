package com.example.dllo.bibilala.live.view;

import android.app.ProgressDialog;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.MotionEvent;
import android.view.View;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.LiveAllEntity;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.RecommendDataEntity;
import com.example.dllo.bibilala.live.liveentity.livetypeentity.LiveTypeEntity;
import com.example.dllo.bibilala.live.presenter.LivePresenter;
import com.example.dllo.bibilala.url.UrlClass;

public class LiveFragment extends BaseFragment implements ILiveView {
    private ProgressDialog mProgressDialog;
    private LivePresenter mLivePresenter;
    private RecyclerView mRecyclerView;
    private LiveAllEntity mLiveAllEntities;
    private LiveTypeEntity mLiveTypeEntities;
    private LiveAdapter mAllAdapter;
    private static final int TYPE_BODY = 4;
    private GridLayoutManager mManager;
    private RecommendDataEntity mEntity;

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
        mAllAdapter = new LiveAdapter(mContext);
        mLivePresenter.startRequest(UrlClass.URL_RECOMMEND_ANCHOR, LiveAllEntity.class);
        mLivePresenter.startRequest(UrlClass.URL_LIVE, LiveTypeEntity.class);
        mRecyclerView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch (event.getAction()) {
                    case MotionEvent.ACTION_UP:

                        break;
                }
                return false;
            }
        });
        mManager = new GridLayoutManager(mContext, 2);
        mManager.setSpanSizeLookup(new GridLayoutManager.SpanSizeLookup() {
            @Override
            public int getSpanSize(int position) {
                if (position != 9) {
                    switch (mAllAdapter.getItemViewType(position)) {
                        case TYPE_BODY:
                            return 1;
                        default:
                            return 2;
                    }
                } else {
                    return 2;
                }
            }
        });

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
        mLiveTypeEntities = result;
        if (mLiveAllEntities != null) {
            mLiveTypeEntities.getData().getPartitions().add(0, mEntity);
            mAllAdapter.refreshTypeData(mLiveTypeEntities.getData());
            mRecyclerView.setAdapter(mAllAdapter);
            mRecyclerView.setLayoutManager(mManager);
        }


    }


    @Override
    public void onAllResponse(LiveAllEntity result) {
        mLiveAllEntities = result;
        mEntity = result.getData().getRecommend_data();
        mEntity.getLives().add(6, mEntity.getBanner_data().get(0));
        if (mLiveTypeEntities != null) {
            mLiveTypeEntities.getData().getPartitions().add(0, mEntity);
            mAllAdapter.refreshTypeData(mLiveTypeEntities.getData());
            mRecyclerView.setAdapter(mAllAdapter);
            mRecyclerView.setLayoutManager(mManager);
        }
    }


    @Override
    public void onError() {

    }

    private ProgressDialog createDialog() {
        ProgressDialog dialog = new ProgressDialog(mContext);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setTitle("数据加载中");
        dialog.setMessage("请稍后...");
        return dialog;
    }

}
