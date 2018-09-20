package com.example.yingyuan.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.dell.a09009.R;
import com.example.yingyuan.adapter.MyAdapter;
import com.example.yingyuan.adapter.SimpleAdapter;
import com.example.yingyuan.bean.news;
import com.example.yingyuan.di.icontrct;
import com.example.yingyuan.di.presenterimp;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

import java.util.List;

@ContentView(R.layout.activity_main)//1
public class MainActivity extends AppCompatActivity implements icontrct.iview {


    private RecyclerView recy_view;
    private presenterimp presenterimp;
    private ImageView img1;
    private ImageView img2;
    private SimpleAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);//2

        recy_view = findViewById(R.id.recy_view);
        img1 = findViewById(R.id.img1);
        img2 = findViewById(R.id.img2);
        presenterimp = new presenterimp();
        presenterimp.attchview(this);
        presenterimp.requestinfo();
        img1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapter.notifyDataSetChanged();
            }
        });
        img2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recy_view.setLayoutManager(new GridLayoutManager(MainActivity.this,2));
                adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterimp.datachview(this);
    }

    @Override
    public void data(final List<news.ResultBean.NearbyCinemaListBean> nearbyCinemaList) {
        runOnUiThread(new Runnable() {



            @Override
            public void run() {
                Toast.makeText(MainActivity.this, "s:" + nearbyCinemaList, Toast.LENGTH_SHORT).show();
                /*LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recy_view.setLayoutManager(manager);
                MyAdapter adapter = new MyAdapter(MainActivity.this, nearbyCinemaList);
                recy_view.setAdapter(adapter);*/
                recy_view.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                adapter = new SimpleAdapter(MainActivity.this,nearbyCinemaList);
                recy_view.setAdapter(adapter);

            }
        });
    }
}
