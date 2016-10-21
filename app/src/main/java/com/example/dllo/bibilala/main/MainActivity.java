package com.example.dllo.bibilala.main;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.BangumiFragment;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.concern.ConcernFragment;
import com.example.dllo.bibilala.find.FindFragment;
import com.example.dllo.bibilala.live.LiveFragment;
import com.example.dllo.bibilala.recommend.RecommendFragment;
import com.example.dllo.bibilala.zone.ZoneFragment;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private CoordinatorLayout mCoordinatorLayout;
    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private List<String> mTitles;
    private List<Fragment> mFragments;
    private MainAdapter mAdapter;
    private boolean isExit;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        mCoordinatorLayout = bindView(R.id.main_coordinator);
        mToolbar = (Toolbar) mCoordinatorLayout.findViewById(R.id.include_toolbar);
        mTabLayout = (TabLayout) mCoordinatorLayout.findViewById(R.id.include_tab);
        mViewPager = (ViewPager) mCoordinatorLayout.findViewById(R.id.include_vp);
        View view = LayoutInflater.from(this).inflate(R.layout.drawer_toolbar, mToolbar, false);
        mToolbar.addView(view);
        ImageView drawerImage = (ImageView) view.findViewById(R.id.drawer_toolbar_drawer);
        CircleImageView userIcon = (CircleImageView) view.findViewById(R.id.user_icon);
        TextView userName = (TextView) view.findViewById(R.id.user_name);
        drawerImage.setOnClickListener(this);
        mToolbar.inflateMenu(R.menu.menu_three_points);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mTitles = new ArrayList<>();
        mFragments = new ArrayList<>();

        mTitles.add("直播");
        mTitles.add("推荐");
        mTitles.add("番剧");
        mTitles.add("分区");
        mTitles.add("关注");
        mTitles.add("发现");
        mFragments.add(new LiveFragment());
        mFragments.add(new RecommendFragment());
        mFragments.add(new BangumiFragment());
        mFragments.add(new ZoneFragment());
        mFragments.add(new ConcernFragment());
        mFragments.add(new FindFragment());
        mAdapter = new MainAdapter(getSupportFragmentManager(), mTitles, mFragments);
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(Color.parseColor("#FFFFFF"));
        mTabLayout.setTabTextColors(Color.parseColor("#FDC7D6"), Color.parseColor("#FFFFFF"));


        mToolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.menu_top_game:
                        Log.d("MainActivity", "menu_top_game");
                        break;
                    case R.id.menu_download:
                        Log.d("MainActivity", "menu_download");
                        break;
                    case R.id.menu_search:
                        Log.d("MainActivity", "menu_search");
                        break;
                    default:
                        break;

                }
                return false;
            }
        });

    }

    @Override
    public void onClick(View v) {

    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            exitBy2Click(); //调用双击退出函数
        }
        return false;

    }

    private void exitBy2Click() {
        Timer tExit = null;
        if (isExit == false) {
            isExit = true; // 准备退出
            Toast.makeText(this, "再按一次退出程序.武神", Toast.LENGTH_SHORT).show();
            tExit = new Timer();
            tExit.schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false; // 取消退出
                }
            }, 2000); // 如果2秒钟内没有按下返回键，则启动定时器取消掉刚才执行的任务

        } else {
            finish();
            System.exit(0);
        }
    }
}