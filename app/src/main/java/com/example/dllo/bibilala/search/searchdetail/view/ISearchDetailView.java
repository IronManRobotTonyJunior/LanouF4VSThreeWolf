package com.example.dllo.bibilala.search.searchdetail.view;


public interface ISearchDetailView<T> {
    void onResponse(T result);

    void onError();

    void showAnimator();

    void dismissAnimator();
}
