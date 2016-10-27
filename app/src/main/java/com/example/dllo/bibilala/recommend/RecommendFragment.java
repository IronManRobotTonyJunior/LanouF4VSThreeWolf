package com.example.dllo.bibilala.recommend;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.LinearLayout;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.http.SendGetRequest;
//import com.example.dllo.bibilala.recommend.adapter.RecommendAdapter;
import com.example.dllo.bibilala.entity.recommendentity.AllBean;
import com.example.dllo.bibilala.entity.recommendentity.LBBean;
import com.example.dllo.bibilala.url.UrlClass;

public class RecommendFragment extends BaseFragment {
    private LinearLayout linearLayout;
    private ViewPager viewPager;
//    private RecommendAdapter recommendAdapter;i
    private LBBean lbBean;
    private RecyclerView recyclerView;
//    private ArrayList<Integer>.types;




    private boolean mFalg = true;
    private boolean flag = true;
    private Handler handler;

    @Override
    protected int setLayout() {
        return R.layout.fragment_recommend;
    }

    @Override
    protected void initView() {
        recyclerView =bindView(R.id.recommend_recycle_view);

        viewPager = bindView(R.id.view_pager);
//        linearLayout = bindView(R.id.ll);

    }

    @Override
    protected void initData() {
        LinearLayoutManager linearLayoutManager =new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(linearLayoutManager);

//        recommendAdapter = new RecommendAdapter(getContext());
//        types =new ArrayList<>();


        initParsing();
//        initLB();
//        initSpeed();
    }

    private void initParsing() {
        SendGetRequest.sendGetRequest(UrlClass.URL_RECOMMEND, AllBean.class, new SendGetRequest.OnResponseListener<AllBean>() {
            @Override
            public void onResponse(AllBean response) {
                for (int i = 0; i < 20; i++) {
//                    types.add(i);

                }
//                recommendAdapter.setAllBean(response);
//                recommendAdapter.setTypes(types);
//                recyclerView.setAdapter(recommendAdapter);


            }

            @Override
            public void onError() {

            }
        });



    }



//        tip = new ImageView[4];
//        for (int i = 0; i <4; i++) {
//            ImageView imageView = new ImageView(getContext());
//            imageView.setLayoutParams(new LinearLayout.LayoutParams(50, 50));
//            tip[i] = imageView;
//            if (i == 0) {
//                imageView.setImageResource(R.mipmap.red_title);
//            } else {
//                imageView.setImageResource(R.mipmap.white_title);
//            }
//            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(50, 50);
//            layoutParams.leftMargin = 20;
//            layoutParams.rightMargin = 20;
//            linearLayout.addView(imageView, layoutParams);
//        }
//        recommendAdapter.setTip(tip);
//
    }

//    private void initLB() {
//        SendGetRequest.sendGetRequest(UrlClass.URL_GHOST_OU, LBBean.class, new SendGetRequest.OnResponseListener<LBBean>() {
//            @Override
//            public void onResponse(LBBean response) {
//                recommendAdapter.setLbBean(response);
//                viewPager.setAdapter(recommendAdapter);
////                recommendAdapter.setViewPager(viewPager);
//            }
//
//            @Override
//            public void onError() {
//
//            }
//        });
//
//    }}
