package com.example.dllo.bibilala.search.searchdetail.view;


import android.support.v4.app.Fragment;

import java.util.ArrayList;
import java.util.List;

public class TabInfo {
    private String title;
    private SearchDetailFragment mFragment;

    public TabInfo(String title, SearchDetailFragment fragment) {
        this.title = title;
        mFragment = fragment;

    }

    public TabInfo() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public SearchDetailFragment getFragment() {
        return mFragment;
    }

    public void setFragment(SearchDetailFragment fragment) {
        mFragment = fragment;
    }

    public static List<TabInfo> getTabInfos() {
        List<TabInfo> infos = new ArrayList<>();
        infos.add(new TabInfo("综合", SearchDetailFragment.newInstance(0)));
        infos.add(new TabInfo("番剧", SearchDetailFragment.newInstance(1)));
        infos.add(new TabInfo("UP主", SearchDetailFragment.newInstance(2)));
        infos.add(new TabInfo("影视", SearchDetailFragment.newInstance(3)));
        infos.add(new TabInfo("专题", SearchDetailFragment.newInstance(4)));
        return infos;
    }

}
