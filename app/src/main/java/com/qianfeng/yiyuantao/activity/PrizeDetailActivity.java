package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.custom.PrizeDetailView;
import com.qianfeng.yiyuantao.fragment.ShoppingCartFragment;

/**
 * Created by Lee on 2015/11/24.
 */
public class PrizeDetailActivity extends Activity implements View.OnClickListener{
    private ImageView iv_back,iv_buycar;
    private PrizeDetailView prizeDetailView;
    private ListView prize_lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_detail);
        init();

    }

    private void init() {
        prize_lv = (ListView) findViewById(R.id.prize_lv);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_buycar = (ImageView) findViewById(R.id.iv_buycar);
        iv_back.setOnClickListener(this);
        iv_buycar.setOnClickListener(this);
        prizeDetailView = new PrizeDetailView(PrizeDetailActivity.this);

        prize_lv.addHeaderView(prizeDetailView);





    }

    /**
     * 返回上一级
     * @param v
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_buycar:
                break;

        }
    }
}
