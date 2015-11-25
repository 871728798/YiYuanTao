package com.qianfeng.yiyuantao.custom;

import android.content.Context;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;

import com.qianfeng.yiyuantao.R;

/**
 * Created by Lee on 2015/11/25.
 */
public class PrizeDetailView extends RelativeLayout{
    public PrizeDetailView(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_prize_detail,this,true);
    }

}
