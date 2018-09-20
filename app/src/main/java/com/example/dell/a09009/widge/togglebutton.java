package com.example.dell.a09009.widge;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.dell.a09009.R;


public class togglebutton extends LinearLayout{
    private Button jia;
    private Button jian;
    private TextView text_num;
    private int num=1;
    public togglebutton(Context context) {
        super(context);
    }

    public togglebutton(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.include3,this);
        jia = findViewById(R.id.jia);
        jian = findViewById(R.id.jian);
        text_num = findViewById(R.id.text_num);
        jia.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num++;
                text_num.setText(num+"");
                if(jiajian!=null){
                    jiajian.getnum(num);
                }
            }
        });
        jian.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                num--;
                if(num<=0){
                    Toast.makeText(getContext(),"数量不能小于1",Toast.LENGTH_SHORT).show();
                    num=1;
                }
                text_num.setText(num+"");
            }
        });

    }

    public togglebutton(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    private jiajian jiajian;
    public interface jiajian{
        void getnum(int num);
    }

}
