package com.example.dllo.bibilala.live.view;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

public class LiveFragmentAdapter extends FragmentPagerAdapter {
    private List<LiveTabInfo> infos;

    public LiveFragmentAdapter(FragmentManager fm) {
        super(fm);
        infos = LiveTabInfo.getTabInfos();
    }

    @Override
    public Fragment getItem(int position) {
        return infos.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return infos == null ? 0 : infos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return infos.get(position).getTitle();
    }
}
