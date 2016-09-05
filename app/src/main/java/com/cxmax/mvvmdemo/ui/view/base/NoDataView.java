package com.cxmax.mvvmdemo.ui.view.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.cxmax.mvvmdemo.R;

/**
 * @Author CaiXi on  2016/9/6 00:56.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class NoDataView extends LinearLayout {

    private NoDataViewBinding mNoDataViewBinding;

    public NoDataView(Context context) {
        super(context);
        init(context);
    }

    public NoDataView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public NoDataView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mNoDataViewBinding = DataBindingUtil.inflate((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), R.layout.no_data_view, this, false);
        addView(mNoDataViewBinding.getRoot());
    }

    public void setText(CharSequence desc) {
        mNoDataViewBinding.noDataTextview.setText(desc);
    }

    public void setColor(int color) {
        mNoDataViewBinding.noDataTextview.setTextColor(color);
    }

    public void setSize(float size) {
        mNoDataViewBinding.noDataTextview.setTextSize(size);
    }

    public String getText() {
        return mNoDataViewBinding.noDataTextview.getText().toString();

    }
}
