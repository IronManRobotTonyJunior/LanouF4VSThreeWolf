package com.example.dllo.bibilala.tool;


import android.content.Context;
import android.content.SharedPreferences;

import static android.content.Context.MODE_PRIVATE;

public class SharedPreferencesTool {

    private static SharedPreferences sp;
    private static SharedPreferences.Editor spET;
    private static String SP_NAME = "mainSP";
    private static String DAY_NIGHT = "dayNight";


    public static boolean getIsNight(Context context) {
        sp = context.getSharedPreferences(SP_NAME, MODE_PRIVATE);
        boolean isNight = sp.getBoolean(DAY_NIGHT, false);
        return isNight;
    }

    public static void setEditor(boolean value) {
        spET = sp.edit();
        spET.putBoolean(DAY_NIGHT, value);
        spET.commit();

    }
}
