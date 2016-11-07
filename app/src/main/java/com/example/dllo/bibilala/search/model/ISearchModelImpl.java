package com.example.dllo.bibilala.search.model;


import com.example.dllo.bibilala.entity.search.term.SearchEntity;
import com.example.dllo.bibilala.http.HttpManager;
import com.example.dllo.bibilala.http.OnCompletedListener;

public class ISearchModelImpl implements ISearchModel {
    @Override
    public <T> void startURLRequest(String url, Class<T> clazz, OnCompletedListener listener) {
        HttpManager.getInstance().getRequest(url, clazz, listener);
    }

    @Override
    public <T> void insertSearchDB(T result) {

    }

    @Override
    public <T> void querySearchDB(OnCompletedListener<T> listener) {

    }


}
