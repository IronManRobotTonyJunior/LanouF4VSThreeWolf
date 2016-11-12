package com.example.dllo.bibilala.live.view;


import com.example.dllo.bibilala.search.searchdetail.view.SearchDetailFragment;
import java.util.ArrayList;
import java.util.List;

class LiveTabInfo {
    private String title;
    private SearchDetailFragment mFragment;

    public LiveTabInfo(String title, SearchDetailFragment fragment) {
        this.title = title;
        mFragment = fragment;

    }

    public LiveTabInfo() {
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

    public static List<LiveTabInfo> getTabInfos() {
        List<LiveTabInfo> infos = new ArrayList<>();
        infos.add(new LiveTabInfo("互动", SearchDetailFragment.newInstance(0)));
        infos.add(new LiveTabInfo("充能榜", SearchDetailFragment.newInstance(1)));
        infos.add(new LiveTabInfo("七日绑", SearchDetailFragment.newInstance(2)));
        infos.add(new LiveTabInfo("粉丝榜", SearchDetailFragment.newInstance(3)));
        return infos;
    }

}
