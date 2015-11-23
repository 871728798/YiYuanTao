package com.qianfeng.yiyuantao.adapter;

import android.media.Image;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class FirstPageBannerPagerAdapter extends PagerAdapter{

    private List<ImageView> datas;
    public FirstPageBannerPagerAdapter(){

    }

    public void setDatas(List<ImageView> datas){
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }
    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(datas.get(position));
        return datas.get(position);
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(datas.get(position));
    }

}
