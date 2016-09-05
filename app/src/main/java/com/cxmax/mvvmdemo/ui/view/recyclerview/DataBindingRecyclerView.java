package com.cxmax.mvvmdemo.ui.view.recyclerview;

import android.databinding.BindingAdapter;
import android.databinding.tool.util.L;
import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import android.widget.TextView;

import com.cxmax.mvvmdemo.R;
import com.cxmax.mvvmdemo.config.BaseApplication;
import com.cxmax.mvvmdemo.model.BaseEntity;
import com.squareup.picasso.Picasso;

import java.util.List;

/**
 * @Author CaiXi on  2016/9/6 00:32.
 * @Github: https://github.com/cxMax
 * @Description 数据绑定工具类
 */
public class DataBindingRecyclerView {

    public static int SHOW_FOOTER = 0;

    public static int HIDE_FOOTER = 1;

    @BindingAdapter({"imageUrl"})
    public static void loadImage(ImageView view, String url) {
        Picasso.with(BaseApplication.getContext()).load(url).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(view);
    }

    @BindingAdapter({"imageUrl","placeholder"})
    public static void loadImage(ImageView view, String url, Drawable resourceId) {
        Picasso.with(BaseApplication.getContext()).load(url).placeholder(resourceId).error(resourceId).into(view);
    }

    @BindingAdapter({"adapter"})
    public static void bindAdapter(BaseRecyclerView recyclerView, AbsRecyclerViewAdapter adapter) {
        recyclerView.setAdapter(adapter);
        recyclerView.setPageFooter(R.layout.layout_loading_footer);
    }

    @BindingAdapter({"data"})
    public static void bindData(BaseRecyclerView recyclerView, List<BaseEntity> data) {
        recyclerView.notifyDataSetChanged();
        recyclerView.setIsLoading(false);
    }

    @BindingAdapter({"isLoading"})
    public static void isLoading(BaseRecyclerView recyclerView, boolean isLoading) {
        recyclerView.setIsLoading(isLoading);
    }

    @BindingAdapter({"footerStatus"})
    public static void footerStatus(BaseRecyclerView recyclerView, int footerStatus) {
        if (footerStatus == SHOW_FOOTER) {
            recyclerView.setPageEnable(true);
            recyclerView.showLoadingFooter();
        } else {
            recyclerView.setPageEnable(false);
            recyclerView.removePageFooter();
        }
    }

    @BindingAdapter({"setSelected"})
    public static void setTextSelected(TextView textView, boolean selected){
        L.e("============setSelected===========" + selected);
        textView.setTextColor(selected ? BaseApplication.getContext().getResources().getColor(R.color.colorPrimary) : BaseApplication.getContext().getResources().getColor(R.color.textPrimary));
        textView.setBackgroundColor(selected ? BaseApplication.getContext().getResources().getColor(R.color.background) : BaseApplication.getContext().getResources().getColor(R.color.white));
    }
}
