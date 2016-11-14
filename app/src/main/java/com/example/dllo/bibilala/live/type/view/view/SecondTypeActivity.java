package com.example.dllo.bibilala.live.type.view.view; /*
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
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.liveentity.typeentity.secondtype.DataEntity;
import com.example.dllo.bibilala.entity.liveentity.typeentity.secondtype.SecondAllEntity;
import com.example.dllo.bibilala.live.type.view.presenter.SecondAllTypePresenter;
import com.example.dllo.bibilala.live.view.LiveActivity;
import com.zhy.adapter.recyclerview.CommonAdapter;
import com.zhy.adapter.recyclerview.MultiItemTypeAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by dllo on 16/11/8.
 */
public class SecondTypeActivity extends BaseActivity implements IAllTypeView {
    private RecyclerView mRecyclerView;
    private List<DataEntity> entityList;
    private SecondAllTypePresenter mPresenter;

    private SwipeRefreshLayout mLayout;
    private AllAdapter adapter;
    private TextView tvTitle;
    private ImageView imaBack;

    @Override
    protected int setLayout() {
        return R.layout.second_type_ac;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.second_type_ac_rv);
        mLayout = bindView(R.id.second_type_sw);
        mPresenter = new SecondAllTypePresenter(this);
        tvTitle = bindView(R.id.second_type_ac_tv_title);
        imaBack = bindView(R.id.second_type_ima_back);


    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        entityList = new ArrayList<>();
        Intent intent = getIntent();
        final String all = intent.getStringExtra("all");
        int position = intent.getIntExtra("position", 0);
        Log.d("SecondTypeActivity", "position:" + position);
        mPresenter.startRequest(all, SecondAllEntity.class);
        Log.d("SecondTypeActivity", "all.length():" + all);
        mLayout.setColorSchemeColors(getResources().getColor(R.color.colorPinkAlways));
        String[] strings = {"手机直播", "手游直播", "萌宅推荐", "绘画专区", "网络游戏", "单机联机", "电子竞技", "唱见舞见", "生活娱乐", "御宅文化", "放映厅"};
        List<String> string = Arrays.asList(strings);
        String title = string.get(position);
        tvTitle.setText(title);
        mLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                mLayout.setRefreshing(false);
                entityList.clear();
                adapter.notifyDataSetChanged();
                mPresenter.startRequest(all, SecondAllEntity.class);


            }
        });

        imaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
//        adapter.setOnItemClickListener(new CommonAdapter.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, RecyclerView.ViewHolder holder, int position) {
////                Intent intent = new Intent(SecondTypeActivity.this, LiveActivity.class);
////                intent.putExtra("playUrl",);
////                intent.putExtra("title", title);
////                intent.putExtra("name", name);
////                intent.putExtra("online", online);
////                intent.putExtra("roomId", roomId);
////                intent.putExtra("iconUrl", iconUrl);
////                startActivity(intent);
//            }
//
//            @Override
//            public boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position) {
//                return false;
//            }
//        });

    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {

    }

    @Override
    public void onAllType(SecondAllEntity result) {
        entityList = result.getData();
        adapter = new AllAdapter(this, R.layout.item_live_type_body, entityList);
        LinearLayoutManager manager = new GridLayoutManager(this, 2);
        mRecyclerView.setLayoutManager(manager);
        mRecyclerView.setAdapter(adapter);
        adapter.setEntityList(entityList);

    }


    @Override
    public void onError() {

    }
}
