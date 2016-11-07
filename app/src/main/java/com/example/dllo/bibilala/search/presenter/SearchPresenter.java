package com.example.dllo.bibilala.search.presenter;


import com.example.dllo.bibilala.entity.search.term.SearchEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.search.model.ISearchModel;
import com.example.dllo.bibilala.search.model.ISearchModelImpl;
import com.example.dllo.bibilala.search.view.ISearchView;

public class SearchPresenter {
    private ISearchModel mISearchModel;
    private ISearchView mISearchView;

    public SearchPresenter(ISearchView ISearchView) {
        mISearchModel = new ISearchModelImpl();
        mISearchView = ISearchView;
    }

    public <T> void startRequest(String url, Class<T> clazz) {
        mISearchModel.startURLRequest(url, clazz, new OnCompletedListener<SearchEntity>() {
            @Override
            public void onCompleted(SearchEntity result) {
                mISearchView.onResponse(result);
            }

            @Override
            public void onFailed() {
                mISearchView.error();
            }
        });
    }

}
