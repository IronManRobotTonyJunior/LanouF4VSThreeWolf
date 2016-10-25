package com.example.dllo.bibilala.main;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
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
import com.example.dllo.bibilala.base.BaseActivity;

import java.util.Timer;
import java.util.TimerTask;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends BaseActivity implements View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {

    private Toolbar mToolbar;
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private MainAdapter mAdapter;
    private DrawerLayout mDrawerLayout;
    private boolean isExit;
    private AppBarLayout mAppbar;
    private int mAppbarHeight = 0;

    @Override
    protected int setLayout() {
        return R.layout.activity_main;
    }


    @Override
    protected void initView() {
        mDrawerLayout = bindView(R.id.activity_main_drawer);
        mToolbar = bindView(R.id.include_toolbar);
        mAppbar = bindView(R.id.app_bar);
        mTabLayout = bindView(R.id.include_tab);
        mViewPager = bindView(R.id.include_vp);
//        setSupportActionBar(mToolbar);
        View view = LayoutInflater.from(this).inflate(R.layout.drawer_toolbar, mToolbar, false);
        mToolbar.addView(view);
        mToolbar.inflateMenu(R.menu.menu_three_points);
        ImageView drawerImage = (ImageView) view.findViewById(R.id.drawer_toolbar_drawer);
        CircleImageView userIcon = (CircleImageView) view.findViewById(R.id.user_icon);

        TextView userName = (TextView) view.findViewById(R.id.user_name);
        drawerImage.setOnClickListener(this);
        userIcon.setOnClickListener(this);
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setVerticalScrollBarEnabled(false);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.colorWhite));
        mTabLayout.setTabTextColors(getResources().getColor(R.color.colorUnselectWhite), getResources().getColor(R.color.colorWhite));
        mViewPager.setCurrentItem(1);

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


//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//            mAppbar.setOnScrollChangeListener(new View.OnScrollChangeListener() {
//                @Override
//                public void onScrollChange(View v, int scrollX, int scrollY, int oldScrollX, int oldScrollY) {
//                    Log.d("MainActivity", "滑动");
//                    Log.d("MainActivity", "scrollX:" + scrollX);
//                    Log.d("MainActivity", "oldScrollX:" + oldScrollX);
//                    Log.d("MainActivity", "scrolly:" + scrollY);
//                    Log.d("MainActivity", "oldScrolly:" + oldScrollY);
//                    if (scrollY - oldScrollY > v.getHeight() / 2) {
//                        mAppbar.setScaleX(v.getHeight());
//                    } else {
//                        mAppbar.setScaleX(0);
//                    }
//
//                }
//            });
//            mAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
//                @Override
//                public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
//                    mAppbarHeight += verticalOffset;
//                }
//            });
//
//        } else {
//
//        }

    }


//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        getMenuInflater().inflate(R.menu.menu_three_points,menu);
//        return super.onCreateOptionsMenu(menu);
//    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.drawer_toolbar_drawer:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
            case R.id.user_icon:
                mDrawerLayout.openDrawer(GravityCompat.START);
                break;
        }

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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case R.id.ic_home:
                break;
            case R.id.nav_vip:
                break;
            case R.id.ic_file:
                break;
            case R.id.ic_star:
                break;
            case R.id.ic_history:
                break;
            case R.id.ic_people:
                break;
            case R.id.ic_account:
                break;
            case R.id.ic_color:
                break;
            case R.id.ic_shop:
                break;
            case R.id.ic_settings:
                break;
        }
        mDrawerLayout.closeDrawer(GravityCompat.START);
        return true;
    }
}