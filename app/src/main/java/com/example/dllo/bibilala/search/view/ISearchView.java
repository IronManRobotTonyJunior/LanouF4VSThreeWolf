package com.example.dllo.bibilala.search.view;


import com.example.dllo.bibilala.entity.search.term.SearchEntity;

public interface ISearchView {
    void onResponse(SearchEntity result);

    void error();
}
