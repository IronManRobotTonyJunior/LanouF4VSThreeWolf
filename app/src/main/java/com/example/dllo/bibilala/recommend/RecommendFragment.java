package com.example.dllo.bibilala.recommend;

import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.GridView.GridViewForScrollView;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.http.SendGetRequest;

import com.example.dllo.bibilala.recommend.adapter.RecommedHitAdaper;
import com.example.dllo.bibilala.recommend.adapter.RecommedVideoAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommenLBdAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommendAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommendLiveAdapter;
import com.example.dllo.bibilala.recommendentity.AllBean;
import com.example.dllo.bibilala.recommendentity.LBBean;
import com.example.dllo.bibilala.url.UrlClass;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;


public class RecommendFragment extends BaseFragment implements View.OnClickListener {

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
    private GridViewForScrollView gridViewHotRecommended;
    private RecommedVideoAdapter recommedVideoAdapter;
    private TextView hot_recommend_refresh;
    private ImageView hot_recommend_refresh_img;
    private AnimationDrawable drawable;
    private GridViewForScrollView gridViewLive;
    private RecommendLiveAdapter recommendLiveAdapter;
    private TextView live_title;
    private TextView live_is_live;
    private GridViewForScrollView gridViewHit;
    private RecommedHitAdaper recommedHitAdapter;
    private TextView hit_title;


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
        //添加头布局 轮播图
        View viewLB = LayoutInflater.from(mContext).inflate(R.layout.recommend_lunbo, null);
        viewPager = (ViewPager) viewLB.findViewById(R.id.view_pager);
        viewPager.setPageMargin(getResources().getDimensionPixelSize(R.dimen.page_margin));
        recommenLBdAdapter = new RecommenLBdAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewLB);


        //添加热门推荐的头布局
        View viewHotRecommended = LayoutInflater.from(mContext).inflate(R.layout.hot_recommended, null);
        gridViewHotRecommended = (GridViewForScrollView) viewHotRecommended.findViewById(R.id.hot_recommend_grid);
        hot_recommend_refresh = (TextView) viewHotRecommended.findViewById(R.id.hot_recommend_refresh);
//        hot_recommend_refresh_img = (ImageView) viewHotRecommended.findViewById(R.id.hot_recommend_refresh_img);
//        hot_recommend_refresh_img.setBackgroundResource(R.anim.img_refresh);
//        drawable = (AnimationDrawable) hot_recommend_refresh_img.getBackground();
        recommedVideoAdapter = new RecommedVideoAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewHotRecommended);
        hot_recommend_refresh.setOnClickListener(this);


        //正在直播
        View viewLive = LayoutInflater.from(mContext).inflate(R.layout.recommend_live, null);
        gridViewLive = (GridViewForScrollView) viewLive.findViewById(R.id.live_grid);
        live_title = (TextView) viewLive.findViewById(R.id.live_title);
        live_is_live = (TextView) viewLive.findViewById(R.id.live_is_live);
        recommendLiveAdapter = new RecommendLiveAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewLive);


        //番剧推荐
        View viewHisPlay = LayoutInflater.from(mContext).inflate(R.layout.recommend_his_play, null);
        gridViewHit = (GridViewForScrollView) viewHisPlay.findViewById(R.id.hit_grid);
        hit_title = (TextView) viewHisPlay.findViewById(R.id.hit_title);
        recommedHitAdapter = new RecommedHitAdaper(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewHisPlay);


        //动画

        //音乐区

        //舞蹈区

        //话题

        //游戏区

        //鬼畜区

        //科技区


        //添加头布局 倒数第二行
        View view = LayoutInflater.from(mContext).inflate(R.layout.recommend_last, null);
        imageView = (ImageView) view.findViewById(R.id.last_topic_big_img);
        mHeaderAndFooterWrapper.addHeaderView(view);
        recyclerView.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();
        //
        initLB();
        initSleep();
        //
        initHotRecommended();
        //
        initLiveRecommend();
        //
//        initHitRecommend();

        //
        initPenultimate();
        //
        initParsing();


    }

//    private void initHitRecommend() {
//        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
//
//
//            @Override
//            public void onResponse(AllBean response) {
//                hit_title.setText(response.getResult().get(2).getHead().getTitle());
//               recommedHitAdapter.setAllBean( response);
//                gridViewHit.setAdapter(recommedHitAdapter);
//
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
//    }

    private void initLiveRecommend() {
        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
            @Override
            public void onResponse(AllBean response) {

                recommendLiveAdapter.setAllBean(response);
                gridViewLive.setAdapter(recommendLiveAdapter);

                live_title.setText(response.getResult().get(1).getHead().getTitle());
                live_is_live.setText("当前" + response.getResult().get(1).getHead().getCount() + "个直播");
            }

            @Override
            public void onError() {

            }
        });


    }

    private void initHotRecommended() {
        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
            @Override
            public void onResponse(AllBean response) {
                recommedVideoAdapter.setAllBean(response);
                gridViewHotRecommended.setAdapter(recommedVideoAdapter);
            }

            @Override
            public void onError() {

            }
        });

    }

    private void initSleep() {
        handler = new Handler(new Handler.Callback() {
            @Override
            public boolean handleMessage(Message message) {
                viewPager.setCurrentItem(viewPager.getCurrentItem() + 1);
                return false;
            }
        });
        if (flag) {
            new Thread(new Runnable() {
                @Override
                public void run() {

                    while (mFalg) {

                        try {
                            Thread.sleep(5000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        if (mFalg) {
                            handler.sendEmptyMessage(0);
                        }
                    }
                }
            }).start();
            flag = false;
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
                String url = response.getResult().get(19).getBody().get(0).getCover();
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
                List<AllBean.ResultBean.BodyBean> resultBeen = response.getResult().get(20).getBody();
                been.addAll(resultBeen);
                recommendAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError() {

            }
        });

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.hot_recommend_refresh:
                hot_recommend_refresh.setText("嘿咻嘿咻~");
//                drawable.start();

                break;
        }

    }
}