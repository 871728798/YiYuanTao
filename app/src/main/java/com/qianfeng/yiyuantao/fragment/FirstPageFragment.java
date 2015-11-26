package com.qianfeng.yiyuantao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshScrollView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.activity.SearchActivity;
import com.qianfeng.yiyuantao.activity.SearchResultActivity;
import com.qianfeng.yiyuantao.activity.ShowActivity;
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
public class FirstPageFragment extends Fragment implements NetUtils.RequestCallCack, FirstPageNewPublishView.UpdateDatasListener, PullToRefreshBase.OnRefreshListener, View.OnClickListener {

    private PullToRefreshScrollView scrollView;
    private HeadBannerView headBannerView;//头部广告位的自定义组合布局
    private FirstPageNewPublishView firstPageNewPublishView;//首页的最新揭晓的自定义组合布局
    private GridView gv_Recommend;
    private ReCommendGridViewAdapter adapter;
    private ImageView iv_Search;//首页的搜索
    private RadioGroup menu_Group;

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
        scrollView = (PullToRefreshScrollView) view.findViewById(R.id.pull_to_refresh_scrollview);
        scrollView.setOnRefreshListener(this);

        headBannerView = (HeadBannerView) view.findViewById(R.id.head_banner);

        firstPageNewPublishView = (FirstPageNewPublishView) view.findViewById(R.id.new_publish_view);
        firstPageNewPublishView.setUpdateDatasListener(this);

        gv_Recommend = (GridView) view.findViewById(R.id.gv_recommend);
        adapter = new ReCommendGridViewAdapter(getActivity());
        gv_Recommend.setAdapter(adapter);

        iv_Search = (ImageView) view.findViewById(R.id.iv_search);
        iv_Search.setOnClickListener(this);

        menu_Group = (RadioGroup) view.findViewById(R.id.first_page_menu_group);
        for(int i = 0; i < menu_Group.getChildCount(); i++){
            menu_Group.getChildAt(i).setOnClickListener(this);
        }
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
            iv.setScaleType(ImageView.ScaleType.FIT_XY);
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
        //广告位banner
        FirstPageEntity firstPageEntity = JsonUtils.parstFirstPageDatas(responseInfo.result);
        FirstPageEntity.Banner[] banner = firstPageEntity.getBanner();
        initHeadBanner(banner);
        //最新揭晓
        NewPublishEntity[] lottery = firstPageEntity.getLottery();
        firstPageNewPublishView.setDatas(Arrays.asList(lottery));
        //人气推荐
        PrizeEntity[] prize_list = firstPageEntity.getPrize_list();
        adapter.setDatas(Arrays.asList(prize_list));
        //刷新完成
        scrollView.onRefreshComplete();
    }
    /**
     * 从网络上加载数据失败后回调
     */
    @Override
    public void onFailure(HttpException e, String s) {

    }

    /**
     * 当倒计时结束时，需要更新数据
     */
    @Override
    public void update() {
        initDatas();
    }

    /**
     * 下拉刷新时回调
     * @param refreshView
     */
    @Override
    public void onRefresh(PullToRefreshBase refreshView) {
        initDatas();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_search:
                Intent intent = new Intent(getActivity(), SearchActivity.class);
                startActivity(intent);
                break;
            case R.id.menu_tenyuan://十元专区
                Intent intent2 = new Intent(getActivity(), SearchResultActivity.class);
                intent2.putExtra("type", "十元专区");
                startActivity(intent2);
                break;
            case R.id.menu_new_activity://最新活动
                break;
            case R.id.menu_show://晒单
                Intent intent3 = new Intent(getActivity(), ShowActivity.class);
                startActivity(intent3);
                break;
            case R.id.menu_help://常见问题
                break;
        }
    }
}
