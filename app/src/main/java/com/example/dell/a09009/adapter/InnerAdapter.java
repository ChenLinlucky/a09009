package com.example.dell.a09009.adapter;

import android.content.Context;
import android.media.Image;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.dell.a09009.R;
import com.example.dell.a09009.bean.news;

import java.util.List;

public class InnerAdapter extends RecyclerView.Adapter<InnerAdapter.twoHolder>{
    private Context context;
    private List<news.DataBean.ListBean> list;
    public InnerAdapter(Context context, List<news.DataBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public twoHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.include2, null);
        twoHolder twoHolder = new twoHolder(view);
        return twoHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull twoHolder holder, int position) {
        holder.cb_03.setChecked(list.get(position).isInnerchecked());

        holder.price.setText("单价为"+list.get(position).getPrice());
        holder.shop_name.setText(""+list.get(position).getTitle());
        String[] split = list.get(position).getImages().split("\\|");
        Glide.with(context).load(split[0]).into(holder.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    //创建视图
    class twoHolder extends RecyclerView.ViewHolder{

        private final CheckBox cb_03;
        private final ImageView img;
        private final TextView price;
        private final TextView shop_name;

        public twoHolder(View itemView) {
            super(itemView);
            cb_03 = itemView.findViewById(R.id.cb_03);
            img = itemView.findViewById(R.id.img);
            shop_name = itemView.findViewById(R.id.shop_name);
            price = itemView.findViewById(R.id.price);
        }
    }
}
