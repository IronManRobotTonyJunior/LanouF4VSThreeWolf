package com.example.dllo.bibilala.search.presenter;


import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;
import com.example.dllo.bibilala.entity.search.term.SearchEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.mvp.presenter.BasePresenter;
import com.example.dllo.bibilala.search.model.ISearchModel;
import com.example.dllo.bibilala.search.model.ISearchModelImpl;
import com.example.dllo.bibilala.search.view.ISearchView;

public class SearchPresenter extends BasePresenter<ISearchView> {
    private ISearchModel mISearchModel;

    public SearchPresenter(ISearchView iSearchView) {
        super(iSearchView);
        mISearchModel = new ISearchModelImpl();
    }


    public <T> void startRequest(String url, Class<T> clazz) {
        mISearchModel.startURLRequest(url, clazz, new OnCompletedListener<SearchEntity>() {
            @Override
            public void onCompleted(SearchEntity result) {
                ISearchView view = getView();
                if (view != null) {
                    view.onResponse(result);
                }
            }

            @Override
            public void onFailed() {
                ISearchView view = getView();
                if (view != null) {
                    view.error();
                }
            }
        });
    }

}
