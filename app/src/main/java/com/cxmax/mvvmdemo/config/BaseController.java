package com.cxmax.mvvmdemo.config;

import android.os.Handler;
import android.os.Looper;

import com.cxmax.mvvmdemo.config.manager.CacheManager;
import com.cxmax.mvvmdemo.config.manager.ConfigXML;
import com.cxmax.mvvmdemo.config.manager.PageManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author CaiXi on  2016/8/26 01:20.
 * @Github: https://github.com/cxMax
 * @Description 整体控制器
 */
public class BaseController {

    private static BaseController mInstance;

    /**
     * Hanldr Looper
     */
    public static Handler mMainHandler = new Handler(Looper.getMainLooper());

    /**
     * 存储所有页面Handler键值对
     * key:getClass().getCanonicalName()
     * value:页面Handler
     * !注意页面销毁时remove掉!
     */
    private Map<String, Handler> handlerMap = new HashMap<String, Handler>();

    /**
     * 缓存管理类
     */
    private CacheManager cacheManager;

    /**
     * 页面管理类
     */
    private PageManager pageManager;
    /**
     * 本地XML配置文件
     */
    private ConfigXML configXml;

    private BaseController(){
        // 缓存管理初始化
        cacheManager = new CacheManager(this);
        // 界面管理初始化
        pageManager = new PageManager();
        configXml = new ConfigXML(this);
    }

    public static BaseController getInstance(){
        if (mInstance == null){
            synchronized (BaseController.class){
                if (mInstance == null){
                    mInstance = new BaseController();
                }
            }
        }
        return mInstance;
    }

    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public PageManager getPageManager() {
        return pageManager;
    }

    public ConfigXML getConfigXml() {
        return configXml;
    }
}
