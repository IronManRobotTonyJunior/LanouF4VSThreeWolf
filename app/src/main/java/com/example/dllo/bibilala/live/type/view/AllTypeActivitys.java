package com.example.dllo.bibilala.live.type.view;
 /*
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
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.liveentity.typeentity.AllTypeEntity;
import com.example.dllo.bibilala.entity.liveentity.typeentity.DataEntity;
import com.example.dllo.bibilala.live.type.presenter.AllTypePresenter;
import com.example.dllo.bibilala.live.type.view.view.SecondTypeActivity;
import com.example.dllo.bibilala.url.UrlClass;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/7.
 */

public class AllTypeActivitys extends BaseActivity implements IAllTypeView {
    private RecyclerView mRecyclerView;
    private List<DataEntity> entityList;
    private AllTypeAdapter mAdapter;
    private AllTypePresenter mLivePresenter;
    private ImageView mImageBack;

    @Override
    protected int setLayout() {
        return R.layout.activity_all_type;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.ac_all_type_rv);
        mImageBack = bindView(R.id.ac_all_type_ima_back);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        entityList = new ArrayList<>();
        mLivePresenter = new AllTypePresenter(this);
        mLivePresenter.startRequest(UrlClass.URL_LIVE_TAAG, AllTypeEntity.class);
        mImageBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }


    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void onAllType(AllTypeEntity result) {
        entityList = result.getData();
        Log.d("AllTypeActivitys", "entityList:" + entityList);
        mAdapter = new AllTypeAdapter(this, R.layout.item_all_type, entityList);
        LinearLayoutManager manager = new GridLayoutManager(this, 3);
        mRecyclerView.setLayoutManager(manager);
        mAdapter.setEntityList(entityList);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setListener(new AllTypeAdapter.onRecyclerViewCLickListener() {
            @Override
            public void ItemClick(RecyclerView.ViewHolder holder, int position, View view) {
                int id = entityList.get(position).getId();
                String url = UrlClass.URL_ALL_TYPE(id);
                Intent intent = new Intent(AllTypeActivitys.this, SecondTypeActivity.class);
                ArrayList<String> strings = new ArrayList<>();
                strings.add(getResources().getString(R.string.alls));
                Log.d("AllTypeActivitys", "strings:" + strings.size());
                intent.putExtra("position",position);
                intent.putExtra("all", url);
                startActivity(intent);

            }
        });


    }

    @Override
    public void onError() {

    }
}
