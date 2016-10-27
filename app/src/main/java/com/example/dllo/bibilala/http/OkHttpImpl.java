package com.example.dllo.bibilala.http;


import android.os.Environment;
import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.Headers;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpImpl implements IHttpRequest {
    private OkHttpClient mClient;
    private Gson mGson;
    private Handler mHandler;

    public OkHttpImpl() {
        File fileDir = Environment.getDownloadCacheDirectory();
        mClient = new OkHttpClient.Builder()
                .connectTimeout(5000, TimeUnit.MILLISECONDS)
                .cache(new Cache(fileDir, 10 * 1024 * 1024))
                .build();
        mGson = new Gson();
        mHandler = new Handler(Looper.getMainLooper());
    }

    @Override
    public <T> void getRequest(String urlStr, Class<T> clazz, OnCompletedListener<T> listener) {
        Request request = createRequest(urlStr, null, null);
        asyncRequest(clazz, listener, request);
    }

    @Override
    public <T> void getRequest(String urlStr, Map<String, String> headers, Class<T> clazz, OnCompletedListener<T> listener) {
        Request request = createRequest(urlStr, headers, null);
        asyncRequest(clazz, listener, request);
    }

    @Override
    public <T> void postRequest(String urlStr, Map<String, String> requestBody, Class<T> clazz, OnCompletedListener<T> listener) {
        Request request = createRequest(urlStr, null, requestBody);
        asyncRequest(clazz, listener, request);
    }

    @Override
    public <T> void postRequest(String urlStr, Map<String, String> headers, Map<String, String> requestBody, Class<T> clazz, OnCompletedListener<T> listener) {
        Request request = createRequest(urlStr, headers, requestBody);
        asyncRequest(clazz, listener, request);
    }


    private Request createRequest(String urlStr, Map<String, String> headers, Map<String, String> requestBody) {
        Request.Builder builder = new Request.Builder();
        builder.url(urlStr);
        if (headers != null) {
            builder.headers(Headers.of(headers));
        }
        if (requestBody != null) {
            FormBody body = getFormBody(requestBody);
            builder.post(body);
        }
        return builder.build();
    }

    private FormBody getFormBody(Map<String, String> requestBody) {
        FormBody.Builder builder = new FormBody.Builder();
        for (String key : requestBody.keySet()) {
            builder.add(key, requestBody.get(key));
        }
        return builder.build();
    }

    private <T> void asyncRequest(final Class<T> clazz, final OnCompletedListener<T> listener, Request request) {
        mClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                postError(listener);
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    final T result = mGson.fromJson(response.body().string(), clazz);
                    postResponse(result, listener);
                } else {
                    postError(listener);
                }
            }
        });
    }

    private <T> void postResponse(final T result, final OnCompletedListener<T> listener) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                listener.onCompleted(result);
            }
        });
    }

    private <T> void postError(final OnCompletedListener<T> listener) {
        mHandler.post(new Runnable() {
            @Override
            public void run() {
                listener.onFailed();
            }
        });
    }


}
