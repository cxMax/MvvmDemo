package com.cxmax.mvvmdemo.config;

/**
 * @Author CaiXi on  2016/8/26 00:43.
 * @Github: https://github.com/cxMax
 * @Description
 */
public interface Constants {

    String APP_NAME = "MvvmDemo";    // 项目名

    String ENTER = "\r\n"; //回车换行

    int DISPLAYW = BaseApplication.getInstance().getResources().getDisplayMetrics().widthPixels; //屏幕的宽

    int DISPLAYH = BaseApplication.getInstance().getResources().getDisplayMetrics().widthPixels; //屏幕的高

    float DENSITY = BaseApplication.getInstance().getResources().getDisplayMetrics().density;

    //具体业务模块的常量
    interface XxxMoudle{

    }
}
