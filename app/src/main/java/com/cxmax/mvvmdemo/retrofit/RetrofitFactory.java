package com.cxmax.mvvmdemo.retrofit;

import com.cxmax.mvvmdemo.BuildConfig;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @Author CaiXi on  2016/8/27 01:18.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class RetrofitFactory {

    private static final String BASE_URL = ""; //正式环境服务器url
    private static final String DEV_BASE_URL = ""; //测试环境服务器url
    private static String mBaseUrl;

    static{
        mBaseUrl = BuildConfig.DEBUG ? DEV_BASE_URL : BASE_URL;
    }

    private RetrofitFactory(){}

    public static Object create(Class clazz){
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor();
        loggingInterceptor.setLevel(BuildConfig.DEBUG ?
                HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.BASIC);
        HeaderInterceptor headerInterceptor = new HeaderInterceptor();
        okHttpClient.addInterceptor(headerInterceptor);
        okHttpClient.addInterceptor(loggingInterceptor);

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .baseUrl(mBaseUrl).client(okHttpClient.build()).build();
        return retrofit.create(clazz);
    }
}
