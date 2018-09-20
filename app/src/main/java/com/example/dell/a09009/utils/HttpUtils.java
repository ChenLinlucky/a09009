package com.example.dell.a09009.utils;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;

public class HttpUtils {
    private final OkHttpClient okHttpClient;
    private static HttpUtils httpUtils;


    public HttpUtils(){
        okHttpClient = new OkHttpClient();
    }

    public static HttpUtils getinstance() {
        if(httpUtils==null){
            httpUtils = new HttpUtils();
            synchronized (HttpUtils.class){
                if(httpUtils==null){
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }
    public void getdata(String path, Callback callback){
        Request request = new Request.Builder().url(path).build();
        Call call = okHttpClient.newCall(request);
        call.enqueue(callback);
    }

}
