package com.cxmax.mvvmdemo.config;

import android.app.Application;
import android.content.Context;

import com.cxmax.mvvmdemo.rxjava.RxJavaExecutionHook;
import com.squareup.picasso.LruCache;
import com.squareup.picasso.Picasso;

import rx.plugins.RxJavaPlugins;

/**
 * Created by CaiXi on 2016/8/25.
 * https://github.com/cxMax
 */
public class BaseApplication extends Application{
    private static Context mApplicationContext;
    private static BaseApplication mInstance = null;
    private Picasso mPicasso = null;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
        mApplicationContext = getApplicationContext();
        RxJavaPlugins.getInstance().registerObservableExecutionHook(new RxJavaExecutionHook());
    }

    /**
     * 获取Picasso对象
     */
    public Picasso getPicasso() {
        if (null == mPicasso){
            cancelPicassoCache();
        }
        return mPicasso;
    }

    /**
     * 清除Picasso缓存并创建对象
     */
    public void cancelPicassoCache() {
        if (null != mPicasso)
            mPicasso = null;
        LruCache lruCache = new LruCache(mApplicationContext);
        lruCache.clear();
        Picasso.Builder builder = new Picasso.Builder(mApplicationContext).memoryCache(lruCache);
        lruCache.clear();
        mPicasso = builder.build();
    }

    public static Context getContext() {
        return mApplicationContext;
    }

    public static BaseApplication getInstance(){
        return mInstance;
    }
}
