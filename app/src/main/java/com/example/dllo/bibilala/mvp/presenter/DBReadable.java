package com.example.dllo.bibilala.mvp.presenter;

/**
 * Created by Risky on 15/10/30.
 */
public interface DBReadable<T> {
    /**
     * 读取数据库的回调方法
     * @param result 读取数据库所返回的数据
     */
    void onReadDB(T result);
}
