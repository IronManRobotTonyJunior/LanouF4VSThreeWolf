package com.example.dllo.bibilala.bangumi;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import com.android.volley.Response;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.app.BiBiLaiLaiApp;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.BangUmiEntity;
import com.example.dllo.bibilala.entity.BangUmiRecommendEntity;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.url.UrlClass;

import java.util.ArrayList;
import java.util.List;

import static android.R.id.list;
import static com.bumptech.glide.gifdecoder.GifHeaderParser.TAG;

public class BangumiFragment extends BaseFragment {
    private ViewPager mViewPager;
    private boolean flag = true;
    private boolean mm = true;
    private Handler mHandler;
    private BangumiPageAdapter mBangumiAdapter;
    private ImageView[] point;
    private int pointSize = 4;

    private LinearLayout mLinearLayout;
    private ListView mListView;
    private BangumRecommendAdapter adapter;
    private View lunView;


    @Override
    protected int setLayout() {
        return R.layout.fragment_bangumi;
    }

    @Override
    protected void initView() {

        mListView = bindView(R.id.bang_umi_fragment_lv);

    }

    @Override
    protected void initData() {
        lunView = LayoutInflater.from(mContext).inflate(R.layout.head_item,null);
        mListView.addHeaderView(lunView);
        mViewPager = (ViewPager) lunView.findViewById(R.id.bang_umi_fragment_viewpager);
        mLinearLayout = (LinearLayout)lunView.findViewById(R.id.bang_umi_fragment_ll);



        mBangumiAdapter = new BangumiPageAdapter(mContext);

        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
            @Override
            public void onResponse(BangUmiEntity response) {
                mBangumiAdapter.setEntity(response);
                mViewPager.setAdapter(mBangumiAdapter);


            }

            @Override
            public void onError() {
                Toast.makeText(mContext, "错误", Toast.LENGTH_SHORT).show();

            }
        });

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
                            Thread.sleep(3000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        mHandler.sendEmptyMessage(0);
                    }

                }
            }).start();
            mm = false;
        }

        point = new ImageView[pointSize];

        for (int i = 0; i < pointSize; i++) {
            ImageView imageView = new ImageView(mContext);

            point[i] = imageView;

            if (i == 0) {
                imageView.setImageResource(R.mipmap.ic_launcher);

            } else {
                imageView.setImageResource(R.mipmap.ic_yuan);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50);

            layoutParams.leftMargin = 20;
            layoutParams.rightMargin = 20;

            mLinearLayout.addView(imageView, layoutParams);
        }
        mBangumiAdapter.setViewPager(mViewPager);
        mBangumiAdapter.setPoint(point);


        adapter = new BangumRecommendAdapter(getContext());


        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_RECOMMEND, BangUmiRecommendEntity.class, new SendGetRequest.OnResponseListener<BangUmiRecommendEntity>() {
            @Override
            public void onResponse(BangUmiRecommendEntity response) {
                adapter.setEntity(response);
                mListView.setAdapter(adapter);
            }

            @Override
            public void onError() {


            }
        });
    }
}
