package com.example.yingyuan.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.a09009.R;
import com.example.yingyuan.bean.news;

import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.oneHolder>{
    private Context context;
    private List<news.ResultBean.NearbyCinemaListBean> list;
    public MyAdapter(Context context, List<news.ResultBean.NearbyCinemaListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public oneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, null);
        oneHolder holder = new oneHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull oneHolder holder, int position) {
        holder.address.setText(list.get(position).getAddress());
        holder.km.setText(list.get(position).getDistance()+"km");

        String[] split = list.get(position).getLogo().split("\\|");
        Glide.with(context).load(split[0]).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

     class oneHolder extends RecyclerView.ViewHolder{

         private final ImageView img;
         private final TextView address;
         private final TextView km;

         public oneHolder(View itemView) {
             super(itemView);
             img = itemView.findViewById(R.id.img);
             address = itemView.findViewById(R.id.address);
             km = itemView.findViewById(R.id.km);
         }
     }
}
