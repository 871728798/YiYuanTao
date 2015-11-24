package com.qianfeng.yiyuantao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.ABSBaseAdapter;
import com.qianfeng.yiyuantao.adapter.AllCommPlAdapter;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class AllCommodityFragment extends Fragment implements RadioGroup.OnCheckedChangeListener, NetUtils.RequestCallCack {
    private PullToRefreshListView listView;
    private RadioGroup rdgroup;
    private String url;
    private AllCommPlAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_all_commodity, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        rdgroup = (RadioGroup) view.findViewById(R.id.rg_all_commodity);
        listView = (PullToRefreshListView) view.findViewById(R.id.all_commodity_putorefreshlv);
        adapter = new AllCommPlAdapter(getActivity());
        listView.setAdapter(adapter);
        rdgroup.setOnCheckedChangeListener(this);
        rdgroup.getChildAt(0).performClick();

    }

    /**
     *radioGroup的Item的点击事件
     * @param
     * @param i
     */
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int i) {
           switch (i){
               case R.id.rb1_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM1;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb2_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM2;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb3_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM3;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb4_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM4;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb5_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM5;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb6_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM6;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb7_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM7;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb8_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM8;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb9_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM9;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb10_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM10;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb11_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM11;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb12_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM12;
                   NetUtils.getDataFromNet(this, url);
                   break;
               case R.id.rb13_all_commodity:
                   url = Constants.URL.ALL_COMMODITY_NUM13;
                   NetUtils.getDataFromNet(this, url);
                   break;
           }
    }

    /**
     * 网络下载数据
     */

    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        List<PrizeEntity> entities = JsonUtils.parseAllCommodity(responseInfo.result);
        adapter.setDatas(entities);
    }

    @Override
    public void onFailure(HttpException e, String s) {

    }
}
