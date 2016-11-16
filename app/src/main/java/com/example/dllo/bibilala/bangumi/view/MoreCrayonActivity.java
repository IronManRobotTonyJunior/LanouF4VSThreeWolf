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

import android.app.ProgressDialog;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.presenter.SecondBangumPresenter;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.bangum.add.AddCrayonEntity;
import com.example.dllo.bibilala.entity.bangum.add.QuarterlyEntity;
import com.example.dllo.bibilala.entity.bangum.add.ResultEntity;
import com.example.dllo.bibilala.entity.bangum.crayon.CrayonFootEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by dllo on 16/11/10.
 */
public class MoreCrayonActivity extends BaseActivity implements ICrayonView {
    private RecyclerView mRecyclerView;
    private MoreCrayonAdapter mAdapter;
    private List<ResultEntity> entityList;
    private SecondBangumPresenter mPresenter;
    private ImageView mImageback;


    @Override
    protected int setLayout() {
        return R.layout.add_caryon_ac;
    }

    @Override
    protected void initView() {

        mRecyclerView = bindView(R.id.add_crayon_rv);
        mImageback = bindView(R.id.add_crayon_ac_ima_back);
    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter = new SecondBangumPresenter(this);
        mPresenter.startRequest("http://bangumi.bilibili.com/api/serializing_season?appkey=1d8b6e7d45233436&build=427000&mobi_app=android&platform=android&ts=1478758281000&sign=f99551c80bf9622e1d67796421403e0d", AddCrayonEntity.class);
        entityList = new ArrayList<>();
        mImageback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    private ProgressDialog createDialog() {
        ProgressDialog dialog = new ProgressDialog(this);
        dialog.setCanceledOnTouchOutside(false);
        dialog.setProgressStyle(R.style.styleTwo);
        return dialog;
    }

    @Override
    public void showDialog() {

    }

    @Override
    public void dismissDialog() {


    }

    @Override
    public void onCrayonFootEntity(CrayonFootEntity crayonFootEntity) {

    }

    @Override
    public void onResponse(AddCrayonEntity entity) {
        entityList = entity.getResult();
        Log.d("MoreCrayonActivity", "entity:" + entity);
        Log.d("MoreCrayonActivity", "entity.getResult().size():" + entity.getResult().size());
        mAdapter = new MoreCrayonAdapter(this, R.layout.item_add_caryon_ac, entityList);
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 1));
        mAdapter.setEntityList(entityList);
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onQuarterlyEntity(QuarterlyEntity entity) {

    }


    @Override
    public void onError() {

    }


}
