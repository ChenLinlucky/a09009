package com.example.dell.a09009.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.LinearLayout;

import com.example.dell.a09009.R;
import com.example.dell.a09009.bean.news;

import java.util.List;

public class OutAdapter extends RecyclerView.Adapter<OutAdapter.oneHolder>{
    private Context context;
    private List<news.DataBean> list;
    public OutAdapter(Context context, List<news.DataBean> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public oneHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.include1, null);
        oneHolder oneHolder = new oneHolder(view);
        return oneHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull oneHolder holder, int position) {
        holder.cb_02.setChecked(list.get(position).isOutchecked());
        holder.cb_02.setText(list.get(position).getSellerName());

        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        holder.recycleview01.setLayoutManager(manager);
        InnerAdapter innerAdapter = new InnerAdapter(context,list.get(position).getList());
        holder.recycleview01.setAdapter(innerAdapter);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    //创建视图
    class oneHolder extends RecyclerView.ViewHolder{

        private final CheckBox cb_02;
        private final RecyclerView recycleview01;

        public oneHolder(View itemView) {
            super(itemView);
            cb_02 = itemView.findViewById(R.id.cb_02);
            recycleview01 = itemView.findViewById(R.id.recycleview01);
        }
    }

}
