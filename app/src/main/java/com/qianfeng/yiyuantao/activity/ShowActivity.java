package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.ShowPrizeListAdapter;
import com.qianfeng.yiyuantao.bean.ShowPrizeEntity;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class ShowActivity extends Activity implements View.OnClickListener, NetUtils.RequestCallCack {

    private PullToRefreshListView listView;
    private ImageView iv_back;
    private ShowPrizeListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        initView();
        initDatas();
    }



    private void initView() {
        listView = (PullToRefreshListView) findViewById(R.id.lv_show_content);
        adapter = new ShowPrizeListAdapter(this);
        listView.setAdapter(adapter);

        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
    }

    private void initDatas() {
        NetUtils.getDataFromNet(this, Constants.URL.SHOW_PRIZE_URL);

    }

    @Override
    public void onClick(View view) {
        this.finish();
    }

    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        List<ShowPrizeEntity> datas = JsonUtils.parseShowDatas(responseInfo.result);
        adapter.setDatas(datas);
    }

    @Override
    public void onFailure(HttpException e, String s) {

    }
}
