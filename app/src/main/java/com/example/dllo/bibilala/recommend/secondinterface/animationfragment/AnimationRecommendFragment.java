package com.example.dllo.bibilala.recommend.secondinterface.animationfragment;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.recommend.animation.DynamicEntity;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.recommend.secondinterface.adapter.AnimationRecommendAdapter;
import com.example.dllo.bibilala.values.UrlClass;

import java.util.ArrayList;
import java.util.List;

/**
 * 　　　　　　　　┏┓　　　┏┓+ +
 * 　　　　　　　┏┛┻━━━┛┻┓ + +
 * 　　　　　　　┃　　　　　　　┃
 * 　　　　　　　┃　　　━　　　┃ ++ + + +
 * 　　　　　　 ████━████ ┃+
 * 　　　　　　　┃　　　　　　　┃ +
 * 　　　　　　　┃　　　┻　　　┃
 * 　　　　　　　┃　　　　　　　┃ + +
 * 　　　　　　　┗━┓　　　┏━┛
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃ + + + +
 * 　　　　　　　　　┃　　　┃　　　　Code is far away from bug with the animal protecting
 * 　　　　　　　　　┃　　　┃ + 　　　　神兽保佑,代码无bug
 * 　　　　　　　　　┃　　　┃
 * 　　　　　　　　　┃　　　┃　　+
 * 　　　　　　　　　┃　 　　┗━━━┓ + +
 * 　　　　　　　　　┃ 　　　　　　　┣┓
 * 　　　　　　　　　┃ 　　　　　　　┏┛
 * 　　　　　　　　　┗┓┓┏━┳┓┏┛ + + + +
 * 　　　　　　　　　　┃┫┫　┃┫┫
 * 　　　　　　　　　　┗┻┛　┗┻┛+ + + +
 * <p/>
 * Created by 刘城羊 on 16/7/10.
 */
public class AnimationRecommendFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private AnimationRecommendAdapter recommendAdapter;
    private List<DynamicEntity.DataBean>dataBeen;


    @Override
    protected int setLayout() {
        return R.layout.fragment_animation_recommend;
    }

    @Override
    protected void initView() {
        recyclerView =bindView(R.id.animation_recycler);

    }

    @Override
    protected void initData() {

        GridLayoutManager manager =new GridLayoutManager(getContext(),2);
        recyclerView.setLayoutManager(manager);
        dataBeen =new ArrayList<>();
        recommendAdapter = new AnimationRecommendAdapter(mContext,R.layout.item_fragment_animation_recommend,dataBeen);
        recyclerView.setAdapter(recommendAdapter);

        SendGetRequest.sendGetRequest(UrlClass.URL_ANIMATION_TITLE_DYNAMIC, DynamicEntity.class, new SendGetRequest.OnResponseListener<DynamicEntity>() {
            @Override
            public void onResponse(DynamicEntity response) {
                List<DynamicEntity.DataBean>dataBeanList =response.getData();
                dataBeen.addAll(dataBeanList);
                recommendAdapter.notifyDataSetChanged();

            }

            @Override
            public void onError() {

            }
        });



    }
}
