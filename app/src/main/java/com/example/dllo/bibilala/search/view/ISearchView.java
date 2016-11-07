package com.example.dllo.bibilala.search.view;


import com.example.dllo.bibilala.entity.search.term.SearchEntity;

public interface ISearchView<T> {
    void onResponse(T result);

    void error();
}
