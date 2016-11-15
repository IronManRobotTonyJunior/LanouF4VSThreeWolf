package com.example.dllo.bibilala.bangumi;

import android.content.Intent;
import android.os.Handler;
import android.os.Message;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.adapter.BangumAdapter;
import com.example.dllo.bibilala.bangumi.adapter.BangumChinaAdapter;
import com.example.dllo.bibilala.bangumi.adapter.BangumiPageAdapter;
import com.example.dllo.bibilala.bangumi.adapter.CrayonAdapter;
import com.example.dllo.bibilala.bangumi.adapter.JulyToLoveAdapter;
import com.example.dllo.bibilala.bangumi.view.AddCrayonActivity;
import com.example.dllo.bibilala.bangumi.view.BangumiActivity;
import com.example.dllo.bibilala.bangumi.view.CrayonActivity;
import com.example.dllo.bibilala.bangumi.view.QuarterlyActivity;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.bangumentity.BangUmiEntity;
import com.example.dllo.bibilala.entity.bangumentity.BangUmiRecommendEntity;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.url.UrlClass;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;
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

    private GridView mGridView, mChinaGridView, mCrayonGridView;
    private BangumChinaAdapter mBangumChinaAdapter;
    private CrayonAdapter mCrayonAdapter;
    private LinearLayout mLayout;
    private SwipeRefreshLayout mRefreshLayout;


    private RelativeLayout tvNewBang,rvJu;


    @Override
    protected int setLayout() {
        return R.layout.fragment_bangumi;
    }


    @Override
    protected void initView() {

        mRecyclerView = bindView(R.id.bang_umi_fragment_rv);
        mRefreshLayout = bindView(R.id.bang_umi_fragment_srl);


    }


    @Override
    protected void initData() {


        mRefreshLayout.setColorSchemeColors(getResources().getColor(R.color.colorPinkAlways));
        mEntity = new ArrayList<>();
        adapter = new BangumAdapter(mContext, R.layout.item_bangum_recommend, mEntity);
        LinearLayoutManager manager = new LinearLayoutManager(mContext);
        mRecyclerView.setLayoutManager(manager);
        mHeaderAndFooterWrapper = new HeaderAndFooterWrapper(adapter);


        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_RECOMMEND, BangUmiRecommendEntity.class, new SendGetRequest.OnResponseListener<BangUmiRecommendEntity>() {
            @Override
            public void onResponse(BangUmiRecommendEntity response) {
                List<BangUmiRecommendEntity.ResultBean> results = response.getResult();
                mEntity.addAll(results);
                mRecyclerView.setAdapter(mHeaderAndFooterWrapper);
                adapter.notifyDataSetChanged();
                mRecyclerView.scrollTo(0, 0);
            }

            @Override
            public void onError() {

            }
        });


        onResponse();
        mRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                SendGetRequest.sendGetRequest(UrlClass.URL_SOME_RECOMMEND, BangUmiRecommendEntity.class, new SendGetRequest.OnResponseListener<BangUmiRecommendEntity>() {
                    @Override
                    public void onResponse(BangUmiRecommendEntity response) {

                        List<BangUmiRecommendEntity.ResultBean> results = response.getResult();
                        results.clear();
                        mEntity.addAll(results);
                        mRecyclerView.setAdapter(mHeaderAndFooterWrapper);
                        adapter.notifyDataSetChanged();
                        mRecyclerView.scrollTo(0, 0);

                    }

                    @Override
                    public void onError() {

                    }
                });
                mRefreshLayout.setRefreshing(false);

            }
        });
        adapter.setOnItemClickListener(new MultiItemTypeAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, RecyclerView.ViewHolder holder, final int position) {

                SendGetRequest.sendGetRequest(UrlClass.URL_SOME_RECOMMEND, BangUmiRecommendEntity.class, new SendGetRequest.OnResponseListener<BangUmiRecommendEntity>() {
                    @Override
                    public void onResponse(BangUmiRecommendEntity response) {
                        String link = response.getResult().get(position-3).getLink();
                        Intent intent = new Intent(mContext,BangumiActivity.class);
                        intent.putExtra("link",link);
                        startActivity(intent);


                    }

                    @Override
                    public void onError() {

                    }
                });
            }

            @Override
            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
                return false;
            }
        });
    }


    private void onResponse() {
        onLunView();
        crayonView();
        chinaView();
        onJulyView();
        startRequest();
        spotWay();
        secondCrayon();
        secondChina();
        secondJuly();
    }

    private void secondJuly() {
        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
                    @Override
                    public void onResponse(BangUmiEntity response) {
                        int i = response.getResult().getPrevious().getList().get(position).getSeason_id();
                        String url = UrlClass.URL_BANGUM_SECOND_NEW_RECOMMEND(i);
                        Intent intent = new Intent(mContext, CrayonActivity.class);
                        intent.putExtra("july", url);
                        startActivity(intent);


                    }

                    @Override
                    public void onError() {

                    }
                });
                Toast.makeText(mContext, "点击了" + position, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void secondChina() {
        mChinaGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
                    @Override
                    public void onResponse(BangUmiEntity response) {
                        int i = response.getResult().getChina().get(position).getSeason_id();
                        String url = UrlClass.URL_BANGUM_SECOND_NEW_RECOMMEND(i);
                        Intent intent = new Intent(mContext, CrayonActivity.class);
                        intent.putExtra("july", url);
                        startActivity(intent);
                    }

                    @Override
                    public void onError() {

                    }
                });
                Toast.makeText(mContext, "点击了" + position, Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void startRequest() {
        SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
            @Override
            public void onResponse(final BangUmiEntity response) {
                mBangumiAdapter.setEntity(response.getResult().getAd().getHead());
                mViewPager.setAdapter(mBangumiAdapter);
//
                mCrayonAdapter.setEntity(response.getResult().getSerializing());
                mCrayonGridView.setAdapter(mCrayonAdapter);

                mJulyToLoveAdapter.setEntity(response.getResult().getPrevious().getList());
                mGridView.setAdapter(mJulyToLoveAdapter);

                mBangumChinaAdapter.setEntity(response.getResult().getChina());
                mChinaGridView.setAdapter(mBangumChinaAdapter);


                mRecyclerView.scrollTo(0, 0);

            }

            @Override
            public void onError() {

            }
        });
    }

    private void secondCrayon() {
        mCrayonGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, final int position, long id) {
                SendGetRequest.sendGetRequest(UrlClass.URL_SOME_DRAMA, BangUmiEntity.class, new SendGetRequest.OnResponseListener<BangUmiEntity>() {
                    @Override
                    public void onResponse(BangUmiEntity response) {
                        int i = response.getResult().getSerializing().get(position).getSeason_id();
                        String url = UrlClass.URL_BANGUM_SECOND_NEW_RECOMMEND(i);
                        String urls = UrlClass.URL_BGM(i);
                        Intent intent = new Intent(mContext, CrayonActivity.class);
                        intent.putExtra("july", url);
                        intent.putExtra("bum", urls);
                        startActivity(intent);


                    }

                    @Override
                    public void onError() {

                    }
                });
                Toast.makeText(mContext, "点击了" + position, Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void spotWay() {
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

    private void crayonView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_bangum_fragment_crayon, null);
        mHeaderAndFooterWrapper.addHeaderView(view);
        mCrayonGridView = (GridView) view.findViewById(R.id.item_crayon_gl);
        mCrayonAdapter = new CrayonAdapter(mContext);
    }

    private void chinaView() {

        View view = LayoutInflater.from(mContext).inflate(R.layout.item_bangum_fragment_china, null);
        mHeaderAndFooterWrapper.addHeaderView(view);
        rvJu = (RelativeLayout) view.findViewById(R.id.item_china_rv);
        mChinaGridView = (GridView) view.findViewById(R.id.item_bang_china_gv);
        mBangumChinaAdapter = new BangumChinaAdapter(mContext);
        rvJu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,QuarterlyActivity.class);
                startActivity(intent);

            }
        });
    }

    private void onJulyView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_gl_july_fragment, null);
        mGridView = (GridView) view.findViewById(R.id.item_july_gl);
        mHeaderAndFooterWrapper.addHeaderView(view);
        mJulyToLoveAdapter = new JulyToLoveAdapter(mContext);
    }

    private void onLunView() {
        View view = LayoutInflater.from(mContext).inflate(R.layout.item_rv_lun_fragment, null);
        mHeaderAndFooterWrapper.addHeaderView(view);
//        mHeaderAndFooterWrapper.notifyDataSetChanged();
        mViewPager = (ViewPager) view.findViewById(R.id.bang_umi_fragment_viewpager);
        mLinearLayout = (LinearLayout) view.findViewById(R.id.bang_umi_fragment_ll);
        mLayout = (LinearLayout) view.findViewById(R.id.rv_lun_l);
        tvNewBang = (RelativeLayout) view.findViewById(R.id.new_bang_rv);
        tvNewBang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext,AddCrayonActivity.class);
                startActivity(intent);
            }
        });
        mLinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int currentItem = mViewPager.getCurrentItem();
                Toast.makeText(mContext, "currentItem:" + currentItem, Toast.LENGTH_SHORT).show();
            }
        });
        mBangumiAdapter = new BangumiPageAdapter(mContext);
    }


}
