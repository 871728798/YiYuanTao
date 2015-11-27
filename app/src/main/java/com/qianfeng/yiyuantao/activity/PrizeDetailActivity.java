package com.qianfeng.yiyuantao.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.ABSBaseAdapter2;
import com.qianfeng.yiyuantao.bean.CommentEntity;
import com.qianfeng.yiyuantao.bean.ViewPagerEntity;
import com.qianfeng.yiyuantao.custom.HeadPulishViewPagerView;
import com.qianfeng.yiyuantao.custom.PrizeDetailHeadView;
import com.qianfeng.yiyuantao.custom.PrizeDetailHeadViews;
import com.qianfeng.yiyuantao.custom.PrizeDetailView;
import com.qianfeng.yiyuantao.custom.PrizeDetailViews;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.List;


/**
 * Created by Lee on 2015/11/24.
 */
public class PrizeDetailActivity extends Activity implements View.OnClickListener, NetUtils.RequestCallCack{
    private static String TAG = "print";
    private static String prize_id;
    private String URL1;//广告位URL
    private String URL2;//用户详情URL
    private String URL3;//评论详情URL
    private ImageView iv_back, iv_buycar;
    private PrizeDetailView prizeDetailView; //奖品详情中间那块
    private PrizeDetailHeadView prizeDetailHeadView;//正在揭晓的View
    private PrizeDetailHeadViews prizeDetailHeadViews;//已揭晓的View
    private HeadPulishViewPagerView viewPagerView;//广告位的View
    private PrizeDetailViews prizeDetailViews;
    private PullToRefreshListView prize_lv;
    private List<CommentEntity> commentEntiyDatas;
    private int remian_time;
    private MyCommentAdapter adpater;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_prize_detail);
        init();
        updateDatas();
    }

    /**
     * 得到prize_id用来拼URL
     */
    private void getPrizeIdDatas() {
        Intent intent = getIntent();
        prize_id = intent.getStringExtra("prize_id");
        URL1 = "http://api.zhuquzhou.com/prize/prize_detail?prize_id=" + prize_id + "&android_id=d108148ee86fe036&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284044600645&mac=68:F7:28:F0:46:16&os_version=4.4.2&user_id=153825&";
        URL3 = "http://api.zhuquzhou.com/buy/buy_history_by_prize?prize_id=" + prize_id + "&page_no=1&android_id=d108148ee86fe036&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284044600645&mac=68:F7:28:F0:46:16&os_version=4.4.2&user_id=153825&";
        //Log.d(TAG, "商品id" + prize_id);
        //prizeDetailView.setPrizeId(prize_id);

    }

    private void init() {
        prize_lv = (PullToRefreshListView) findViewById(R.id.prize_lv);
        iv_back = (ImageView) findViewById(R.id.iv_back);
        iv_buycar = (ImageView) findViewById(R.id.iv_buycar);
        iv_back.setOnClickListener(this);
        iv_buycar.setOnClickListener(this);
        viewPagerView = new HeadPulishViewPagerView(PrizeDetailActivity.this);
        prizeDetailView = new PrizeDetailView(PrizeDetailActivity.this);
        prizeDetailViews = new PrizeDetailViews(PrizeDetailActivity.this);
        prizeDetailHeadView = new PrizeDetailHeadView(PrizeDetailActivity.this);
        prizeDetailHeadViews = new PrizeDetailHeadViews(PrizeDetailActivity.this);

        getPrizeIdDatas();

        /*Log.d(TAG,"remian---------" + remian_time);
        if (remian_time == 0){
            viewPagerView.setPrizeId(prize_id);
            prizeDetailView.setPrizeId(prize_id);
            prize_lv.getRefreshableView().addHeaderView(viewPagerView);
            prize_lv.getRefreshableView().addHeaderView(prizeDetailHeadView);
            prize_lv.getRefreshableView().addHeaderView(prizeDetailView);
        }else {
            viewPagerView.setPrizeId(prize_id);
            prizeDetailHeadViews.setPrizeId(prize_id);
            prizeDetailViews.setPrizeId(prize_id);
            prize_lv.getRefreshableView().addHeaderView(viewPagerView);
            prize_lv.getRefreshableView().addHeaderView(prizeDetailHeadViews);
            prize_lv.getRefreshableView().addHeaderView(prizeDetailViews);
        }*/
        viewPagerView.setPrizeId(prize_id);
        prizeDetailHeadView.setPrizeId(prize_id);
        prizeDetailView.setPrizeId(prize_id);

        prize_lv.getRefreshableView().addHeaderView(viewPagerView);
        prize_lv.getRefreshableView().addHeaderView(prizeDetailHeadView);
        prize_lv.getRefreshableView().addHeaderView(prizeDetailView);
        adpater = new MyCommentAdapter(PrizeDetailActivity.this);
        prize_lv.setAdapter(adpater);
    }

    private void updateDatas() {
        NetUtils.getDataFromNet(this, URL3);
    }


    /**
     * 数据下载成功调用的方法
     *
     * @param responseInfo
     */
    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        String datas = responseInfo.result;
        commentEntiyDatas = JsonUtils.getCommentEntiyDatas(datas);
        Log.d(TAG, "------------" + datas.toString());
        adpater.setDatas(commentEntiyDatas);
    }

    @Override
    public void onFailure(HttpException e, String s) {

    }


    /**
     * 返回上一级
     *
     * @param v
     */

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                finish();
                break;
            case R.id.iv_buycar:
                break;

        }
    }


    class MyCommentAdapter extends ABSBaseAdapter2<CommentEntity> {
        private Context context;

        public MyCommentAdapter(Context context) {
            super(context, R.layout.item_list_prizedetail);
            this.context = context;
        }

        @Override
        public void bindDatas(View view, ViewHolder viewHolder, CommentEntity data) {
            ImageView iv_user = (ImageView) viewHolder.getView(R.id.iv_user);
            NetUtils.disImageView(data.getUser().getAvatar(), iv_user, R.drawable.user, R.drawable.user);
            TextView tv_user = (TextView) viewHolder.getView(R.id.tv_user);
            TextView tv_userip = (TextView) viewHolder.getView(R.id.tv_userip);
            TextView tv_personcount = (TextView) viewHolder.getView(R.id.tv_personcount);

            TextView tv_time = (TextView) viewHolder.getView(R.id.tv_time);

            tv_user.setText(data.getUser().getNickname());
            tv_userip.setText("(" + data.getCity() + "IP:" + data.getUser().getIp() + ")");
            String tvcount = "(" + data.getCity() + "IP:" + data.getUser().getIp() + ")";
            Spannable spannable = new SpannableString(tv_userip.getText());
            spannable.setSpan(new ForegroundColorSpan(Color.GREEN), 1, tvcount.length() - 1, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_userip.setText(spannable);
            tv_personcount.setText("参与了" + data.getCount() + "人次");
            String tvcounts = data.getCount() + "";
            Spannable spannables = new SpannableString(tv_personcount.getText());
            spannables.setSpan(new ForegroundColorSpan(Color.RED), 3, tvcounts.length() + 3, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_personcount.setText(spannables);
            tv_time.setText(data.getDatetime());

        }
    }


}
