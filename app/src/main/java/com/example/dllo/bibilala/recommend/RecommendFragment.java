package com.example.dllo.bibilala.recommend;

import android.content.Intent;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.recommendentity.AllBean;
import com.example.dllo.bibilala.entity.recommendentity.LBBean;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.recommend.activity.animation.AnimationActivity;
import com.example.dllo.bibilala.recommend.activity.GridLiveActivity;
import com.example.dllo.bibilala.recommend.adapter.ActivityAdapter;
import com.example.dllo.bibilala.recommend.adapter.AdvertAdapter;
import com.example.dllo.bibilala.recommend.adapter.AnimationAdapter;
import com.example.dllo.bibilala.recommend.adapter.EntertainmentAdapter;
import com.example.dllo.bibilala.recommend.adapter.FashionAdapter;
import com.example.dllo.bibilala.recommend.adapter.GameAdapter;
import com.example.dllo.bibilala.recommend.adapter.GhostAdapter;
import com.example.dllo.bibilala.recommend.adapter.LifeAdapter;
import com.example.dllo.bibilala.recommend.adapter.MovieAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommedDancingAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommedHitAdaper;
import com.example.dllo.bibilala.recommend.adapter.RecommedVideoAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommenLBdAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommendAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommendLiveAdapter;
import com.example.dllo.bibilala.recommend.adapter.RecommendMusicAdapter;
import com.example.dllo.bibilala.recommend.adapter.ScienceAdapter;
import com.example.dllo.bibilala.recommend.adapter.TVSeriesAdapter;
import com.example.dllo.bibilala.url.UrlClass;
import com.zhy.adapter.recyclerview.wrapper.HeaderAndFooterWrapper;

import java.util.ArrayList;
import java.util.List;

;


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
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewHotRecommended;
    private RecommedVideoAdapter recommedVideoAdapter;
    private TextView hot_recommend_refresh;
    private ImageView hot_recommend_refresh_img;
    private AnimationDrawable drawable;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewLive;
    private RecommendLiveAdapter recommendLiveAdapter;
    private TextView live_title;
    private TextView live_is_live;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewHit;
    private RecommedHitAdaper recommedHitAdapter;
    private TextView hit_title;
    private ImageView imageViewTopicThree;
    private TextView last_topic_big_text;
    private RecommendMusicAdapter recommendMusicAdapter;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewMusic;
    private TextView recommend_music_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewDancing;
    private TextView recommend_drancing_title;
    private RecommedDancingAdapter dancingAdapter;
    private ImageView imageViewFour;
    private TextView recommend_game_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewGame;
    private GameAdapter gameAdapter;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewGhost;
    private TextView recommend_ghost_title;
    private GhostAdapter ghostAdapter;
    private ImageView five_topic_big_img;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewScience;
    private TextView recommend_sclence_title;
    private ScienceAdapter scienceAdapter;
    private ImageView imageViewSix;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewActivity;
    private TextView recommend_activity_title;
    private ActivityAdapter activityAdapter;
    private TextView recommend_life_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewLife;
    private LifeAdapter lifeAdapter;
    private TextView recommend_fashion_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewFashion;
    private FashionAdapter fashionAdapter;
    private TextView recommend_advert_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewadvert;
    private TextView recommend_animation_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewAnimation;
    private AnimationAdapter animationAdapter;
    private AdvertAdapter advertAdapter;
    private TextView recommend_entertain_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewEntertain;
    private EntertainmentAdapter entertainmentAdapter;
    private TextView recommend_tv_series_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewTV;
    private TVSeriesAdapter tvSeriesAdapter;
    private TextView recommend_movie_title;
    private com.example.dllo.bibilala.gridview.GridViewForScrollView gridViewMovie;
    private MovieAdapter movieAdapter;
    private RelativeLayout animation_title_recycler;


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
        //回到最上层
        recyclerView.smoothScrollBy(0,0);


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
        gridViewHotRecommended = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewHotRecommended.findViewById(R.id.hot_recommend_grid);
        hot_recommend_refresh = (TextView) viewHotRecommended.findViewById(R.id.hot_recommend_refresh);
//        hot_recommend_refresh_img = (ImageView) viewHotRecommended.findViewById(R.id.hot_recommend_refresh_img);
//        hot_recommend_refresh_img.setBackgroundResource(R.anim.img_refresh);
//        drawable = (AnimationDrawable) hot_recommend_refresh_img.getBackground();
        recommedVideoAdapter = new RecommedVideoAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewHotRecommended);
        hot_recommend_refresh.setOnClickListener(this);


        //正在直播
        View viewLive = LayoutInflater.from(mContext).inflate(R.layout.recommend_live, null);
        gridViewLive = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewLive.findViewById(R.id.live_grid);
        live_title = (TextView) viewLive.findViewById(R.id.live_title);
        live_is_live = (TextView) viewLive.findViewById(R.id.live_is_live);
        recommendLiveAdapter = new RecommendLiveAdapter(mContext);
        gridViewLive.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intentGridLive =new Intent(RecommendFragment.this.getActivity(),GridLiveActivity.class);
//                LiveInterfaceBean.DataBean bean = (LiveInterfaceBean.DataBean) adapterView.getItemAtPosition(i);
//                int roomId =bean.getRoom_id();
//                intentGridLive.putExtra("roomId",roomId);
//                String urlLive ="http://live.bilibili.com/AppRoom/index?_device=android&_hwid=ccbb856c97ccb8d2&appkey=1d8b6e7d45233436&build=427000&buld=427000&jumpFrom=27003&mobi_app=android&platform=android&room_id=" +roomId + "&scale=xxhdpi&sign=c850c2099871a5d89e1cda3ee69609aa";
//                intentGridLive.putExtra("urlLive",urlLive);
                startActivity(intentGridLive);
































            }
        });
        mHeaderAndFooterWrapper.addHeaderView(viewLive);


        //番剧推荐
        View viewHisPlay = LayoutInflater.from(mContext).inflate(R.layout.recommend_his_play, null);
        gridViewHit = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewHisPlay.findViewById(R.id.hit_grid);
        hit_title = (TextView) viewHisPlay.findViewById(R.id.hit_title);
        recommedHitAdapter = new RecommedHitAdaper(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewHisPlay);


        //动画
        View viewAnimation = LayoutInflater.from(mContext).inflate(R.layout.recommend_animation, null);
        recommend_animation_title = (TextView) viewAnimation.findViewById(R.id.recommend_animation_title);
        animation_title_recycler = (RelativeLayout) viewAnimation.findViewById(R.id.live_title_recycler);
        gridViewAnimation = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewAnimation.findViewById(R.id.animation_grid);
        animationAdapter = new AnimationAdapter(mContext);
        animation_title_recycler.setOnClickListener(this);
        mHeaderAndFooterWrapper.addHeaderView(viewAnimation);


        //话题
        View viewTopicThree = LayoutInflater.from(mContext).inflate(R.layout.recommend_topic_last, null);
        imageViewTopicThree = (ImageView) viewTopicThree.findViewById(R.id.last_topic_big_img);
        last_topic_big_text = (TextView) viewTopicThree.findViewById(R.id.last_topic_big_text);
        mHeaderAndFooterWrapper.addHeaderView(viewTopicThree);
        recyclerView.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();


        //音乐区
        View viewMusic = LayoutInflater.from(mContext).inflate(R.layout.recommend_music, null);
        gridViewMusic = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewMusic.findViewById(R.id.music_grid);
        recommend_music_title = (TextView) viewMusic.findViewById(R.id.recommend_music_title);
        recommendMusicAdapter = new RecommendMusicAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewMusic);

        //舞蹈区
        View viewDancing = LayoutInflater.from(mContext).inflate(R.layout.recommend_dancing, null);
        gridViewDancing = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewDancing.findViewById(R.id.dancing_grid);
        recommend_drancing_title = (TextView) viewDancing.findViewById(R.id.recommend_drancing_title);
        dancingAdapter = new RecommedDancingAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewDancing);

        //话题
//        View viewTopicFour = LayoutInflater.from(mContext).inflate(R.layout.recommend_last, null);
//        imageViewFour = (ImageView) viewTopicFour.findViewById(R.id.last_topic_big_img);
//        mHeaderAndFooterWrapper.addHeaderView(viewTopicFour);
//        recyclerView.setAdapter(mHeaderAndFooterWrapper);
//        mHeaderAndFooterWrapper.notifyDataSetChanged();

        //游戏区
        View viewGame = LayoutInflater.from(mContext).inflate(R.layout.recommend_game, null);
        recommend_game_title = (TextView) viewGame.findViewById(R.id.recommend_game_title);
        gridViewGame = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewGame.findViewById(R.id.game_grid);
        gameAdapter = new GameAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewGame);

        //鬼畜区
        View viewGhostLivestock = LayoutInflater.from(mContext).inflate(R.layout.recommend_ghost, null);
        gridViewGhost = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewGhostLivestock.findViewById(R.id.ghost_grid);
        recommend_ghost_title = (TextView) viewGhostLivestock.findViewById(R.id.recommend_ghost_title);
        ghostAdapter = new GhostAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewGhostLivestock);


        //
        View viewTopicFive = LayoutInflater.from(mContext).inflate(R.layout.recommend_topic_five, null);
        five_topic_big_img = (ImageView) viewTopicFive.findViewById(R.id.five_topic_big_img);
        mHeaderAndFooterWrapper.addHeaderView(viewTopicFive);
        recyclerView.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();


        //科技区
        View viewScience = LayoutInflater.from(mContext).inflate(R.layout.recommend_science, null);
        gridViewScience = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewScience.findViewById(R.id.sclence_grid);
        recommend_sclence_title = (TextView) viewScience.findViewById(R.id.recommend_sclence_title);
        scienceAdapter = new ScienceAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewScience);

        //话题
        View viewSix = LayoutInflater.from(mContext).inflate(R.layout.recommend_last, null);
        imageViewSix = (ImageView) viewSix.findViewById(R.id.last_topic_big_img);
        mHeaderAndFooterWrapper.addHeaderView(viewSix);
        recyclerView.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();

        //活动12
        View viewActivity = LayoutInflater.from(mContext).inflate(R.layout.recommend_activity, null);
        gridViewActivity = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewActivity.findViewById(R.id.actviity_grid);
        recommend_activity_title = (TextView) viewActivity.findViewById(R.id.recommend_activity_title);
        mHeaderAndFooterWrapper.addHeaderView(viewActivity);
        activityAdapter = new ActivityAdapter(mContext);

        //生活13
        View viewLife = LayoutInflater.from(mContext).inflate(R.layout.recommend_life, null);
        recommend_life_title = (TextView) viewLife.findViewById(R.id.recommend_life_title);
        gridViewLife = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewLife.findViewById(R.id.life_grid);
        lifeAdapter = new LifeAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewLife);


        //时尚14
        View viewFashion = LayoutInflater.from(mContext).inflate(R.layout.recommend_fashion, null);
        recommend_fashion_title = (TextView) viewFashion.findViewById(R.id.recommend_fashion_title);
        gridViewFashion = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewFashion.findViewById(R.id.fashion_grid);
        fashionAdapter = new FashionAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewFashion);


        //广告15
        View viewAdvertising = LayoutInflater.from(mContext).inflate(R.layout.recommend_advert, null);
        recommend_advert_title = (TextView) viewAdvertising.findViewById(R.id.recommend_advert_title);
        gridViewadvert = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewAdvertising.findViewById(R.id.advert_grid);
        advertAdapter = new AdvertAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewAdvertising);


        //娱乐16
        View viewEntertainment = LayoutInflater.from(mContext).inflate(R.layout.recommend_entertain, null);
        recommend_entertain_title = (TextView) viewEntertainment.findViewById(R.id.recommend_entertain_title);
        gridViewEntertain = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewEntertainment.findViewById(R.id.entertain_grid);
        entertainmentAdapter = new EntertainmentAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewEntertainment);


        //电视剧17
        View viewTVSeries = LayoutInflater.from(mContext).inflate(R.layout.recommend_tv_series, null);
        recommend_tv_series_title = (TextView) viewTVSeries.findViewById(R.id.recommend_tv_series_title);
        gridViewTV = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewTVSeries.findViewById(R.id.tv_series_grid);
        tvSeriesAdapter = new TVSeriesAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewTVSeries);


        //电影18
        View viewMovie = LayoutInflater.from(mContext).inflate(R.layout.recommend_movie, null);
        recommend_movie_title = (TextView) viewMovie.findViewById(R.id.recommend_movie_title);
        gridViewMovie = (com.example.dllo.bibilala.gridview.GridViewForScrollView) viewMovie.findViewById(R.id.movie_grid);
        movieAdapter = new MovieAdapter(mContext);
        mHeaderAndFooterWrapper.addHeaderView(viewMovie);


        //添加头布局 倒数第二行19
        View viewTopicTwo = LayoutInflater.from(mContext).inflate(R.layout.recommend_last, null);
        imageView = (ImageView) viewTopicTwo.findViewById(R.id.last_topic_big_img);
        mHeaderAndFooterWrapper.addHeaderView(viewTopicTwo);
        recyclerView.setAdapter(mHeaderAndFooterWrapper);
        mHeaderAndFooterWrapper.notifyDataSetChanged();
        //5
        initLB();
        initSleep();
        //
        initRecommended();
        //
        initParsing();

    }


    private void initRecommended() {
        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
            @Override
            public void onResponse(AllBean response) {

                //解析
                // 热门
                recommedVideoAdapter.setAllBean(response);
                gridViewHotRecommended.setAdapter(recommedVideoAdapter);

                //直播
                recommendLiveAdapter.setAllBean(response);
                gridViewLive.setAdapter(recommendLiveAdapter);
                live_title.setText(response.getResult().get(1).getHead().getTitle());
                live_is_live.setText("当前" + response.getResult().get(1).getHead().getCount() + "个直播");

                //番剧
                hit_title.setText(response.getResult().get(2).getHead().getTitle());
                recommedHitAdapter.setAllBean(response);
                gridViewHit.setAdapter(recommedHitAdapter);


                //话题
                String urlTopicThree = response.getResult().get(3).getBody().get(0).getCover();
                Glide.with(mContext).load(urlTopicThree).into(imageViewTopicThree);
                last_topic_big_text.setText(response.getResult().get(3).getBody().get(0).getTitle());


                //动画
                recommend_animation_title.setText(response.getResult().get(4).getHead().getTitle());
                animationAdapter.setAllBean(response);
                gridViewAnimation.setAdapter(animationAdapter);


                //音乐
                recommendMusicAdapter.setAllBean(response);
                gridViewMusic.setAdapter(recommendMusicAdapter);
                recommend_music_title.setText(response.getResult().get(5).getHead().getTitle());

                //舞蹈
                dancingAdapter.setAllBean(response);
                gridViewDancing.setAdapter(dancingAdapter);
                recommend_drancing_title.setText(response.getResult().get(6).getHead().getTitle());

//                //
//                String urlTopicFour = response.getResult().get(7).getBody().get(0).getCover();
//                Glide.with(mContext).load(urlTopicFour).into(imageViewFour);

                //游戏区
                gameAdapter.setAllBean(response);
                gridViewGame.setAdapter(gameAdapter);
                recommend_game_title.setText(response.getResult().get(7).getHead().getTitle());

                //鬼畜
                recommend_ghost_title.setText(response.getResult().get(8).getHead().getTitle());
                ghostAdapter.setAllBean(response);
                gridViewGhost.setAdapter(ghostAdapter);


                //科技
                scienceAdapter.setAllBean(response);
                gridViewScience.setAdapter(scienceAdapter);
                recommend_sclence_title.setText(response.getResult().get(9).getHead().getTitle());


                //活动
                recommend_activity_title.setText(response.getResult().get(10).getHead().getTitle());
                activityAdapter.setAllBean(response);
                gridViewActivity.setAdapter(activityAdapter);

                //生活
                recommend_life_title.setText(response.getResult().get(11).getHead().getTitle());
                lifeAdapter.setBeanList(response);
                gridViewLife.setAdapter(lifeAdapter);


                String urlTopicFive = response.getResult().get(12).getBody().get(0).getCover();
                Log.d("dd", urlTopicFive);
                Glide.with(mContext).load(urlTopicFive).into(five_topic_big_img);

                //时尚
                recommend_fashion_title.setText(response.getResult().get(13).getHead().getTitle());
                fashionAdapter.setAllBean(response);
                gridViewFashion.setAdapter(fashionAdapter);




                //广告
                recommend_advert_title.setText(response.getResult().get(14).getHead().getTitle());
                advertAdapter.setAllBean(response);
                gridViewadvert.setAdapter(advertAdapter);


                //话题
//                String urlSix = response.getResult().get(15).getBody().get(0).getCover();
//                Glide.with(mContext).load(urlSix).into(imageViewSix);

                //娱乐
                recommend_entertain_title.setText(response.getResult().get(15).getHead().getTitle());
                entertainmentAdapter.setAllBean(response);
                gridViewEntertain.setAdapter(entertainmentAdapter);

                //电视剧
                recommend_tv_series_title.setText(response.getResult().get(16).getHead().getTitle());
                tvSeriesAdapter.setAllBean(response);
                gridViewTV.setAdapter(tvSeriesAdapter);

                //电影
                recommend_movie_title.setText(response.getResult().get(17).getHead().getTitle());
                movieAdapter.setAllBean(response);
                gridViewMovie.setAdapter(movieAdapter);


                //倒数第二个
                String url = response.getResult().get(18).getBody().get(0).getCover();
                Glide.with(mContext).load(url).into(imageView);

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

    private void initParsing() {
        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
            @Override
            public void onResponse(AllBean response) {
                List<AllBean.ResultBean.BodyBean> resultBeen = response.getResult().get(19).getBody();
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

            case R.id.live_title_recycler:

                Intent intentAnimation = new Intent(getActivity(),AnimationActivity.class);
                startActivity(intentAnimation);
                break;
        }

    }
}

