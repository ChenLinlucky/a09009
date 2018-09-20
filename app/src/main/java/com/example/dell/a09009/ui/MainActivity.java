package com.example.dell.a09009.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;

import com.example.dell.a09009.R;
import com.example.dell.a09009.adapter.OutAdapter;
import com.example.dell.a09009.bean.news;
import com.example.dell.a09009.di.Icontract;
import com.example.dell.a09009.di.Presenterimp;
import com.google.gson.Gson;

import java.util.List;

public class MainActivity extends AppCompatActivity implements Icontract.iview {

    private Presenterimp presenterimp;
    private RecyclerView recy_view;
    private CheckBox cb_01;
    private List<news.DataBean> data;
    private news news;
    private OutAdapter outAdapter;
    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recy_view = findViewById(R.id.recycleview);
        cb_01 = findViewById(R.id.cb_01);
        presenterimp = new Presenterimp();
        presenterimp.attchview(this);
        presenterimp.requestinfo();
        cb_01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cb_01.isChecked()){
                    for (int i = 0; i <news.getData().size() ; i++) {
                        news.getData().get(i).setOutchecked(true);
                        for (int j = 0; j <news.getData().get(i).getList().size() ; j++) {
                            news.getData().get(i).getList().get(j).setInnerchecked(true);
                        }
                    }
                }else {
                    for (int i = 0; i <news.getData().size() ; i++) {
                        news.getData().get(i).setOutchecked(false);
                        for (int j = 0; j <news.getData().get(i).getList().size() ; j++) {
                            news.getData().get(i).getList().get(j).setInnerchecked(false);
                        }
                    }

                }
                outAdapter.notifyDataSetChanged();
            }
        });
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenterimp.datachview(this);
    }

    @Override
    public void data(final String s) {
        runOnUiThread(new Runnable() {

           // private OutAdapter outAdapter;

            @Override
            public void run() {
                Gson gson = new Gson();
                 news = gson.fromJson(s, news.class);
                List<com.example.dell.a09009.bean.news.DataBean> data = news.getData();
                Toast.makeText(MainActivity.this, "data:" + data, Toast.LENGTH_SHORT).show();
                LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, LinearLayoutManager.VERTICAL, false);
                recy_view.setLayoutManager(manager);
                outAdapter = new OutAdapter(MainActivity.this, data);
                recy_view.setAdapter(outAdapter);
            }
        });
    }
}
