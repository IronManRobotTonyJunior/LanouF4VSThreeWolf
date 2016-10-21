package com.example.dllo.bibilala.base;


import android.os.Bundle;
import android.support.annotation.Nullable;

import com.example.dllo.bibilala.R;

public abstract class BaseTitleActivity extends BaseActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.base_activity_include_title);
//        LinearLayout mLinearLayout = bindView(R.id.base_ll);
//        View view = LayoutInflater.from(this).inflate(setLayout(),mLinearLayout,false);
//        mLinearLayout.addView(view);
    }
}
