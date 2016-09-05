package com.cxmax.mvvmdemo.viewmodel.base;

import android.databinding.Bindable;

import com.cxmax.mvvmdemo.BR;
import com.cxmax.mvvmdemo.ui.view.recyclerview.DataBindingRecyclerView;

import java.util.ArrayList;

/**
 * @Author CaiXi on  2016/9/6 00:04.
 * @Github: https://github.com/cxMax
 * @Description
 */
public abstract class AbsRecyclerViewModel extends LoadingViewModel {

    @Bindable
    public List<T> data = new ArrayList<>();

    @Bindable
    public int footerStatus = DataBindingRecyclerView.SHOW_FOOTER;

    @Bindable
    public boolean loading = false;

    public AbsRecyclerViewModel(ActivityBaseViewBinding activityBaseViewBinding) {
        super(activityBaseViewBinding);
    }
    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getFooterStatus() {
        return footerStatus;
    }

    public void setFooterStatus(int footerStatus) {
        this.footerStatus = footerStatus;
    }

    public void setLoading(boolean loading) {
        this.loading = loading;
    }

    public boolean isLoading() {
        return loading;
    }

    public void requestData() {
        loading = true;
        notifyPropertyChanged(BR.loading);
    }

    public void onRequestFinished() {
        loading = false;
        notifyPropertyChanged(BR.loading);
    }

    public void onRequestSuccess(List<T> list) {
        if (list.size() < 20) {
            footerStatus = DataBindingRecyclerView.HIDE_FOOTER;
        } else {
            footerStatus = DataBindingRecyclerView.SHOW_FOOTER;
        }
        if (data != null) {
            data.clear();
        }
        data.addAll(list);
        notifyPropertyChanged(BR.data);
    }
}
