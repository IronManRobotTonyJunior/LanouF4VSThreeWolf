package com.example.dllo.bibilala.recommend;

import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.recommend.adapter.RecommenLBdAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommendAdapter;
import com.example.dllo.bibilala.recommendentity.AllBean;
import com.example.dllo.bibilala.recommendentity.LBBean;
import com.example.dllo.bibilala.url.UrlClass;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends BaseFragment {

    private List<AllBean.ResultBean.BodyBean> been;
    private RecommendAdapter recommendAdapter;
    private RecyclerView recyclerView;
    private HeaderAndFooterWrapper mHeaderAndFooterWrapper;
    private ImageView imageView;
    private RecommenLBdAdapter recommenLBdAdapter;
    private ViewPager viewPager;
    private boolean mFalg = true;
    private boolean flag = true;
    private Handler handler;


    @Override
    protected int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        recyclerView = bindView(R.id.recommend_recycle_view);


    }

    @Override
    protected void initData() {


        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

        been = new ArrayList<>();
        recommendAdapter = new RecommendAdapter(mContext, R.layout.recommend_last, been);
        recyclerView.setAdapter(recommendAdapter);


        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(recommendAdapter);
        //添加头布局
        View viewLB =LayoutInflater.from(mContext).inflate(R.layout.recommend_lunbo,null);
        viewPager = (ViewPager) viewLB.findViewById(R.id.view_pager);
        viewPager.setPageMargin(20);
        recommenLBdAdapter = new RecommenLBdAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewLB);




        //添加头布局
        View view = LayoutInflater.from(mContext).inflate(R.layout.recommend_last, null);
        imageView = (ImageView) view.findViewById(R.id.last_topic_big_img);
        mHeaderAndFooterWrapper.addHeaderView(view);
        recyclerView.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();





        initLB();
        initSleep();
        initPenultimate();
        initParsing();


    }

    private void initSleep() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() +1);
                return false;
            }
        });
        if (flag){
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        Thread.sleep(5000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                    if (mFalg){
                        handler.sendEmptyMessage(0);
                    }
                }
            }).start();
            flag =false;
        }











    }

    private void initLB() {
        SendGetRequest.sendGetRequest(UrlClass.URL_GHOST_OU, LBBean.class, new SendGetRequest.OnResponseListener<LBBean>() {
            @Override
            public void onResponse(LBBean response) {
                recommenLBdAdapter.setLbBean(response);
                viewPager.setAdapter(recommenLBdAdapter);

            }

            @Override
            public void onError() {

            }
        });



    }

    private void initPenultimate() {
        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
            @Override
            public void onResponse(AllBean response) {
                String url = response.getResult().get(20).getBody().get(0).getCover();
                Log.d("111", url);

                Glide.with(mContext).load(url).into(imageView);


            }

            @Override
            public void onError() {

            }
        });

    }

    private void initParsing() {
        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
            @Override
            public void onResponse(AllBean response) {
                List<AllBean.ResultBean.BodyBean> resultBeen = response.getResult().get(21).getBody();
                been.addAll(resultBeen);
                recommendAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError() {

            }
        });


    }

}