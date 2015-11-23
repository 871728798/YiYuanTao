package com.qianfeng.yiyuantao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.app.MyApp;
import com.qianfeng.yiyuantao.bean.FirstPageEntity;
import com.qianfeng.yiyuantao.custom.HeadBannerView;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class FirstPageFragment extends Fragment implements NetUtils.RequestCallCack {

   private HeadBannerView headBannerView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        initView(view);
        initDatas();
        return view;
    }

    private void initView(View view) {
        headBannerView = (HeadBannerView) view.findViewById(R.id.head_banner);
    }

    private void initDatas() {
        NetUtils.getDataFromNet(this, Constants.URL.FIRST_PAGE_URL);
    }


    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        FirstPageEntity firstPageEntity = JsonUtils.parstFirstPageDatas(responseInfo.result);
        FirstPageEntity.Banner[] banner = firstPageEntity.getBanner();
        List<ImageView> datas = new ArrayList<>();
        for (int i = 0; i < banner.length; i++){
            ImageView iv = new ImageView(getActivity());
            NetUtils.disImageView(banner[i].getBanner(), iv, R.mipmap.loading_1, R.mipmap.img_cancel);
            datas.add(iv);
        }
        headBannerView.setDatas(datas);
    }

    @Override
    public void onFailure(HttpException e, String s) {

    }
}
