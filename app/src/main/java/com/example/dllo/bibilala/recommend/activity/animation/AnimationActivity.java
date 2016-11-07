package com.example.dllo.bibilala.recommend.activity.animation;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.base.BaseTitleActivity;

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
public class AnimationActivity extends BaseActivity {
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private AnimationAdapter animationAdapter;
    private Toolbar mToolbar;
    private ImageView bc_ic_ab_back_mtrl_am_alpha;


    @Override
    protected int setLayout() {
        return R.layout.activity_animation;
    }

    @Override
    protected void initView() {
        mTabLayout = (TabLayout) findViewById(R.id.include_tab);
        mViewPager = (ViewPager) findViewById(R.id.include_vp);
        mToolbar = (Toolbar) findViewById(R.id.include_toolbar);
        View view = LayoutInflater.from(this).inflate(R.layout.drawer_animation_toolbar,mToolbar,false);
        bc_ic_ab_back_mtrl_am_alpha = (ImageView) view.findViewById(R.id.bc_ic_ab_back_mtrl_am_alpha);
        mToolbar.addView(view);
        mToolbar.inflateMenu(R.menu.menu_two_points);



    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        animationAdapter = new AnimationAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(animationAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setTabMode(TabLayout.MODE_SCROLLABLE);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tabColor));
        mTabLayout.setTabTextColors(getResources().getColor(R.color.colorUnselectWhite), getResources().getColor(R.color.tabColor));

//        mToolbar.setNavigationIcon(R.mipmap.abc_ic_ab_back_mtrl_am_alpha);
        bc_ic_ab_back_mtrl_am_alpha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


}
