package com.example.dllo.bibilala.live.presenter;


import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.entity.live.livetype.LiveTypeEntity;
import com.example.dllo.bibilala.entity.live.liverecommend.LiveAllEntity;
import com.example.dllo.bibilala.mvp.model.IModel;
import com.example.dllo.bibilala.mvp.model.ModelImpl;
import com.example.dllo.bibilala.live.view.ILiveView;
import com.example.dllo.bibilala.mvp.presenter.BasePresenter;

public class LivePresenter extends BasePresenter<ILiveView> {
    private IModel mIModel;

    public LivePresenter(ILiveView iLiveView) {
        super(iLiveView);
        mIModel = new ModelImpl();
    }


    public <T> void startRequest(String urlStr, Class<T> clazz) {
        final ILiveView view = getView();
        if (view != null) {
            view.showRefresh();
            mIModel.startRequest(urlStr, clazz, new OnCompletedListener<T>() {
                @Override
                public void onCompleted(T result) {
                    if (result instanceof LiveAllEntity) {
                        view.onAllResponse((LiveAllEntity) result);
                    } else if (result instanceof LiveTypeEntity) {
                        view.onTypeResponse((LiveTypeEntity) result);
                    }
                    view.dismissRefresh();
                }

                @Override
                public void onFailed() {
                    view.dismissRefresh();
                    view.onError();
                }
            });
        }
    }
}
