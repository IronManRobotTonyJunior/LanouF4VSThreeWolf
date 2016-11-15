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

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.presenter.SecondBangumPresenter;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.bangumentity.add.AddCrayonEntity;
import com.example.dllo.bibilala.entity.bangumentity.add.ListBean;
import com.example.dllo.bibilala.entity.bangumentity.add.QuarterlyEntity;
import com.example.dllo.bibilala.entity.bangumentity.add.ResultBean;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonFootEntity;
import com.example.dllo.bibilala.url.UrlClass;

import java.util.ArrayList;

/**
 * Created by dllo on 16/11/11.
 */
public class QuarterlyActivity extends BaseActivity implements ICrayonView {

    private RecyclerView mRecyclerView;
    private SecondBangumPresenter presenter;
    private QuarterlyAdapter mAdapter;
    private ImageView imaBack;

    @Override
    protected int setLayout() {
        return R.layout.quarterly_ac;
    }

    @Override
    protected void initView() {
        mRecyclerView = bindView(R.id.quarterly_rv);
        presenter = new SecondBangumPresenter(this);

        imaBack = bindView(R.id.quarterly_ac_ima_back);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {

        presenter.startRequest(UrlClass.URL_BANGUM_QUARTERLY, QuarterlyEntity.class);
        imaBack.setOnClickListener(new View.OnClickListener() {
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
    public void onCrayonFootEntity(CrayonFootEntity crayonFootEntity) {


    }

    @Override
    public void onResponse(AddCrayonEntity entity) {

    }

    @Override
    public void onQuarterlyEntity(QuarterlyEntity quarterlyEntity) {
        ResultBean resultBean = new ResultBean();
        resultBean.setList(new ArrayList<ListBean>());
        for (ResultBean bean : quarterlyEntity.getResult()) {
            resultBean.getList().addAll(bean.getList());
        }
        Log.d("QuarterlyActivity", "entity.getList().size():" + resultBean.getList().size());
        mAdapter = new QuarterlyAdapter(this,R.layout.item_quarterly_ac,resultBean.getList());

        mAdapter.setListBeen(resultBean.getList());
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        mRecyclerView.setAdapter(mAdapter);

    }

    @Override
    public void onError() {

    }
}
