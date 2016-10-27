package com.example.dllo.bibilala.http;


import java.util.Map;

public class HttpManager implements IHttpRequest {
    private static final String TAG = "HttpManager";
    private final OkHttpImpl mRequest;

    private static final class SingletonHolder {
        private static final HttpManager sInstance = new HttpManager();
    }

    public static HttpManager getInstance() {
        return SingletonHolder.sInstance;
    }

    private HttpManager() {
        mRequest = new OkHttpImpl();
    }
    @Override
    public <T> void getRequest(String url, Class<T> clazz, OnCompletedListener<T> listener) {
        mRequest.getRequest(url, clazz, listener);
    }

    @Override
    public <T> void getRequest(String url, Map<String, String> headers, Class<T> clazz, OnCompletedListener<T> listener) {
        mRequest.getRequest(url, headers, clazz, listener);
    }

    @Override
    public <T> void postRequest(String urlStr, Map<String, String> requestBody, Class<T> clazz, OnCompletedListener<T> listener) {
        mRequest.postRequest(urlStr, requestBody, clazz, listener);
    }

    @Override
    public <T> void postRequest(String urlStr, Map<String, String> headers, Map<String, String> requestBody, Class<T> clazz, OnCompletedListener<T> listener) {
        mRequest.postRequest(urlStr, headers, requestBody, clazz, listener);

    }
}
