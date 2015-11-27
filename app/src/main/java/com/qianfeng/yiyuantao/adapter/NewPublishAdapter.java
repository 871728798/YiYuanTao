package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;
import com.qianfeng.yiyuantao.custom.CircleImageView;
import com.qianfeng.yiyuantao.util.NetUtils;


/**
 * Created by Lee on 2015/11/23.
 */
public  class NewPublishAdapter extends ABSBaseAdapter3<NewPublishEntity>{

    private static final String TAG = "print" ;

    public NewPublishAdapter(Context context, int... resId) {
        super(context, R.layout.item_list_publish,R.layout.item_list_publishs);
    }

    @Override
    public void bindDatas(ViewHolder viewHolder, NewPublishEntity data, int position) {
        if (data.getRemain_sec() == 0){
            ImageView iv_pic = (ImageView) viewHolder.getView(R.id.iv_pic);
            NetUtils.disImageView(data.getPrize_detail().getThumb_nail(),iv_pic,R.drawable.loading_2,R.drawable.loading_2);
            CircleImageView iv_user = (CircleImageView) viewHolder.getView(R.id.iv_user);
            NetUtils.disImageView(data.getUser().getAvatar(),iv_user,R.drawable.user,R.drawable.user);
            TextView tv_title = (TextView) viewHolder.getView(R.id.tv_title);
           TextView tv_winner = (TextView) viewHolder.getView(R.id.tv_winner);
            TextView tv_price = (TextView) viewHolder.getView(R.id.tv_price);
            TextView tv_count = (TextView) viewHolder.getView(R.id.tv_count);
            TextView tv_time = (TextView) viewHolder.getView(R.id.tv_time);
            tv_title.setText(data.getPrize_detail().getTitle());
            tv_price.setText("价格:￥" + data.getPrize_detail().getPrice());

            tv_count.setText("本期夺宝:" +data.getCount() + "人次");
            //把字体设置为红色
            String tvcount = data.getCount() + "";
            Spannable spannable = new SpannableString(tv_count.getText());
            spannable.setSpan(new ForegroundColorSpan(Color.RED), 5, tvcount.length() + 5, Spannable.SPAN_EXCLUSIVE_EXCLUSIVE);
            tv_count.setText(spannable);
            tv_winner.setText("获奖者:" + data.getUser().getNickname());
            tv_time.setText("揭晓时间：" + data.getTime());
        }else{
            ImageView iv_pic = (ImageView) viewHolder.getView(R.id.iv_pic);
            NetUtils.disImageView(data.getPrize_detail().getThumb_nail(),iv_pic,R.drawable.loading_2,R.drawable.loading_2);
            TextView tv_title = (TextView) viewHolder.getView(R.id.tv_title);
            TextView tv_price = (TextView) viewHolder.getView(R.id.tv_price);
            TextView tv_pulishing = (TextView) viewHolder.getView(R.id.tv_publishing);
            tv_title.setText(data.getPrize_detail().getTitle());
            tv_price.setText("价格:￥" + data.getPrize_detail().getPrice());
            int time = data.getRemain_sec();
            new MyTimeer(time * 1000,100,tv_pulishing).start();
        }
    }
    class MyTimeer extends CountDownTimer{

        /**
         * @param millisInFuture    The number of millis in the future from the call
         *                          to {@link #start()} until the countdown is done and {@link #onFinish()}
         *                          is called.
         * @param countDownInterval The interval along the way to receive
         *                          {@link #onTick(long)} callbacks.
         */
        private TextView tv;
        public MyTimeer(long millisInFuture, long countDownInterval,TextView tv) {
            super(millisInFuture, countDownInterval);
            this.tv = tv;
        }

        @Override
        public void onTick(long l) {
            tv.setText("0" + l /( 1000 * 60) + " : " + (l / 1000)%60 + " : " + (l/100)%10);
        }

        @Override
        public void onFinish() {
            tv.setText("正在揭晓中...");
        }
    }

}
