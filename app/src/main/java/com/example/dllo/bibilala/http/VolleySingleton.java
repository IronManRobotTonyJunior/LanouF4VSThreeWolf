package com.example.dllo.bibilala.http;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.example.dllo.bibilala.app.BiBiLaiLaiApp;

public class VolleySingleton {
    private static final String TAG = "VolleySingleton";

    private static final class SingletonHolder {
        private static final VolleySingleton sInstance = new VolleySingleton();
    }

    public static VolleySingleton getInstance() {
        return SingletonHolder.sInstance;
    }
    private RequestQueue mRequestQueue;

    private VolleySingleton() {
        mRequestQueue = Volley.newRequestQueue(BiBiLaiLaiApp.getContext());
    }
    public <T> void addRequest(Request<T> request){
        mRequestQueue.add(request);
    }

}
