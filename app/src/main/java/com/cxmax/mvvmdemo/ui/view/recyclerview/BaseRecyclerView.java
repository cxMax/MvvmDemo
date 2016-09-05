package com.cxmax.mvvmdemo.ui.view.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * @Author CaiXi on  2016/9/6 00:35.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class BaseRecyclerView extends LinearRecyclerView implements LinearRecyclerView.OnScrollPositionListener {
    private View loadingFooter;
    private boolean hasAttachedFooter;
    private boolean pageEnable;
    private boolean isLoading;
    private Bookends bookends;
    private OnLoadMoreListener mOnLoadMoreListener;
    private OnRefreshListener mOnRefreshListener;

    public BaseRecyclerView(Context context) {
        this(context , null);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs , 0);
    }

    public BaseRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        this.hasAttachedFooter = false;
        this.pageEnable = true;
        this.isLoading = false;
        this.init();
    }

    public void setPageEnable(boolean pageEnable) {
        this.pageEnable = pageEnable;
    }

    public boolean isLoading() {
        return this.isLoading;
    }

    public void setIsLoading(boolean b) {
        this.isLoading = b;
    }

    private void init() {
        this.setOnScrollPositionListener(this);
    }

    public void setOnLoadMoreListener(OnLoadMoreListener onLoadMoreListener) {
        this.mOnLoadMoreListener = onLoadMoreListener;
    }

    public void setOnRefreshListener(OnRefreshListener onRefreshListener) {
        this.mOnRefreshListener = onRefreshListener;
    }

    public void onScrollToTop() {
        if(this.pageEnable && this.mOnRefreshListener != null && !this.isLoading) {
            this.isLoading = true;
            this.mOnRefreshListener.onRefresh();
        }

    }

    public void onScrollToBottom() {
        if(this.pageEnable && this.mOnLoadMoreListener != null && !this.isLoading) {
            this.isLoading = true;
            this.mOnLoadMoreListener.onLoadMore();
        }

    }

    public void notifyDataSetChanged() {
        this.bookends.notifyDataSetChanged();
    }

    public void notifyItemInserted(int position) {
        this.bookends.notifyItemInserted(position);
    }

    public void notifyItemRemoved(int position) {
        this.bookends.notifyItemRemoved(position);
    }

    public void setAdapter(AbsRecyclerViewAdapter adapter) {
        this.bookends = new Bookends(adapter);
        super.setAdapter(this.bookends);
    }

    public void setAdapter(Bookends adapter) {
        super.setAdapter(adapter);
        this.bookends = adapter;
    }

    public Bookends<?> getBookendsAdapter() {
        return this.bookends;
    }

    public void addHeader(View view) {
        this.bookends.addHeader(view);
    }

    public void addFooter(View view) {
        this.bookends.addFooter(view);
    }

    public void setPageFooter(View view) {
        this.loadingFooter = view;
    }

    public void setPageFooter(int resId) {
        this.loadingFooter = LayoutInflater.from(this.getContext()).inflate(resId, (ViewGroup)null);
    }

    private void attachPageFooter() {
        if(this.loadingFooter != null && !this.hasAttachedFooter) {
            this.hasAttachedFooter = true;
            this.bookends.addFooter(this.loadingFooter);
            this.bookends.setFooterVisibility(this.loadingFooter, false);
        }

    }

    public void removePageFooter() {
        if(this.loadingFooter != null && this.hasAttachedFooter) {
            this.hasAttachedFooter = false;
            this.bookends.removeFooter(this.loadingFooter);
        }

    }

    public void showLoadingFooter() {
        if(!this.hasAttachedFooter) {
            this.attachPageFooter();
        }

        if(this.loadingFooter != null) {
            this.bookends.setFooterVisibility(this.loadingFooter, true);
        }

    }
}
