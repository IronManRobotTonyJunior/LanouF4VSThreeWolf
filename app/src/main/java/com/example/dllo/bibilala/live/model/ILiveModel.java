package com.example.dllo.bibilala.live.model;


import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.live.liveentity.LiveTypeEntity;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.LiveAllEntity;

public interface ILiveModel {
    <T> void startRequest(String urlStr, Class<T> clazz, OnCompletedListener<T> listener);

    void insertTypeIntoDB(LiveTypeEntity result);

    void insertAllIntoDB(LiveAllEntity result);

    void queryType(OnCompletedListener<LiveTypeEntity> listener);

    void queryAll(OnCompletedListener<LiveAllEntity> listener);

}
