package com.example.yingyuan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.example.dell.a09009.R;
import com.example.yingyuan.bean.news;
import com.example.yingyuan.holder.SimpleViewHolder;

import java.util.List;

public class SimpleAdapter extends RecyclerView.Adapter<SimpleViewHolder>{
    private Context context;
    private List<news.ResultBean.NearbyCinemaListBean> list;
    public SimpleAdapter(Context context, List<news.ResultBean.NearbyCinemaListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public SimpleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.simple, parent, false);
        return new SimpleViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SimpleViewHolder holder, int position) {
        holder.address.setText(list.get(position).getAddress());
        holder.km.setText(list.get(position).getDistance()+"");
        String[] split = list.get(position).getLogo().split("\\|");
        Glide.with(context).load(split[0]).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}
