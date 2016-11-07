package com.example.dllo.bibilala.search.searchdetail.view;


import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.util.Log;

import com.example.dllo.bibilala.entity.liveentity.liverecommendentity.DataEntity;
import com.example.dllo.bibilala.entity.search.detail.SearchDetailEntity;

import java.util.List;

public class SearchActivityAdapter extends FragmentPagerAdapter {

    private List<SearchDetailEntity.DataBean.NavBean> mBean;
    private final List<TabInfo> mInfos;

    public SearchActivityAdapter(FragmentManager fm) {
        super(fm);
        mInfos = TabInfo.getTabInfos();
    }

    public List<SearchDetailEntity.DataBean.NavBean> getTitleBean() {
        return mBean;
    }

    public void setTitleBean(List<SearchDetailEntity.DataBean.NavBean> bean) {
        mBean = bean;
    }

    @Override
    public Fragment getItem(int position) {
        return mInfos.get(position).getFragment();
    }

    @Override
    public int getCount() {
        return mInfos == null ? 0 : mInfos.size();

    }

    @Override
    public CharSequence getPageTitle(int position) {
        if (position != 0 && mBean.get(position - 1).getTotal() != 0) {
            int total = mBean.get(position - 1).getTotal();
            if (total > 99) {
                return mInfos.get(position).getTitle() + "(99+)";
            } else {
                return mInfos.get(position).getTitle() + "(" + total + ")";
            }
        }

        return mInfos.get(position).getTitle();
    }
}
