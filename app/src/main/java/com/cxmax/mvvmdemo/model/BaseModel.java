package com.cxmax.mvvmdemo.model;

import java.io.Serializable;

/**
 * @Author CaiXi on  2016/8/27 01:13.
 * @Github: https://github.com/cxMax
 * @Description 各databinding绑定数据实体基类
 */
public class BaseModel extends BaseEntity implements Serializable{

    private String mErrcode;

    public String getErrcode() {
        return mErrcode;
    }

    public void setErrcode(String errcode) {
        this.mErrcode = errcode;
    }
}
