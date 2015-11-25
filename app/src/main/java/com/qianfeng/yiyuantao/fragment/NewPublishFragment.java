package com.qianfeng.yiyuantao.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.alibaba.fastjson.JSON;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.activity.PrizeDetailActivity;
import com.qianfeng.yiyuantao.adapter.NewPublishAdapter;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class NewPublishFragment extends Fragment implements NetUtils.RequestCallCack,PullToRefreshBase.OnRefreshListener2<ListView>,AdapterView.OnItemClickListener{
    private static final String TAG = "print";
    private PullToRefreshListView pr_lv;
    private NewPublishAdapter newPublishAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_publish, container, false);
        init(view);
        updateDatas();
        return view;

    }

    /**
     *初始化
     */
    private void init(View v) {
        pr_lv = (PullToRefreshListView) v.findViewById(R.id.pr_lv);
        newPublishAdapter = new NewPublishAdapter(getActivity());
        pr_lv.setAdapter(newPublishAdapter);
        pr_lv.setMode(PullToRefreshBase.Mode.PULL_FROM_START);
        pr_lv.setOnRefreshListener(this);
        pr_lv.setOnItemClickListener(this);

    }
    private void updateDatas(){
        NetUtils.getDataFromNet(this, Constants.URL.NEW_PUBLISH_URL);

    }

    /**
     * 数据下载成功
     * @param responseInfo
     */
    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        final String result = responseInfo.result;
        List<NewPublishEntity> datas = JsonUtils.getNewPublishDatas(result);
        newPublishAdapter.setDatas(datas);
        pr_lv.onRefreshComplete();

    }

    /**
     * 数据下载失败
     * @param e
     * @param s
     */
    @Override
    public void onFailure(HttpException e, String s) {
        Log.d(TAG, "数据下载失败");
    }


    @Override
    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
        updateDatas();
        newPublishAdapter.notifyDataSetChanged();


    }

    @Override
    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

    }

    /**
     * 下拉ListView的监听事件
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), PrizeDetailActivity.class);
        startActivity(intent);
    }
}
