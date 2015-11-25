package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.qianfeng.yiyuantao.R;

/**
 * Created by Lee on 2015/11/24.
 */
public class PrizeDetailActivity extends Activity implements View.OnClickListener{
    private ImageView iv_back,iv_buycar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_detail);
        init();
        iv_back.setOnClickListener(this);
    }

    private void init() {
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_buycar = (ImageView) findViewById(R.id.iv_buycar);
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
