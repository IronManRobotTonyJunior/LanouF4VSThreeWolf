package com.example.dllo.bibilala.main;

import android.app.UiModeManager;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.NavigationMenuView;
import android.support.design.widget.AppBarLayout;
import android.support.design.widget.NavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatDelegate;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.tool.SharedPreferencesTool;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

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
    private UiModeManager mUiModeManager = null;
    private boolean isNight = false;
    private NavigationView mNavigationView;
    private CheckBox mHeadDayNight;

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
        View view = LayoutInflater.from(this).inflate(R.layout.drawer_toolbar, mToolbar, false);
        mToolbar.addView(view);
        mToolbar.inflateMenu(R.menu.menu_three_points);
        // ToolBar 的三个图标
        ImageView drawerImage = (ImageView) view.findViewById(R.id.drawer_toolbar_drawer);
        CircleImageView userIcon = (CircleImageView) view.findViewById(R.id.user_icon);
        TextView userName = (TextView) view.findViewById(R.id.user_name);
        mNavigationView = (NavigationView) findViewById(R.id.nav_view);
        drawerImage.setOnClickListener(this);
        userIcon.setOnClickListener(this);
        // NavigationView 的Head
        View viewHead = mNavigationView.getHeaderView(0);
        mHeadDayNight = (CheckBox) viewHead.findViewById(R.id.drawer_check_night);
        CircleImageView userHeadIcon = (CircleImageView) viewHead.findViewById(R.id.drawer_user_icon);
        TextView userHeadName = (TextView) viewHead.findViewById(R.id.drawer_user_name);
        TextView userHeadCoin = (TextView) viewHead.findViewById(R.id.drawer_coin);
        userHeadIcon.setOnClickListener(this);
        userHeadName.setOnClickListener(this);
        mHeadDayNight.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    SharedPreferencesTool.setEditor(true);
                } else {
                    getDelegate().setLocalNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    SharedPreferencesTool.setEditor(false);
                }
            }
        });

        mNavigationView.setNavigationItemSelectedListener(this);
        NavigationMenuView menuView = (NavigationMenuView) mNavigationView.getChildAt(0);
        menuView.setVerticalScrollBarEnabled(false);
        // 不好使的夜间模式
//        mUiModeManager = (UiModeManager) getSystemService(Context.UI_MODE_SERVICE);
//        mUiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
    }

    private void initCheckBox() {
        isNight = SharedPreferencesTool.getIsNight(this);
        mHeadDayNight.setChecked(isNight);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mAdapter = new MainAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mAdapter);
        mTabLayout.setupWithViewPager(mViewPager);
        mTabLayout.setSelectedTabIndicatorColor(getResources().getColor(R.color.tabColor));
        mTabLayout.setTabTextColors(getResources().getColor(R.color.colorUnselectWhite), getResources().getColor(R.color.tabColor));
        mViewPager.setCurrentItem(1);
        initCheckBox();

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


        mAppbar.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() {
            @Override
            public void onOffsetChanged(AppBarLayout appBarLayout, int verticalOffset) {
            }
        });

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
        if (mDrawerLayout.isDrawerOpen(mNavigationView)) {
            mDrawerLayout.closeDrawers();
        } else {
            Timer tExit = null;
            if (isExit == false) {
                isExit = true; // 准备退出
                Toast.makeText(this, "再按一次退出哔哩哔哩动画>.<", Toast.LENGTH_SHORT).show();
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

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        Log.d("MainActivity", "id:" + id);
        switch (id) {
            case R.id.drawer_check_night:
                Toast.makeText(this, "夜间模式", Toast.LENGTH_SHORT).show();
                mUiModeManager.setNightMode(UiModeManager.MODE_NIGHT_NO);
                mUiModeManager.setNightMode(UiModeManager.MODE_NIGHT_YES);
                break;
            case R.id.drawer_user_icon:
                break;
            case R.id.ic_home:
                break;
            case R.id.nav_vip:
                break;
            case R.id.ic_file:
                break;
            case R.id.ic_star:
                Log.d("MainActivity", "进");
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

    @Override
    protected void onResume() {
        super.onResume();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceiveMessage(Integer msg) {
//        if (-mAppbarHeight > 50) {
//            mAppbar.scrollTo(0, 98);
//        } else {
//            mAppbar.scrollTo(0, 98);
//        }
        Log.d("MainActivity", "收到通知");
    }
}