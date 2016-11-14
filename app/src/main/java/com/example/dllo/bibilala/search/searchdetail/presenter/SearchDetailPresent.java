package com.example.dllo.bibilala.search.searchdetail.presenter;


import android.view.View;

import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.example.dllo.bibilala.entity.search.term.SearchEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.mvp.presenter.BasePresenter;
import com.example.dllo.bibilala.search.model.ISearchModel;
import com.example.dllo.bibilala.search.model.ISearchModelImpl;
import com.example.dllo.bibilala.search.searchdetail.view.ISearchDetailView;
import com.example.dllo.bibilala.search.view.ISearchView;

public class SearchDetailPresent extends BasePresenter<ISearchDetailView> {
    private ISearchModel mISearchModel;

    public SearchDetailPresent(ISearchDetailView iSearchDetailView) {
        super(iSearchDetailView);
        mISearchModel = new ISearchModelImpl();
    }


    public <T> void startRequest(String url, Class<T> clazz) {
        final ISearchDetailView view = getView();
        view.showAnimator();
        mISearchModel.startURLRequest(url, clazz, new OnCompletedListener<T>() {
            @Override
            public void onCompleted(T result) {
                if (view != null) {
                    getView().onResponse(result);
                }
                view.dismissAnimator();
            }

            @Override
            public void onFailed() {
                if (view != null) {
                    getView().onError();
                }
                view.dismissAnimator();
            }
        });
    }
}
