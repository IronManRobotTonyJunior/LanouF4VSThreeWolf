package com.example.dllo.bibilala.live.presenter;


import com.example.dllo.bibilala.entity.liveentity.typeentity.AllTypeEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.entity.liveentity.livetypeentity.LiveTypeEntity;
import com.example.dllo.bibilala.entity.liveentity.liverecommendentity.LiveAllEntity;
import com.example.dllo.bibilala.mvp.model.IModel;
import com.example.dllo.bibilala.mvp.model.ModelImpl;
import com.example.dllo.bibilala.live.view.ILiveView;
import com.example.dllo.bibilala.mvp.presenter.BasePresenter;

import java.lang.ref.WeakReference;

public class LivePresenter extends BasePresenter<ILiveView> {
    private ILiveView mLiveView;
    private IModel mIModel;

    public LivePresenter(ILiveView iLiveView) {
        mIModel = new ModelImpl();
        attachView(iLiveView);
        if (isViewAttached()) {
            mLiveView = getView();
        }
    }

    public <T> void startRequest(String urlStr, Class<T> clazz) {
        mLiveView.showRefresh();
        mIModel.startRequest(urlStr, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                if (result instanceof LiveAllEntity) {
                    mLiveView.onAllResponse((LiveAllEntity) result);
                } else if (result instanceof LiveTypeEntity) {
                    mLiveView.onTypeResponse((LiveTypeEntity) result);
                }else if (result instanceof AllTypeEntity){
                    mLiveView.onAllType((AllTypeEntity) result);
                }
                mLiveView.dismissRefresh();
            }

            @Override
            public void onFailed() {
                mLiveView.dismissRefresh();
                mLiveView.onError();
            }
        });
    }
}
