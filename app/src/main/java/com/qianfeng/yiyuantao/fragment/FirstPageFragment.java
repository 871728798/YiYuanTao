package com.qianfeng.yiyuantao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.FirstPageBannerPagerAdapter;
import com.qianfeng.yiyuantao.custom.ImgNavView;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.NetUtils;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class FirstPageFragment extends Fragment implements NetUtils.RequestCallCack {

    private ViewPager viewPager;
    private ImgNavView imgNavView;
    private FirstPageBannerPagerAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        initView(view);
        initDatas();
        return view;
    }

    private void initView(View view) {
        viewPager = (ViewPager) view.findViewById(R.id.vp_banner);
        adapter = new FirstPageBannerPagerAdapter();

        imgNavView = (ImgNavView) view.findViewById(R.id.img_nav);
    }

    private void initDatas() {
        NetUtils.getDataFromNet(this, Constants.URL.FIRST_PAGE_URL);
    }


    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        Log.i("TAG", responseInfo.result);
    }

    @Override
    public void onFailure(HttpException e, String s) {

    }
}
