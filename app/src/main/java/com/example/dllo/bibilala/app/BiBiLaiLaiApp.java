package com.example.dllo.bibilala.app;


import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.example.dllo.bibilala.tool.SharedPreferencesTool;

import cn.bmob.v3.Bmob;
import cn.smssdk.SMSSDK;


public class BiBiLaiLaiApp extends Application {

    private static Context sContext;
    private boolean isNight;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
        Bmob.initialize(this, "2b3fd0684464ce38a182f79794c620b4");
        SMSSDK.initSDK(this, "1906860cc73e8", "686f287d2ff260df237abbbb42004813");
        isNight = SharedPreferencesTool.getIsNight(sContext);
        if (isNight) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        }
    }

    public static Context getContext() {
        return sContext;
    }
}
