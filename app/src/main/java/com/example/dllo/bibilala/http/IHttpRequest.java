package com.example.dllo.bibilala.http;


import java.util.Map;

public interface IHttpRequest {
    /**
     * @param urlStr   请求的URL
     * @param clazz    解析的实体类结果类型
     * @param listener 网络请求的结果回调
     * @param <T>      解析的实体类类型
     */
    <T> void getRequest(String urlStr, Class<T> clazz, OnCompletedListener<T> listener);

    <T> void getRequest(String urlStr, Map<String, String> headers, Class<T> clazz, OnCompletedListener<T> listener);

    <T> void postRequest(String urlStr, Map<String, String> requestBody, Class<T> clazz, OnCompletedListener<T> listener);

    <T> void postRequest(String urlStr, Map<String, String> headers, Map<String, String> requestBody, Class<T> clazz, OnCompletedListener<T> listener);


}
