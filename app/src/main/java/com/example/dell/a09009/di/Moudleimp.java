package com.example.dell.a09009.di;


import com.example.dell.a09009.bean.news;
import com.example.dell.a09009.utils.HttpUtils;
import com.google.gson.Gson;

import java.io.IOException;
import java.util.List;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;

public class Moudleimp implements Icontract.imoudleimp{
    private String path="http://www.zhaoapi.cn/product/getCarts?uid=71";
    @Override
    public void requestdata(final callisten callisten) {
        HttpUtils.getinstance().getdata(path, new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                String s = response.body().string();
                callisten.requestmsg(s);
            }
        });
    }
}
