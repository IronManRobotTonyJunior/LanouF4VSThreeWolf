package com.example.dllo.bibilala.live.view;


import com.example.dllo.bibilala.entity.live.livetype.LiveTypeEntity;
import com.example.dllo.bibilala.entity.live.liverecommend.LiveAllEntity;
import com.example.dllo.bibilala.entity.live.type.AllTypeEntity;

public interface ILiveView {
    void showRefresh();

    void dismissRefresh();

    void onTypeResponse(LiveTypeEntity result);

    void onAllResponse(LiveAllEntity result);

    void onAllType(AllTypeEntity result);

    void onError();
}
