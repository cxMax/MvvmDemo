package com.cxmax.mvvmdemo.ui.view.recyclerview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

/**
 * @Author CaiXi on  2016/9/6 00:36.
 * @Github: https://github.com/cxMax
 * @Description
 */
public class LinearRecyclerView extends RecyclerView {

    private boolean isBottom;
    private boolean isTop;

    private int firstVisibleItem;
    private int visibleItemCount;
    private int totalItemCount;

    private LinearLayoutManager layoutManager;

    private OnScrollPositionListener onScrollPositionListener;

    public void setOnScrollPositionListener(OnScrollPositionListener listener) {
        onScrollPositionListener = listener;
    }

    public LinearRecyclerView(Context context) {
        super(context);
        init();
    }

    public LinearRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LinearRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    private void init() {
        layoutManager = new LinearLayoutManager(getContext());
        setLayoutManager(layoutManager);
        addOnScrollListener(new OnScrollListener() {
            @Override
            public void onScrollStateChanged(RecyclerView recyclerView, int newState) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE && onScrollPositionListener != null) {
                    if (isBottom) onScrollPositionListener.onScrollToBottom();
                    if (isTop) onScrollPositionListener.onScrollToTop();
                }
            }

            @Override
            public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
                if (onScrollPositionListener != null) {
                    visibleItemCount = recyclerView.getChildCount();
                    totalItemCount = layoutManager.getItemCount();
                    firstVisibleItem = layoutManager.findFirstVisibleItemPosition();

                    isBottom = (firstVisibleItem + visibleItemCount) >= (totalItemCount - 1);
                    isTop = firstVisibleItem == 0;
                }
            }
        });
    }

    public interface OnScrollPositionListener {

        void onScrollToTop();

        void onScrollToBottom();

    }
}
