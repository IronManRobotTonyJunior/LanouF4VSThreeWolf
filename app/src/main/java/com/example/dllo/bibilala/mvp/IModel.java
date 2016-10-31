package com.example.dllo.bibilala.mvp;


import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.entity.liveentity.livetypeentity.LiveTypeEntity;
import com.example.dllo.bibilala.entity.liveentity.liverecommendentity.LiveAllEntity;

public interface IModel {
    <T> void startRequest(String urlStr, Class<T> clazz, OnCompletedListener<T> listener);

    void insertTypeIntoDB(LiveTypeEntity result);

    void insertAllIntoDB(LiveAllEntity result);

    void queryType(OnCompletedListener<LiveTypeEntity> listener);

    void queryAll(OnCompletedListener<LiveAllEntity> listener);

}
