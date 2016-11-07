package com.example.dllo.bibilala.mvp.presenter;

/**
 * Created by Risky on 15/10/29.
 */
public interface NetworkConnect<T> {
    /**
     * 数据刷新成功时的回调方法,参数为数据的实体类
     * @param result 数据刷新成功返回的实体类
     */
    void onRefreshCompleted(T result);
    void onLoadCompleted(T result);
    void onFailed();

}
