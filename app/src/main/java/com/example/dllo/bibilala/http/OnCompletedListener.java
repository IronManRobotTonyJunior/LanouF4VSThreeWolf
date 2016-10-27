package com.example.dllo.bibilala.http;


public interface OnCompletedListener<T> {
    void onCompleted(T result);

    void onFailed();
}
