package com.example.dllo.bibilala.main;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.example.dllo.bibilala.TabInfo;

import java.util.List;

public class MainAdapter extends FragmentPagerAdapter {
    private List<TabInfo> mTabInfos = TabInfo.getTabInfos();

    public MainAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        return mTabInfos.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mTabInfos == null ? 0 : mTabInfos.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabInfos.get(position).getTitle();
    }


}
