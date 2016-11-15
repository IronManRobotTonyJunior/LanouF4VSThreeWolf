package com.example.dllo.bibilala.find.view;
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
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.find.FindEntity;
import com.example.dllo.bibilala.entity.find.TopicEntity;
import com.example.dllo.bibilala.find.presenter.TopicPresenter;
import com.example.dllo.bibilala.find.view.IFindView;
import com.example.dllo.bibilala.find.view.TopicAdapter;
import com.example.dllo.bibilala.url.UrlClass;

/**
 * Created by dllo on 16/11/14.
 */

public class TopicActivity extends BaseActivity implements ITopicView {
    private ListView mListView;
    private TopicAdapter mAdapter;
    private TopicPresenter mPresenter;
    private SwipeRefreshLayout mLayout;
    private ImageView imaBack;
    private TextView tvTitle;

    @Override
    protected int setLayout() {
        return R.layout.topic_activity;
    }

    @Override
    protected void initView() {
        mListView = bindView(R.id.topic_ac_lv);
        mLayout = bindView(R.id.topic_sw);
        mAdapter = new TopicAdapter(this);
        mPresenter = new TopicPresenter(this);
        imaBack = bindView(R.id.topic_ac_ima_back);
        tvTitle = bindView(R.id.ac_topic_title);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        Intent intent = getIntent();
        String topic = intent.getStringExtra("topic");
        String title = intent.getStringExtra("to");
        tvTitle.setText(title);
        imaBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        mLayout.setColorSchemeColors(getResources().getColor(R.color.colorPinkAlways));
        mPresenter.startRequest(topic, TopicEntity.class);
        mLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                mPresenter.startRequest(UrlClass.URL_FIND_TOPIC, TopicEntity.class);
                mLayout.setRefreshing(false);

            }
        });




    }


    @Override
    public void onResponse(TopicEntity entity) {
        mAdapter.setEntityList(entity.getList());
        mListView.setAdapter(mAdapter);

    }

    @Override
    public void onError() {

    }
}
