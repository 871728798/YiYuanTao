package com.qianfeng.yiyuantao.custom;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.bean.ViewPagerEntity;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

/**
 * Created by Lee on 2015/11/26.
 */
public class PrizeDetailHeadViews extends RelativeLayout implements NetUtils.RequestCallCack {
    private static final String TAG = "print";
    private String URL1;
    private String prize_id;
    private TextView tv_peroid;
    private TextView tv_title;
    public PrizeDetailHeadViews(Context context) {
        super(context);
        init();

    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_prize_details_head, this, true);
        tv_peroid = (TextView) findViewById(R.id.peroid_tv);
        tv_title = (TextView) findViewById(R.id.tv_title);

    }
    public void setPrizeId(String id) {
        prize_id = id;
        URL1 = "http://api.zhuquzhou.com/prize/prize_detail?prize_id=" + prize_id + "&android_id=d108148ee86fe036&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284044600645&mac=68:F7:28:F0:46:16&os_version=4.4.2&user_id=153825&";
        getDatas();
    }
    private void getDatas(){
        NetUtils.getDataFromNet(this, URL1);
    }

    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        ViewPagerEntity data = JsonUtils.getViewPagerEntityDatas(responseInfo.result);
        tv_peroid.setText("第" + data.getPeroid() + "期");
        tv_title.setText(data.getTitle());
    }

    @Override
    public void onFailure(HttpException e, String s) {
        Log.d(TAG, "PrizeDetailHeadView请求失败");
    }
}
