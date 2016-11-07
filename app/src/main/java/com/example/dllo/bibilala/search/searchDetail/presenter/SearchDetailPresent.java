package com.example.dllo.bibilala.search.searchdetail.presenter;


import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.example.dllo.bibilala.entity.search.term.SearchEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.mvp.presenter.BasePresenter;
import com.example.dllo.bibilala.search.model.ISearchModel;
import com.example.dllo.bibilala.search.model.ISearchModelImpl;
import com.example.dllo.bibilala.search.view.ISearchView;

public class SearchDetailPresent extends BasePresenter<ISearchView> {
    private ISearchModel mISearchModel;
    private ISearchView mISearchView;

    public SearchDetailPresent(ISearchView ISearchView) {
        mISearchModel = new ISearchModelImpl();
        attachView(ISearchView);
        if (isViewAttached()) {
            mISearchView = getView();
        }
    }
    public <T> void startRequest(String url, Class<T> clazz) {
        mISearchModel.startURLRequest(url, clazz, new OnCompletedListener<SearchDetailEntity>() {
            @Override
            public void onCompleted(SearchDetailEntity result) {
                mISearchView.onResponse(result);
            }

            @Override
            public void onFailed() {
                mISearchView.error();
            }
        });
    }
}
