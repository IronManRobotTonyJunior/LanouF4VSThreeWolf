package com.example.dllo.bibilala;


import android.support.v4.app.Fragment;

import com.example.dllo.bibilala.bangumi.BangumiFragment;
import com.example.dllo.bibilala.concern.ConcernFragment;
import com.example.dllo.bibilala.find.FindFragment;
import com.example.dllo.bibilala.live.LiveFragment;
import com.example.dllo.bibilala.recommend.RecommendFragment;
import com.example.dllo.bibilala.zone.ZoneFragment;

import java.util.ArrayList;
import java.util.List;

public class TabInfo {
    private String mTitle;
    private Fragment mFragment;

    public TabInfo(Fragment fragment, String title) {
        mFragment = fragment;
        mTitle = title;
    }

    public String getTitle() {
        return mTitle;
    }

    public void setTitle(String title) {
        mTitle = title;
    }

    public Fragment getFragment() {
        return mFragment;
    }

    public void setFragment(Fragment fragment) {
        mFragment = fragment;
    }

    public static List<TabInfo> getTabInfos() {
        List<TabInfo> infos = new ArrayList<>();
        infos.add(new TabInfo(new LiveFragment(), "直播"));
        infos.add(new TabInfo(new RecommendFragment(), "推荐"));
        infos.add(new TabInfo(new BangumiFragment(), "番剧"));
        infos.add(new TabInfo(new ZoneFragment(), "分区"));
        infos.add(new TabInfo(new ConcernFragment(), "关注"));
        infos.add(new TabInfo(new FindFragment(), "发现"));
        return infos;
    }
}
