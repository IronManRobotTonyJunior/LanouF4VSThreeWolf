package com.example.dllo.bibilala.tool;


import android.content.Context;
import android.content.SharedPreferences;

import com.example.dllo.bibilala.R;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesTool {
    public static SharedPreferences getSharedPreference(Context context) {
        return context.getSharedPreferences(context.getResources().getString(R.string.sp_name), MODE_PRIVATE);
    }

    public static SharedPreferences.Editor getEditor(SharedPreferences sp) {
        return sp.edit();
    }
}
