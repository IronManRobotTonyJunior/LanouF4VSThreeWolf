package com.example.dllo.bibilala.app;


import android.app.Application;
import android.content.Context;
import android.support.v7.app.AppCompatDelegate;

import com.example.dllo.bibilala.tool.SharedPreferencesTool;


public class BiBiLaiLaiApp extends Application {

    private static Context sContext;
    private boolean isNight;

    @Override
    public void onCreate() {
        super.onCreate();
        sContext = this;
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
