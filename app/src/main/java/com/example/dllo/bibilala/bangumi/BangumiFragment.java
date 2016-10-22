package com.example.dllo.bibilala.bangumi;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.app.BiBiLaiLaiApp;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.BangUmiEntity;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.url.UrlClass;

public class BangumiFragment extends BaseFragment {
    private ViewPager mViewPager;
    private boolean flag = true;
    private boolean mm = true;
    private Handler mHandler;
    private BangumiPageAdapter mBangumiAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_bangumi;
    }

    @Override
    protected void initView() {

        mViewPager = bindView(R.id.bang_umi_fragment_viewpager);

    }

    @Override
    protected void initData() {
        mBangumiAdapter = new BangumiPageAdapter(BiBiLaiLaiApp.getContext());

        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
            @Override
            public void onResponse(BangUmiEntity response) {
                Log.d("BangumiFragment", UrlClass.URL_SOME_DRAMA);
                Log.d("BangumiFragment", "response:" + response);
                mBangumiAdapter.setEntity(response);
                mViewPager.setAdapter(mBangumiAdapter);

            }

            @Override
            public void onError() {
                Toast.makeText(mContext, "错误", Toast.LENGTH_SHORT).show();

            }
        });
        mBangumiAdapter.setViewPager(mViewPager);
        mHandler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message msg) {
                mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                return false;
            }
        });
        if (mm) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    while (flag) {
                        try {
                            Thread.sleep(6000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(0);
                    }

                }
            }).start();
            mm = false;
        }


    }
}
