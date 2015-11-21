package com.qianfeng.yiyuantao.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.widget.RadioGroup;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.HomePagerAdapter;
import com.qianfeng.yiyuantao.fragment.AllCommodityFragment;
import com.qianfeng.yiyuantao.fragment.FirstPageFragment;
import com.qianfeng.yiyuantao.fragment.MineFragment;
import com.qianfeng.yiyuantao.fragment.NewPublishFragment;
import com.qianfeng.yiyuantao.fragment.ShoppingCartFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class HomeActivity extends FragmentActivity implements ViewPager.OnPageChangeListener, RadioGroup.OnCheckedChangeListener {

    private ViewPager viewPager;//5个Fragment内容页的容器
    private RadioGroup tabGroup;//导航栏
    private HomePagerAdapter adapter;//viewPager的适配器
    private List<Fragment> list;//装Fragment的集合

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initView();
    }

    /**
     * 初始化控件
     */
    private void initView() {
        viewPager = (ViewPager) findViewById(R.id.home_content_viewpager);
        list = new ArrayList<>();
        list.add(new FirstPageFragment());
        list.add(new AllCommodityFragment());
        list.add(new NewPublishFragment());
        list.add(new ShoppingCartFragment());
        list.add(new MineFragment());
        adapter = new HomePagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(adapter);
        viewPager.setOnPageChangeListener(this);
        viewPager.setOffscreenPageLimit(5);//ViewPager的预加载

        tabGroup = (RadioGroup) findViewById(R.id.home_tab_group);
        tabGroup.setOnCheckedChangeListener(this);
    }

    /**
     * ViewPager的滑动监听事件
     * @param position
     * @param positionOffset
     * @param positionOffsetPixels
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        tabGroup.check(tabGroup.getChildAt(position).getId());
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    /**
     * 导航栏RadioButton的选中状态的监听
     * @param radioGroup
     * @param checkedId
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
       for (int i = 0; i < tabGroup.getChildCount(); i++){
           if(tabGroup.getChildAt(i).getId() == checkedId) {
               viewPager.setCurrentItem(i);
           }
       }
    }
}
