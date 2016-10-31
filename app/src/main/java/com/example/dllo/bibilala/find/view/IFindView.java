package com.example.dllo.bibilala.find.view;


import com.example.dllo.bibilala.entity.find.FindEntity;

public interface IFindView {
    void onResponse(FindEntity result);

    void onError();
}
