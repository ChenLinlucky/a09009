package com.example.yingyuan.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dell.a09009.R;

public class SimpleViewHolder extends RecyclerView.ViewHolder{

    public ImageView img;
    public TextView address,km;
    public SimpleViewHolder(View itemView) {
        super(itemView);
        img = itemView.findViewById(R.id.img);
        address = itemView.findViewById(R.id.address);
        km = itemView.findViewById(R.id.km);
    }
}
