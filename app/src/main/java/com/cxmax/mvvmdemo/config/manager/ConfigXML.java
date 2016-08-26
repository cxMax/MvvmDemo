package com.cxmax.mvvmdemo.config.manager;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.cxmax.mvvmdemo.config.BaseApplication;
import com.cxmax.mvvmdemo.config.BaseController;

/**
 * @Author CaiXi on  2016/8/27 00:45.
 * @Github: https://github.com/cxMax
 * @Description 本地存储类，保存与userId相关的属性
 */
public class ConfigXML {

    /**
     * SharedPreference的 存储类和编辑类对象
     */
    private SharedPreferences mShare;
    private Editor mEditor;

    /**
     * 存储的全局的SharedPreferences文件名
     */
    private final static String KKLINK = "com.cxmax.mvvmdemo";

    /**
     * 读写权限
     */
    private final static int MODE = Context.MODE_PRIVATE;

    private BaseController mController;

    public ConfigXML(BaseController controller){
        this.mController = controller;
        mShare = BaseApplication.getInstance().getSharedPreferences(KKLINK , MODE);
        mEditor = mShare.edit();
    }

    public int read(String key, int back) {
        //// TODO: 2016/8/27 userId 根据具体情景获取
        int userid = 0;
        int result = mShare.getInt(userid + key, back);
        return result;
    }

    public boolean save(String key, int value) {
        int userid = 0;
//        int userid = controller.getCacheManager().getLoginUser().id;
        mEditor.putInt(userid + key, value);
        return mEditor.commit();
    }

    public long read(String key, long back) {
        long result = mShare.getLong(key, back);
        return result;
    }

    public boolean save(String key, long value) {
        mEditor.putLong(key, value);
        return mEditor.commit();
    }

    public float read(String key, float back) {
        float result = mShare.getFloat(key, back);
        return result;
    }

    public boolean save(String key, float value) {
        mEditor.putFloat(key, value);
        return mEditor.commit();
    }

    /**
     * 读取String型数据
     *
     * @param key 所读取的数据的键值
     * @param back 如果所读取数据的键值不存在，那么返回此默认值
     * @return String
     */
    public String read(String key, String back) {
        int userid = 0;
//        int userid = controller.getCacheManager().getLoginUser().id;
        String result = mShare.getString(userid + key, back);
        return result;
    }

    /**
     * 保存Boolean型数据
     *
     * @param key 数据键名
     * @param value 数据键值
     * @return boolean
     */
    public boolean save(String key, Boolean value) {
        int userid = 0;
//        int userid = controller.getCacheManager().getLoginUser().id;
        mEditor.putBoolean(userid + key, value);
        return mEditor.commit();
    }

    /**
     * 读取Boolean型数据
     *
     * @param key 所读取的数据的键值
     * @param back 如果所读取数据的键值不存在，那么返回此默认值
     * @return boolean
     */
    public Boolean read(String key, Boolean back) {
        int userid = 0;
//        int userid = controller.getCacheManager().getLoginUser().id;
        Boolean result = mShare.getBoolean(userid + key, back);
        return result;
    }
}
