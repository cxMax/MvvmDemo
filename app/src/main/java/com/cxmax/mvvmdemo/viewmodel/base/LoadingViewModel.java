package com.cxmax.mvvmdemo.viewmodel.base;

import android.databinding.ObservableBoolean;
import android.databinding.tool.util.L;
import android.support.design.widget.Snackbar;
import android.view.View;

import com.cxmax.mvvmdemo.config.BaseApplication;
import com.cxmax.mvvmdemo.utils.NetworkUtil;

/**
 * @Author CaiXi on  2016/9/6 00:04.
 * @Github: https://github.com/cxMax
 * @Description
 */
public abstract class LoadingViewModel extends BaseViewModel{

    public final ObservableBoolean showLoading = new ObservableBoolean(false);
    public final ObservableBoolean noDataRetry = new ObservableBoolean(false);
    public final ObservableBoolean noNetwork = new ObservableBoolean(false);

    public LoadingViewModel(ActivityBaseViewBinding activityBaseViewBinding) {
        super(activityBaseViewBinding);
        mActivityBaseViewBinding.setLoading(this);
    }

    public void showLoading(){
        L.e("loading........");
        L.e(showLoading + "-------------------");
        showLoading.set(true);
        noDataRetry.set(false);
    }

    public void hideLoading(){
        L.e("hide loading......");
        showLoading.set(false);
        noDataRetry.set(false);
    }

    public void showNoDataRetry(){
        showLoading.set(false);
        noDataRetry.set(true);
    }

    public void showNoNetwork(){
        showLoading.set(false);
        noDataRetry.set(false);
        noNetwork.set(true);
    }

    public void checkNetwork(){
        showLoading();
        if (NetworkUtil.isNotAvailable(BaseApplication.getContext())) {
            L.e("没有网络.....");
            Snackbar.make(mActivityBaseViewBinding.clContainer,"没有网络，请稍候重试！",Snackbar.LENGTH_INDEFINITE).setAction("x", v -> {
                L.e("===========================");
            }).show();
            hideLoading();
            showNoNetwork();
            return;
        }
    }

    /**
     * 请求重试（备用）
     * @return
     */
    public abstract View.OnClickListener onRetryClick();

    /**
     * Activity onDestroy时调用，用来取消Activity Rx订阅等等清理工作
     */
    public abstract void onActivityDestroy();
}
