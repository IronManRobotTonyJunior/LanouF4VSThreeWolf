package com.example.dllo.bibilala.live.presenter;


import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.entity.liveentity.livetypeentity.LiveTypeEntity;
import com.example.dllo.bibilala.entity.liveentity.liverecommendentity.LiveAllEntity;
import com.example.dllo.bibilala.live.model.ILiveModel;
import com.example.dllo.bibilala.live.model.LiveModelImpl;
import com.example.dllo.bibilala.live.view.ILiveView;

public class LivePresenter {
    private ILiveView mILiveView;
    private ILiveModel mILiveModel;

    public LivePresenter(ILiveView iLiveView) {
        mILiveView = iLiveView;
        mILiveModel = new LiveModelImpl();

    }

    public <T> void startRequest(String urlStr, Class<T> clazz) {
        mILiveView.showDialog();
        mILiveModel.startRequest(urlStr, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                if (result instanceof LiveAllEntity) {
                    mILiveView.onAllResponse((LiveAllEntity) result);
                } else if (result instanceof LiveTypeEntity) {
                    mILiveView.onTypeResponse((LiveTypeEntity) result);
                }
                mILiveView.dismissDialog();
            }

            @Override
            public void onFailed() {
                mILiveView.dismissDialog();
                mILiveView.onError();
            }
        });
    }
}
