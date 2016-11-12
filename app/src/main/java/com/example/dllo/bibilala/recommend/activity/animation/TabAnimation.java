package com.example.dllo.bibilala.recommend.activity.animation;

import android.support.v4.app.Fragment;

import com.example.dllo.bibilala.recommend.secondinterface.AMVFragment;
import com.example.dllo.bibilala.recommend.secondinterface.animationfragment.AnimationRecommendFragment;
import com.example.dllo.bibilala.recommend.secondinterface.animationfragment.ComprehensiveFragment;
import com.example.dllo.bibilala.recommend.secondinterface.animationfragment.ShortFilmFragment;
import com.example.dllo.bibilala.recommend.secondinterface.animationfragment.ThreeDFragment;

import java.util.ArrayList;
import java.util.List;

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
public class TabAnimation {
    private String mTitle;
    private Fragment mFragment;

    public TabAnimation(Fragment mFragment, String mTitle) {
        this.mFragment = mFragment;
        this.mTitle = mTitle;
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

    public static List<TabAnimation> getTabAnimation() {
        List<TabAnimation> infos = new ArrayList<>();
        infos.add(new TabAnimation(new AnimationRecommendFragment(), "推荐"));
        infos.add(new TabAnimation(new AMVFragment(), "MAD.AMV"));
        infos.add(new TabAnimation(new ThreeDFragment(), "MMD.3D"));
        infos.add(new TabAnimation(new ShortFilmFragment(), "短片.手书.配音"));
        infos.add(new TabAnimation(new ComprehensiveFragment(), "综合"));

        return infos;
    }

}
