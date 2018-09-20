package com.example.yingyuan.di;

import com.example.yingyuan.bean.news;

import java.util.List;

public interface icontrct {
     interface iview{
        void data(List<news.ResultBean.NearbyCinemaListBean> nearbyCinemaList);
    }
     interface ipresenter<iview>{
        void attchview(iview iview);
        void datachview(iview iview);
        void requestinfo();
    }
    interface imoudle{
        interface callisten{
            void responsemsg(List<news.ResultBean.NearbyCinemaListBean> nearbyCinemaList);
        }
        void requestdata(callisten callisten);
    }
}
