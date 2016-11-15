package com.example.dllo.bibilala.live.view;


import java.util.ArrayList;
import java.util.List;

class LiveTabInfo {
    private String title;
    private LiveDetailFragment mFragment;

    public LiveTabInfo(String title, LiveDetailFragment fragment) {
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

    public LiveDetailFragment getFragment() {
        return mFragment;
    }

    public void setFragment(LiveDetailFragment fragment) {
        mFragment = fragment;
    }

    public static List<LiveTabInfo> getTabInfos() {
        List<LiveTabInfo> infos = new ArrayList<>();
        infos.add(new LiveTabInfo("互动", LiveDetailFragment.newInstance()));
        infos.add(new LiveTabInfo("充能榜", LiveDetailFragment.newInstance()));
        infos.add(new LiveTabInfo("七日榜", LiveDetailFragment.newInstance()));
        infos.add(new LiveTabInfo("粉丝榜", LiveDetailFragment.newInstance()));
        return infos;
    }

}
