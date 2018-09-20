package com.example.dell.a09009.di;

import java.lang.ref.WeakReference;

public class Presenterimp implements Icontract.ipresenterimp<Icontract.iview> {
    private Icontract.iview iview;
    private Moudleimp moudleimp;
    private WeakReference<Icontract.iview> iviewWeakReference;
    private WeakReference<Icontract.imoudleimp> imoudleimpWeakReference;

    @Override
    public void attchview(Icontract.iview iview) {
        this.iview=iview;
        moudleimp = new Moudleimp();
        iviewWeakReference = new WeakReference<>(iview);
        imoudleimpWeakReference = new WeakReference<Icontract.imoudleimp>(moudleimp);
    }

    @Override
    public void datachview(Icontract.iview iview) {
        iviewWeakReference.clear();
        imoudleimpWeakReference.clear();
    }

    @Override
    public void requestinfo() {
        moudleimp.requestdata(new Icontract.imoudleimp.callisten() {
            @Override
            public void requestmsg(String s) {
                iview.data(s);
            }
        });
    }
}
