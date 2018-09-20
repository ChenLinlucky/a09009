package com.example.yingyuan.di;

import com.example.yingyuan.bean.news;
import com.example.yingyuan.utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class moudelimp implements icontrct.imoudle{
    private String path="http://172.17.8.100/movieApi/cinema/v1/findRecommendCinemas?longitude=116.30551391385724&latitude=40.04571807462411&page=1&count=10";

    @Override
    public void requestdata(final callisten callisten) {
        HttpUtils.getHttpUtils().getdata(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                Gson gson = new Gson();
                news news = gson.fromJson(s, news.class);
                List<com.example.yingyuan.bean.news.ResultBean.NearbyCinemaListBean> nearbyCinemaList = news.getResult().getNearbyCinemaList();
                callisten.responsemsg(nearbyCinemaList);
            }
        });

    }
}
