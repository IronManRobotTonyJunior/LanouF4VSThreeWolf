package com.example.dllo.bibilala.search.model;


import com.example.dllo.bibilala.entity.search.term.SearchEntity;
import com.example.dllo.bibilala.http.OnCompletedListener;

public interface ISearchModel {
    <T> void startURLRequest(String url, Class<T> clazz, OnCompletedListener listener);

    <T> void insertSearchDB(T result);

    <T> void querySearchDB(OnCompletedListener<T> listener);
}
