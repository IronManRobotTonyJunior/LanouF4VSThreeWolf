package com.example.dllo.bibilala.recommend.secondinterface.hotrecommendfragment;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseFragment;
import com.example.dllo.bibilala.entity.recommend.hot.OriginalEntity;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.recommend.secondinterface.adapter.OriginalAdapter;
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
public class OriginalFragment  extends BaseFragment{

    private RecyclerView original_recycler;
    private List<OriginalEntity.RankBean.ListBean>listBeen;
    private OriginalAdapter originalAdapter;

    @Override
    protected int setLayout() {
        return R.layout.fragment_original;
    }

    @Override
    protected void initView() {
        original_recycler =bindView(R.id.original_recycler);

    }

    @Override
    protected void initData() {
        LinearLayoutManager manager =new LinearLayoutManager(getActivity());
        original_recycler.setLayoutManager(manager);
        listBeen =new ArrayList<>();
        originalAdapter = new OriginalAdapter(mContext, R.layout.recycler_fragment_original,listBeen);
        original_recycler.setAdapter(originalAdapter);

        SendGetRequest.sendGetRequest(UrlClass.URL_HOT_ORIGINAL, OriginalEntity.class, new SendGetRequest.OnResponseListener<OriginalEntity>() {
            @Override
            public void onResponse(OriginalEntity response) {
                List<OriginalEntity.RankBean.ListBean>listBeanList =response.getRank().getList();
                listBeen.addAll(listBeanList);
                originalAdapter.notifyDataSetChanged();



            }

            @Override
            public void onError() {

            }
        });

    }
}
