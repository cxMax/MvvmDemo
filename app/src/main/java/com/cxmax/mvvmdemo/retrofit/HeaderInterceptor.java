package com.cxmax.mvvmdemo.retrofit;

import android.databinding.tool.util.L;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * @Author CaiXi on  2016/8/27 01:26.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class HeaderInterceptor implements Interceptor{

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request request = chain.request();
        L.e("为http请求添加Header");
        request = request.newBuilder()
                .addHeader("OS","Android")
                .addHeader("AppId","123")
                .build();
        Response response = chain.proceed(request);
        return response;
    }
}
