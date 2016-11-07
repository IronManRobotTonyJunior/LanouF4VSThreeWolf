package com.example.dllo.bibilala.recommend.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Html;
import android.widget.TextView;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.base.BaseActivity;
import com.example.dllo.bibilala.entity.recommendentity.LiveInterfaceBean;
import com.example.dllo.bibilala.http.SendGetRequest;

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
public class GridLiveActivity  extends BaseActivity {
    private TextView tt;
    @Override
    protected int setLayout() {
        return R.layout.activity_grid_live;
    }

    @Override
    protected void initView() {
        tt = (TextView) findViewById(R.id.ttt);

    }

    @Override
    protected void initData(Bundle savedInstanceState) {
        Intent intent =getIntent();
        String url =intent.getStringExtra("urlLive");
        SendGetRequest.sendGetRequest(url, LiveInterfaceBean.class, new SendGetRequest.OnResponseListener<LiveInterfaceBean>() {
            @Override
            public void onResponse(LiveInterfaceBean response) {
                String  content =response.getData().getMeta().getDescription();
                tt.setText(Html.fromHtml(content, null, null));




            }

            @Override
            public void onError() {

            }
        });

    }
}
