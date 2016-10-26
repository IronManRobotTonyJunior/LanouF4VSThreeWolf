package com.example.dllo.bibilala.bangumi;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.adapter.BangumAdapter;
import com.example.dllo.bibilala.bangumi.adapter.BangumChinaAdapter;
import com.example.dllo.bibilala.bangumi.adapter.BangumiPageAdapter;
import com.example.dllo.bibilala.bangumi.adapter.JulyToLoveAdapter;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.BangUmiEntity;
import com.example.dllo.bibilala.entity.BangUmiRecommendEntity;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.url.UrlClass;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;


public class BangumiFragment extends BaseFragment {
    private List<BangUmiRecommendEntity.ResultBean> mEntity;
    private RecyclerView mRecyclerView;
    private BangumAdapter adapter;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;


    private ViewPager mViewPager;
    private LinearLayout mLinearLayout;
    private boolean flag = true;
    private boolean mm = true;
    private Handler mHandler;
    private JulyToLoveAdapter mJulyToLoveAdapter;
    private BangumiPageAdapter mBangumiAdapter;
    private ImageView[] point;
    private int pointSize = 4;

    private GridView mGridView,mChinaGridView;
    private BangumChinaAdapter mBangumChinaAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_bangumi;
    }

    @Override
    protected void initView() {

        mRecyclerView = bindView(R.id.bang_umi_fragment_rv);

    }

    @Override
    protected void initData() {

        mEntity = new ArrayList<>();
        adapter = new BangumAdapter(mContext, R.layout.item_bangum_recommend, mEntity);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_RECOMMEND, BangUmiRecommendEntity.class, new SendGetRequest.OnResponseListener<BangUmiRecommendEntity>() {
            @Override
            public void onResponse(BangUmiRecommendEntity response) {
                List<BangUmiRecommendEntity.ResultBean> results = response.getResult();
                mEntity.addAll(results);
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onError() {

            }
        });



        onLunResponse();
        onChinaKutton();
        onJulyToLove();



//
    }

    private void onChinaKutton() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_bangum_fragment_china,null);
        mHeaderAndFooterWrapper.addHeaderView(view);
        mHeaderAndFooterWrapper.notifyDataSetChanged();
        mChinaGridView = (GridView) view.findViewById(R.id.item_bang_china_gv);
        mBangumChinaAdapter = new BangumChinaAdapter(mContext);
        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
            @Override
            public void onResponse(BangUmiEntity response) {
                Log.d("国产动画传输的数据", "response:" + response);
                mBangumChinaAdapter.setEntity(response);
                mChinaGridView.setAdapter(mBangumChinaAdapter);
            }

            @Override
            public void onError() {

            }
        });


    }

    private void onJulyToLove() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gl_july_fragment, null);
        mGridView = (GridView) view.findViewById(R.id.item_july_gl);
        mRecyclerView.setAdapter(mHeaderAndFooterWrapper);
        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
            @Override
            public void onResponse(BangUmiEntity response) {
                mJulyToLoveAdapter.setEntity(response);
                mGridView.setAdapter(mJulyToLoveAdapter);

            }

            @Override
            public void onError() {

            }
        });
        mHeaderAndFooterWrapper.addHeaderView(view);
//        mRecyclerView.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();
        mJulyToLoveAdapter = new JulyToLoveAdapter(mContext);



    }

    private void onLunResponse() {
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(adapter);
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_lun_fragment, null);
        mHeaderAndFooterWrapper.addHeaderView(view);
        mHeaderAndFooterWrapper.notifyDataSetChanged();
        mViewPager = (ViewPager) view.findViewById(R.id.bang_umi_fragment_viewpager);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.bang_umi_fragment_ll);
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
                imageView.setImageResource(R.mipmap.fennima);

            } else {
                imageView.setImageResource(R.mipmap.bai);
            }
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(40, 40);

            layoutParams.leftMargin = 2;
            layoutParams.rightMargin = 2;



            mLinearLayout.addView(imageView, layoutParams);
        }
        mBangumiAdapter.setViewPager(mViewPager);
        mBangumiAdapter.setPoint(point);
    }
}
