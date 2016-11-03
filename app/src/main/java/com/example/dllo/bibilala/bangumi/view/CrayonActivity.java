package com.example.dllo.bibilala.bangumi.view; /*
        quu..__
         $$$b  `---.__
          "$$b        `--.                          ___.---uuudP
           `$$b           `.__.------.__     __.---'      $$$$"              .
             "$b          -'            `-.-'            $$$"              .'|
               ".                                       d$"             _.'  |
                 `.   /                              ..."             .'     |
                   `./                           ..::-'            _.'       |
                    /                         .:::-'            .-'         .'
                   :                          ::''\          _.'            |
                  .' .-.             .-.           `.      .'               |
                  : /'$$|           .@"$\           `.   .'              _.-'
                 .'|$u$$|          |$$,$$|           |  <            _.-'
                 | `:$$:'          :$$$$$:           `.  `.       .-'
                 :                  `"--'             |    `-.     \
                :                |                |#'     `..'`..'          `                 \                                   xXX|     /    ./
                  \                                xXXX'|    /   ./
                  /`-.                                  `.  /   /
                 :    `-  ...........,                   | /  .'
                 |         ``:::::::'       .            |<    `.
                 |             ```          |           x| \ `.:``.
                 |                         .'    /'   xXX|  `:`M`M':.
                 |    |                    ;    /:' xXXX'|  -'MMMMM:'
                 `.  .'                   :    /:'       |-'MMMM.-'
                  |  |                   .'   /'        .'MMM.-'
                  `'`'                   :  ,'          |MMM<
                    |                     `'            |tbap\
                     \                                  :MM.-'
                      \                 |              .''
                       \.               `.            /
                        /     .:::::::.. :           /
                       |     .:::::::::::`.         /
                       |   .:::------------\       /
                      /   .''               >::'  /
                      `',:                 :    .'
                                           `:.:'

         
        */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.presenter.SecondBangumPresenter;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonBean;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonFootEntity;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.DataBean;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.ListEntity;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.RepliesBean;
import com.example.dllo.bibilala.http.SendGetRequest;
import com.example.dllo.bibilala.url.UrlClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/1.
 */
public class CrayonActivity extends BaseActivity implements ICrayonView {
    private RecyclerView mRecyclerView;
    private SecondBangumPresenter mPresenter;
    private CrayonAdapter mAdapter;
    private List<ListEntity> entityList;

    @Override
    protected int setLayout() {
        return R.layout.crayon_activity;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.crayon_ac_rv);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        entityList = new ArrayList<>();
        mPresenter = new SecondBangumPresenter(this);
        Intent intent = getIntent();
        String mUrl = intent.getStringExtra("crayon");
        String url = intent.getStringExtra("bum");
        Log.d("CrayonActivity", url);

        mPresenter.startRequest(mUrl, CrayonFootEntity.class);


        SendGetRequest.sendGetRequest(url, CrayonBean.class, new SendGetRequest.OnResponseListener<CrayonBean>() {
            @Override
            public void onResponse(CrayonBean response) {
//                response.getResult().getEpisodes().size();
//                String i = response.getResult().getEpisodes().get(0).getAv_id();
//
//                Log.d("CrayonActivity", "i.length():" + i.length());
//                Log.d("CrayonActivity", i);

            }

            @Override
            public void onError() {

            }
        });


    }


    @Override
    public void onCrayonFootEntity(CrayonFootEntity crayonFootEntity) {
        entityList = crayonFootEntity.getResult().getList();
        crayonResult();


    }

    private void crayonResult() {
        mAdapter = new CrayonAdapter(this, R.layout.item_crayon_ac, entityList);
        mAdapter.setEntityList(entityList);
        LinearLayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showDialog() {


    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void onError() {

    }
}
