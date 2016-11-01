package com.example.dllo.bibilala.concern;

import android.content.Intent;
import android.view.View;
import android.widget.Button;

import com.example.dllo.bibilala.R;
import com.example.dllo.bibilala.activity.login.SignActivity;
import com.example.dllo.bibilala.base.BaseFragment;

public class ConcernFragment extends BaseFragment {
    private Button btnSign;
    @Override
    protected int setLayout() {
        return R.layout.fragment_concern;
    }

    @Override
    protected void initView() {
        btnSign = bindView(R.id.fragment_concern_btn);

    }

    @Override
    protected void initData() {
        btnSign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SignActivity.class);
                startActivity(intent);
            }
        });


    }
}
