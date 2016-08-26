package com.cxmax.mvvmdemo.config.manager;

import android.app.Activity;
import android.databinding.tool.util.L;

import java.util.Stack;

/**
 * @Author CaiXi on  2016/8/27 00:55.
 * @Github: https://github.com/cxMax
 * @Description 堆栈管理Activity页面
 */
public class PageManager {

    private static Stack<Activity> mPageStack;

    public static Activity getCurrentActivity(){
        return mPageStack.peek();
    }

    public PageManager() {
        mPageStack = new Stack<>();
    }

    /**
     * 移除页面对象
     *
     * @param activity 页面对象
     */
    public void removePage(Activity activity) {
        if (activity != null) {
            activity.finish();
            mPageStack.remove(activity);
            L.d( "PageManager.removePage 移除页面:" + activity.getClass().getName());
        }
    }

    /**
     * 添加新页面
     *
     * @param activity 页面对象
     */
    public void addPage(Activity activity) {
        if (!mPageStack.contains(activity)) {
            mPageStack.add(activity);
            L.d("PageManager.addPage 添加新页面:" + activity.getClass().getName());
        } else {
            L.d("PageManager.addPage 页面已存在");
        }
    }

    /**
     * 页面清理
     */
    public void clearPage() {
        int size = mPageStack.size();
        for (int i = 0; i < size; i++) {
            mPageStack.get(i).finish();
        }
        mPageStack.clear();
    }
}
