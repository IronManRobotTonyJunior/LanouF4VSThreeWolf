package com.example.dllo.bibilala.recommend.activity.hotrecommend;

import android.support.v4.app.Fragment;

import com.example.dllo.bibilala.recommend.secondinterface.hotrecommendfragment.OriginalFragment;
import com.example.dllo.bibilala.recommend.secondinterface.hotrecommendfragment.PlayFragment;
import com.example.dllo.bibilala.recommend.secondinterface.hotrecommendfragment.TotalStationFragment;

import java.util.ArrayList;
import java.util.List;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 刘城羊 on 16/7/10.
 */
public class TabHotRecommend {
    private String mTitle;
    private Fragment mFragment;

    public TabHotRecommend(String mTitle, Fragment mFragment) {
        this.mTitle = mTitle;
        this.mFragment = mFragment;
    }

    public String getmTitle() {
        return mTitle;
    }

    public void setmTitle(String mTitle) {
        this.mTitle = mTitle;
    }

    public Fragment getmFragment() {
        return mFragment;
    }

    public void setmFragment(Fragment mFragment) {
        this.mFragment = mFragment;
    }

    public static List<TabHotRecommend> getHotRecommends(){
        List<TabHotRecommend>list =new ArrayList<>();
        list.add(new TabHotRecommend("原创",new OriginalFragment()));
        list.add(new TabHotRecommend("全站",new TotalStationFragment()));
        list.add(new TabHotRecommend("番剧",new PlayFragment()));
        return list;

    }
}
