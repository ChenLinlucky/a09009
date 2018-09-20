package com.example.yingyuan.di;

import com.example.yingyuan.bean.news;

import java.lang.ref.WeakReference;
import java.util.List;

public class presenterimp implements icontrct.ipresenter<icontrct.iview>{
    private icontrct.iview iview;
    private moudelimp moudelimp;
    private WeakReference<icontrct.iview> iviewWeakReference;
    private WeakReference<icontrct.imoudle> imoudleWeakReference;

    @Override
    public void attchview(icontrct.iview iview) {
        this.iview=iview;
        moudelimp = new moudelimp();
        iviewWeakReference = new WeakReference<>(iview);
        imoudleWeakReference = new WeakReference<icontrct.imoudle>(moudelimp);
    }

    @Override
    public void datachview(icontrct.iview iview) {
        iviewWeakReference.clear();
        imoudleWeakReference.clear();
    }

    //请求方法---通过M层
    @Override
    public void requestinfo() {
       moudelimp.requestdata(new icontrct.imoudle.callisten() {
           @Override
           public void responsemsg(List<news.ResultBean.NearbyCinemaListBean> nearbyCinemaList) {
               iview.data(nearbyCinemaList);
           }
       });


    }
}
