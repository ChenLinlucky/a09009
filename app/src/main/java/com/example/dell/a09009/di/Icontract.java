package com.example.dell.a09009.di;

public interface Icontract {
    interface iview{
        void data(String s);
    }
    interface ipresenterimp<iview>{
        void attchview(iview iview);
        void datachview(iview iview);
        void requestinfo();
    }
    interface imoudleimp{
        interface callisten{
            void requestmsg(String s);
        }
        void requestdata(callisten callisten);
    }
}
