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
import android.util.Log;
import android.widget.GridView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.bangumi.presenter.SecondBangumPresenter;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.bangumentity.crayonentity.CrayonFootEntity;

/**
 * Created by dllo on 16/11/1.
 */
public class CrayonActivity extends BaseActivity implements ICrayonView {
    private GridView mGridView;
    private SecondBangumPresenter mPresenter;
    private CrayonAdapter mAdapter;

    @Override
    protected int setLayout() {
        return R.layout.crayon_activity;
    }

    @Override
    protected void initView() {
        mGridView = bindView(R.id.crayon_ac_gl);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        mPresenter = new SecondBangumPresenter(this);
        Intent intent = getIntent();
        String mUrl = intent.getStringExtra("crayon");
        Log.d("CrayonActivity", mUrl);
        mPresenter.startRequest(mUrl,CrayonFootEntity.class);

        mAdapter = new CrayonAdapter(this);
        mGridView.setAdapter(mAdapter);

    }

    @Override
    public void showDialog() {


    }

    @Override
    public void dismissDialog() {

    }


    @Override
    public void onCrayonFootEntity(CrayonFootEntity crayonFootEntity) {
        mAdapter.setEntityList(crayonFootEntity.getResult().getList());

        Log.d("CrayonActivity", "crayonFootEntity.getResult().getList().size():" + crayonFootEntity.getResult().getList().size());


    }

    @Override
    public void onError() {

    }
}
