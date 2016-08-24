package com.cxmax.mvvmdemo.rxjava;

import android.databinding.tool.util.L;

import com.cxmax.mvvmdemo.config.BaseApplication;
import com.cxmax.mvvmdemo.utils.NetworkUtil;

import rx.Observable;
import rx.Subscription;
import rx.plugins.RxJavaObservableExecutionHook;

/**
 * @Author CaiXi on  2016/8/25 01:13.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class RxJavaExecutionHook extends RxJavaObservableExecutionHook{
    @Override
    public <T> Observable.OnSubscribe<T> onSubscribeStart(Observable<? extends T> observableInstance, Observable.OnSubscribe<T> onSubscribe) {
        L.e("RxJava 开始之前.....");
        if (NetworkUtil.isNotAvailable(BaseApplication.getContext())){
            L.e("当前没有网络....");
        }
        return super.onSubscribeStart(observableInstance, onSubscribe);
    }

    @Override
    public <T> Subscription onSubscribeReturn(Subscription subscription) {
        return super.onSubscribeReturn(subscription);
    }

    @Override
    public <T> Throwable onSubscribeError(Throwable e) {
        return super.onSubscribeError(e);
    }

}
