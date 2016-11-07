package com.example.dllo.bibilala.mvp.presenter;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;

/**
 * 本类由: Risky 创建于: 15/10/29.
 * Presenter的基类,处理有可能出现的内存泄露
 * <p>泛型为View层的接口</p>
 */
public abstract class BasePresenter<T> {
    /** 定义一个引用 */
    protected Reference<T> mViewRef;

    /** 初始化弱引用对象 */
    public void attachView(T view) {
        mViewRef = new WeakReference<T>(view);
    }

    /** 获取View */
    protected T getView() {
        return mViewRef.get();
    }

    public boolean isViewAttached() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /** 清理 */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
