package com.cxmax.mvvmdemo.ui.base;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

import com.cxmax.mvvmdemo.config.BaseController;

/**
 * @Author CaiXi on  2016/8/29 01:10.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class BaseActivity extends AppCompatActivity {
    public BaseController mController;
    public Toast toast;

    @Override
    public void onCreate(Bundle savedInstanceState, PersistableBundle persistentState) {
        super.onCreate(savedInstanceState, persistentState);
        mController = BaseController.getInstance();
        mController.getPageManager().addPage(this);
    }
}
