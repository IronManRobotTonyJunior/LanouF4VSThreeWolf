package com.example.dllo.bibilala.base;


import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseActivity extends AppCompatActivity {
    private static Map<String, AppCompatActivity> activities = new HashMap<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(setLayout());
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
//            // Translucent status bar
//            getWindow().setFlags(
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS,
//                    WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
//        }
        activityController(this);
        initView();
        initData(savedInstanceState);
    }

    protected abstract int setLayout();

    protected abstract void initView();

    protected abstract void initData(Bundle savedInstanceState);

    protected <T extends View> T bindView(int id) {
        return (T) findViewById(id);
    }

    private static void activityController(AppCompatActivity activity) {
        activities.put(activity.getClass().getSimpleName(), activity);
    }

    protected AppCompatActivity getActivity(String activityName) {
        return activities.get(activityName);
    }

}
