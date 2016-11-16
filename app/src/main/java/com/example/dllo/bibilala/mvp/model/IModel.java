package com.example.dllo.bibilala.mvp.model;


import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.entity.live.livetype.LiveTypeEntity;
import com.example.dllo.bibilala.entity.live.liverecommend.LiveAllEntity;

public interface IModel {
    <T> void startRequest(String urlStr, Class<T> clazz, OnCompletedListener<T> listener);

    void insertTypeIntoDB(LiveTypeEntity result);

    void insertAllIntoDB(LiveAllEntity result);

    void queryType(OnCompletedListener<LiveTypeEntity> listener);

    void queryAll(OnCompletedListener<LiveAllEntity> listener);

}
