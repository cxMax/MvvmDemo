package com.cxmax.mvvmdemo.ui.view.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author CaiXi on  2016/9/6 00:44.
 * @Github: https://github.com/cxMax
 * @Description
 */
public abstract class AbsRecyclerViewAdapter<T,VH extends RecyclerView.ViewHolder> extends RecyclerView.Adapter<VH>  {

    public Context mContext;
    public List<T> data = new ArrayList();
    public final LayoutInflater layoutInflater;
    public AbsRecyclerViewAdapter.OnItemClickListener onItemClickListener;
    public AbsRecyclerViewAdapter.OnItemLongClickListener onItemLongClickListener;

    public void setOnItemClickListener(AbsRecyclerViewAdapter.OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public void setOnItemLongClickListener(AbsRecyclerViewAdapter.OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }



    public AbsRecyclerViewAdapter(Context context, List<T> data) {
        this.mContext = context;
        this.data = data;
        this.layoutInflater = LayoutInflater.from(context);
    }

    public LayoutInflater getLayoutInflater() {
        return this.layoutInflater;
    }

    public int getItemCount() {
        return data == null ? 0 : data.size();
    }

    public void onBindViewHolder(VH holder, final int position) {
        if(holder.itemView != null) {
            if(this.onItemClickListener != null) {
                holder.itemView.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View v) {
                        AbsRecyclerViewAdapter.this.onItemClickListener.onItemClick(v, position);
                    }
                });
            }

            if(this.onItemLongClickListener != null) {
                holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    public boolean onLongClick(View v) {
                        AbsRecyclerViewAdapter.this.onItemLongClickListener.onItemLongClick(v, position);
                        return false;
                    }
                });
            }
        }

    }

    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    public void onViewRecycled(VH holder) {
        super.onViewRecycled(holder);
    }

    public interface OnItemLongClickListener {
        void onItemLongClick(View var1, int var2);
    }

    public interface OnItemClickListener {
        void onItemClick(View view, int position);
    }
}
