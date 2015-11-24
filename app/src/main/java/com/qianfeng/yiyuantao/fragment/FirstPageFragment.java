package com.qianfeng.yiyuantao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.ReCommendGridViewAdapter;
import com.qianfeng.yiyuantao.app.MyApp;
import com.qianfeng.yiyuantao.bean.FirstPageEntity;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.custom.FirstPageNewPublishView;
import com.qianfeng.yiyuantao.custom.HeadBannerView;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class FirstPageFragment extends Fragment implements NetUtils.RequestCallCack {

    private HeadBannerView headBannerView;//头部广告位的自定义组合布局
    private FirstPageNewPublishView firstPageNewPublishView;//首页的最新揭晓的自定义组合布局
    private GridView gv_Recommend;
    private ReCommendGridViewAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_first_page, container, false);
        initView(view);
        initDatas();
        return view;
    }

    /**
     * 初始化控件
     * @param view
     */
    private void initView(View view) {
        headBannerView = (HeadBannerView) view.findViewById(R.id.head_banner);
        firstPageNewPublishView = (FirstPageNewPublishView) view.findViewById(R.id.new_publish_view);

        gv_Recommend = (GridView) view.findViewById(R.id.gv_recommend);
        adapter = new ReCommendGridViewAdapter(getActivity());
        gv_Recommend.setAdapter(adapter);
    }

    /**
     * 从网络上加载数据
     */
    private void initDatas() {
        NetUtils.getDataFromNet(this, Constants.URL.FIRST_PAGE_URL);
    }

    /**
     * 填充头部的广告位的数据
     * @param banner
     */
    private void initHeadBanner(FirstPageEntity.Banner[] banner){
        List<ImageView> datas = new ArrayList<>();
        for (int i = 0; i < banner.length; i++){
            ImageView iv = new ImageView(getActivity());
            NetUtils.disImageView(banner[i].getBanner(), iv, R.mipmap.loading_1, R.mipmap.img_cancel);
            datas.add(iv);
        }
        headBannerView.setDatas(datas);
    }

    /**
     * 从网络上加载数据成功后回调
     * @param responseInfo
     */
    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        FirstPageEntity firstPageEntity = JsonUtils.parstFirstPageDatas(responseInfo.result);
        FirstPageEntity.Banner[] banner = firstPageEntity.getBanner();
        initHeadBanner(banner);

        NewPublishEntity[] lottery = firstPageEntity.getLottery();
//        Log.i("TAG", Arrays.asList(lottery).toString());
        firstPageNewPublishView.setDatas(Arrays.asList(lottery));

        PrizeEntity[] prize_list = firstPageEntity.getPrize_list();
        Log.i("TAG", Arrays.asList(prize_list).toString());
        adapter.setDatas(Arrays.asList(prize_list));
    }
    /**
     * 从网络上加载数据失败后回调
     */
    @Override
    public void onFailure(HttpException e, String s) {

    }
}
