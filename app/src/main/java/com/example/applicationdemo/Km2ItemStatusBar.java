package com.example.applicationdemo;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;

/**
 * Created by 刘乙镔 on 2017/10/11.
 */

public class Km2ItemStatusBar extends LinearLayout {

    private TextView textViewDK;
    private TextView textViewCF;
    private TextView textViewPD;
    private TextView textViewZJ;
    private TextView textViewQX;
    private Boolean dkIsFinished;
    private Boolean cfIsFinished;
    private Boolean pdIsFinished;
    private Boolean zjIsFinished;
    private Boolean qxIsFinished;

    public Km2ItemStatusBar(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        LayoutInflater.from(context).inflate(R.layout.item_status_botton,this,true);
        textViewDK = (TextView) findViewById(R.id.text_view_dk);
        textViewCF = (TextView) findViewById(R.id.text_view_cf);
        textViewPD = (TextView) findViewById(R.id.text_view_pd);
        textViewZJ = (TextView) findViewById(R.id.text_view_zj);
        textViewQX = (TextView) findViewById(R.id.text_view_qx);

        TypedArray attributes = context.obtainStyledAttributes(attrs,R.styleable.Km2ItemStatusBar);
        if(attributes != null){
            dkIsFinished = attributes.getBoolean(R.styleable.Km2ItemStatusBar_dk_is_finished,false);
            setItemIsFinished(dkIsFinished,textViewDK);

            cfIsFinished = attributes.getBoolean(R.styleable.Km2ItemStatusBar_cf_is_finished,false);
            setItemIsFinished(cfIsFinished,textViewCF);
            pdIsFinished = attributes.getBoolean(R.styleable.Km2ItemStatusBar_pd_is_finished,false);
            setItemIsFinished(pdIsFinished,textViewPD);
            zjIsFinished = attributes.getBoolean(R.styleable.Km2ItemStatusBar_zj_is_finished,false);
            setItemIsFinished(zjIsFinished,textViewZJ);
            qxIsFinished = attributes.getBoolean(R.styleable.Km2ItemStatusBar_qx_is_finished,false);
            setItemIsFinished(qxIsFinished,textViewQX);

            attributes.recycle();
        }



    }

    private void setItemIsFinished(Boolean finished,TextView itemTextView){
        if(finished){
            itemTextView.setTextColor(getResources().getColor(R.color.bottomLineColor));
            Drawable drawableBottom = getResources().getDrawable(R.drawable.bottom_blue);
            drawableBottom.setBounds(0, 0, drawableBottom.getMinimumWidth(), drawableBottom.getMinimumHeight());
            itemTextView.setCompoundDrawables(null,null,null,drawableBottom);
        }else{
            itemTextView.setTextColor(Color.WHITE);
            Drawable drawableBottom = getResources().getDrawable(R.drawable.bottom_white);
            drawableBottom.setBounds(0, 0, drawableBottom.getMinimumWidth(), drawableBottom.getMinimumHeight());
            itemTextView.setCompoundDrawables(null,null,null,drawableBottom);
        }
    }

}
