package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.qianfeng.yiyuantao.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/26 0026.
 */
public class GuideActivity extends Activity implements View.OnClickListener {

    private ViewPager vp;
    private List<ImageView> imgViews;
    private int[] imgs = new int[]{R.mipmap.welcome_gallery_1,
                                R.mipmap.welcome_gallery_2,
                                R.mipmap.welcome_gallery_3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        init();
    }

    private void init() {
        vp = (ViewPager) findViewById(R.id.vp_guide);
        imgViews = new ArrayList<>();
        for (int i = 0; i < imgs.length; i++){
            ImageView iv = new ImageView(this);
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
            iv.setImageResource(imgs[i]);
            imgViews.add(iv);
            if(i == 2){
                iv.setOnClickListener(this);
            }
        }
        MyPagerAdapter adapter = new MyPagerAdapter(imgViews);
        vp.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
        this.finish();
    }

    private class MyPagerAdapter extends PagerAdapter{

        private final List<ImageView> datas;

        public MyPagerAdapter(List<ImageView> datas){
            this.datas = datas;
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
}
