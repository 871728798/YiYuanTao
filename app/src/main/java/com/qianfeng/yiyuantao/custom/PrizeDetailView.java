package com.qianfeng.yiyuantao.custom;

import android.content.Context;
import android.graphics.Color;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.bean.PrizeDetailEntity;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;


/**
 * Created by Lee on 2015/11/25.
 */
public class PrizeDetailView extends RelativeLayout implements NetUtils.RequestCallCack {
    private static final String TAG = "print";
    private ImageView iv;
    private String prize_id;
    private String URL2;
    private TextView tv_user;
    private TextView tv_userip;
    private TextView tv_canyu;
    private TextView tv_lum;
    private TextView tv_time;

    public PrizeDetailView(Context context) {
        super(context);
        init();

    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_prize_detail, this, true);
        iv = (ImageView) findViewById(R.id.iv_user);
        tv_user = (TextView) findViewById(R.id.tv_user);
        tv_userip = (TextView) findViewById(R.id.tv_userip);
        tv_canyu = (TextView) findViewById(R.id.tv_canyu);
        tv_lum = (TextView) findViewById(R.id.tv_lum);
        tv_time = (TextView) findViewById(R.id.tv_time);

    }

    public void setPrizeId(String id) {
        prize_id = id;
        URL2 = "http://api.zhuquzhou.com/lottery/win_history_by_prize?prize_id=" + prize_id + "&android_id=d108148ee86fe036&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284044600645&mac=68:F7:28:F0:46:16&os_version=4.4.2&user_id=153825&";
        getDatas();

    }

    private void getDatas() {
        NetUtils.getDataFromNet(this, URL2);
    }


    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        // String result = responseInfo.result;
        // Log.d(TAG, "res---------" + result);
        PrizeDetailEntity data = JsonUtils.getPrizeDetailEntityDatas(responseInfo.result);
        tv_user.setText("获奖者：" + data.getUser().getNickname());
        String tvcount = "获奖者：" + data.getUser().getNickname();
        Spannable spannable = new SpannableString(tv_user.getText());
        spannable.setSpan(new ForegroundColorSpan(Color.RED), 4,tvcount.length(), Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_user.setText(spannable);
        tv_userip.setText("用户IP：" + data.getUser().getIp() + "(" + data.getUser().getCity() + ")");
        tv_canyu.setText("本期参与：" + data.getCount() + "人次");
        String tvcounts = data.getCount() + "";
        Spannable spannables = new SpannableString(tv_canyu.getText());
        spannables.setSpan(new ForegroundColorSpan(Color.RED), 5, tvcounts.length() + 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
        tv_canyu.setText(spannables);
        tv_time.setText("揭晓时间：" + data.getTime());
        tv_lum.setText("幸运号码：" + data.getLuck_num());
        NetUtils.disImageView(data.getUser().getAvatar(),iv,R.drawable.user,R.drawable.user);

    }

    @Override
    public void onFailure(HttpException e, String s) {
        Log.d(TAG, "1111111111");
    }


}
