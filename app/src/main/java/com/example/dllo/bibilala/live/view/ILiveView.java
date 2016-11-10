package com.example.dllo.bibilala.live.view;


import com.example.dllo.bibilala.entity.liveentity.livetypeentity.LiveTypeEntity;
import com.example.dllo.bibilala.entity.liveentity.liverecommendentity.LiveAllEntity;
import com.example.dllo.bibilala.entity.liveentity.typeentity.AllTypeEntity;

public interface ILiveView {
    void showRefresh();

    void dismissRefresh();

    void onTypeResponse(LiveTypeEntity result);

    void onAllResponse(LiveAllEntity result);

    void onAllType(AllTypeEntity result);

    void onError();
}
