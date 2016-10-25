package com.example.dllo.bibilala.live.model;


import com.example.dllo.bibilala.http.HttpManager;
import com.example.dllo.bibilala.http.OnCompletedListener;
import com.example.dllo.bibilala.live.liveentity.LiveTypeEntity;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.LiveAllEntity;

public class LiveModelImpl implements ILiveModel {


    @Override
    public <T> void startRequest(String urlStr, Class<T> clazz,OnCompletedListener<T> listener) {
        HttpManager.getInstance().getRequest(urlStr,clazz,listener);
    }

    @Override
    public void insertTypeIntoDB(LiveTypeEntity result) {

    }

    @Override
    public void insertAllIntoDB(LiveAllEntity result) {

    }

    @Override
    public void queryType(OnCompletedListener<LiveTypeEntity> listener) {

    }

    @Override
    public void queryAll(OnCompletedListener<LiveAllEntity> listener) {

    }
}
