package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.SearchResultListAdapter;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class SearchResultActivity  extends Activity implements View.OnClickListener, NetUtils.RequestCallCack {

    private PullToRefreshListView listView;
    private ImageView iv_back,  iv_shopping_cart;
    private SearchResultListAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_result);
        Intent intent = getIntent();
        String key = intent.getStringExtra("key");
        if(key != null){
            initView();
            initData(key);
        }
    }

    private void initData(String key) {
        String url = String.format(Constants.URL.SEARCH_URL, key);
        NetUtils.getDataFromNet(this, url);
    }

    private void initView() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_back.setOnClickListener(this);
        iv_shopping_cart = (ImageView) findViewById(R.id.iv_go_shopping_cart);
        iv_shopping_cart.setOnClickListener(this);

        listView = (PullToRefreshListView) findViewById(R.id.lv_search_result);
        adapter = new SearchResultListAdapter(this);
        listView.setAdapter(adapter);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.iv_back:
                this.finish();
                break;
            case R.id.iv_go_shopping_cart:
                break;
        }
    }

    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {

        List<PrizeEntity> datas = JsonUtils.parseSearchResult(responseInfo.result);
//        Log.i("TAG", datas.toString());
        adapter.setDatas(datas);
    }

    @Override
    public void onFailure(HttpException e, String s) {

    }

}
