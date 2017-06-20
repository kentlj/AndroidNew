package com.learn.swiperefreshlayout;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by yui on 2017/12/4.
 */

class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {
    private List mList;
    private LayoutInflater layoutInflater;

    public MyAdapter(Context ctx, List list) {
        mList = list;
        layoutInflater = LayoutInflater.from(ctx);
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ViewHolder holder = new ViewHolder(layoutInflater.inflate(android.R.layout.simple_list_item_1, parent, false));
        return holder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.tv.setText((String)mList.get(position));

    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tv;
        public ViewHolder(View itemView) {
            super(itemView);
            tv = (TextView)itemView;


        }
    }
}
