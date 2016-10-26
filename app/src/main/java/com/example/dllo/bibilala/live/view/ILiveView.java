package com.example.dllo.bibilala.live.view;


import com.example.dllo.bibilala.live.liveentity.livetypeentity.LiveTypeEntity;
import com.example.dllo.bibilala.live.liveentity.liverecommendentity.LiveAllEntity;

public interface ILiveView {
    void showDialog();

    void dismissDialog();

    void onTypeResponse(LiveTypeEntity result);

    void onAllResponse(LiveAllEntity result);

    void onError();
}
