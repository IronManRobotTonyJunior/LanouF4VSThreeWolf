package com.example.dllo.bibilala.find.presenter;


import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.entity.find.FindEntity;
import com.example.dllo.bibilala.entity.find.TopicEntity;
import com.example.dllo.bibilala.find.view.IFindView;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.mvp.model.IModel;
import com.example.dllo.bibilala.mvp.model.ModelImpl;

public class FindPresenter {
    private IFindView mILiveView;
    private IModel mIModel;

    public FindPresenter(IFindView ILiveView) {
        mILiveView = ILiveView;
        mIModel = new ModelImpl();
    }

    public <T> void startRequest(String url, Class<T> clazz) {
        mIModel.startRequest(url, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                mILiveView.onResponse((FindEntity) result);
            }

            @Override
            public void onFailed() {
                mILiveView.onError();

            }
        });

    }
}
