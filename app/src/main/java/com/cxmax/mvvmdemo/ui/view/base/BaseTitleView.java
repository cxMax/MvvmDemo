package com.cxmax.mvvmdemo.ui.view.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
/**
 * @Author CaiXi on  2016/9/6 00:57.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class BaseTitleView {
    private BaseTitleViewBinding mBaseTitleViewBinding;

    public BaseTitleView(Context context) {
        super(context);
        init(context);
    }

    public BaseTitleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public BaseTitleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        mBaseTitleViewBinding = DataBindingUtil.inflate((LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE), R.layout.base_title_view, this, false);
        addView(mBaseTitleViewBinding.getRoot());
    }

    public void setLeftIcon(int drawableResId){
        mBaseTitleViewBinding.tvBaseTitleLeft.setCompoundDrawablesWithIntrinsicBounds(drawableResId, 0, 0, 0);
    }

    public void setRightIcon(int drawableResId){
        mBaseTitleViewBinding.tvBaseTitleRight.setCompoundDrawablesWithIntrinsicBounds(drawableResId, 0, 0, 0);
    }

    public void setTitle(String title){
        mBaseTitleViewBinding.tvBaseTitle.setText(title);
    }

    public void hideLeftIcon(){
        mBaseTitleViewBinding.tvBaseTitleLeft.setVisibility(INVISIBLE);
    }

    public void hideRightIcon(){
        mBaseTitleViewBinding.tvBaseTitleRight.setVisibility(INVISIBLE);
    }

    public void showLeftIcon(){
        mBaseTitleViewBinding.tvBaseTitleLeft.setVisibility(VISIBLE);
    }

    public void showRightIcon(){
        mBaseTitleViewBinding.tvBaseTitleRight.setVisibility(VISIBLE);
    }

    public void setLeftButtonClickListener(OnClickListener listener){
        if (listener != null) {
            mBaseTitleViewBinding.tvBaseTitleLeft.setOnClickListener(listener);
        }
    }

    public void setRightButtonClickListener(OnClickListener listener){
        if (listener != null) {
            mBaseTitleViewBinding.tvBaseTitleRight.setOnClickListener(listener);
        }
    }
}
