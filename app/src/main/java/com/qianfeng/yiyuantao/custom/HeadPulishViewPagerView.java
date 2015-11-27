package com.qianfeng.yiyuantao.custom;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.FirstPageBannerPagerAdapter;
import com.qianfeng.yiyuantao.bean.ViewPagerEntity;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Lee on 2015/11/26.
 */
public class HeadPulishViewPagerView extends FrameLayout implements ViewPager.OnPageChangeListener, NetUtils.RequestCallCack {
    private static final String TAG = "print";
    private String URL1;
    private String prize_id;
    private MyViewPager viewPager;
    private ImgNavView inv;
    private FirstPageBannerPagerAdapter adapter;
    private List<ImageView> list;


    public HeadPulishViewPagerView(Context context) {
        super(context);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_newpublishviewpager_layout, this, true);
        viewPager = (MyViewPager) findViewById(R.id.vp_banner);
        viewPager.setOnPageChangeListener(this);
        adapter = new FirstPageBannerPagerAdapter();
        inv = (ImgNavView) findViewById(R.id.img_nav);
        viewPager.setAdapter(adapter);
    }

    public void setPrizeId(String id) {
        prize_id = id;
        URL1 = "http://api.zhuquzhou.com/prize/prize_detail?prize_id=" + prize_id + "&android_id=d108148ee86fe036&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284044600645&mac=68:F7:28:F0:46:16&os_version=4.4.2&user_id=153825&";
        getDatas();
    }

    private void getDatas() {
        NetUtils.getDataFromNet(this, URL1);
    }

    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        ViewPagerEntity data = JsonUtils.getViewPagerEntityDatas(responseInfo.result);
        String value = data.getThumb_slide();
        String[] imgurl = value.split("\\|");
        list = new ArrayList<>();
        for(int i = 0;i < imgurl.length;i++){
            ImageView iv = new ImageView(getContext());
            iv.setScaleType(ImageView.ScaleType.CENTER_CROP);
            NetUtils.disImageView(imgurl[i],iv,R.mipmap.loading_1,R.mipmap.loading_1);
            list.add(iv);
        }
        this.setDatas(list);

    }

    @Override
    public void onFailure(HttpException e, String s) {
        Log.d(TAG, "PrizeDetailHeadViewPagerView请求失败");
    }


    public void setDatas(List<ImageView> datas) {
        adapter.setDatas(datas);
        inv.setCount(datas.size());
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        inv.selectIndex(position);
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }
}
