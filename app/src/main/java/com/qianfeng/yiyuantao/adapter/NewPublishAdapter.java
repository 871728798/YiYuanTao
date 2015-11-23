package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;
import com.qianfeng.yiyuantao.custom.CircleImageView;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.NetUtils;

/**
 * Created by Lee on 2015/11/23.
 */
public class NewPublishAdapter extends ABSBaseAdapter<NewPublishEntity>{
    public NewPublishAdapter(Context context, int... resId) {
        super(context, R.layout.item_list_publish,R.layout.item_list_publishs);
    }

    @Override
    public void bindDatas(ViewHolder viewHolder, NewPublishEntity data, int position) {
        if (data.getType() == 1){
            ImageView iv_pic = (ImageView) viewHolder.getView(R.id.iv_pic);
            NetUtils.disImageView(data.getPrize_detail().getThumb_nail(),iv_pic,R.drawable.loading_2,R.drawable.loading_2);
            CircleImageView iv_user = (CircleImageView) viewHolder.getView(R.id.iv_user);
            NetUtils.disImageView(data.getUser().getAvatar(),iv_user,R.drawable.user,R.drawable.user);
            TextView tv_title = (TextView) viewHolder.getView(R.id.tv_title);
            TextView tv_winner = (TextView) viewHolder.getView(R.id.tv_winner);
            TextView tv_price = (TextView) viewHolder.getView(R.id.tv_price);
            TextView tv_count = (TextView) viewHolder.getView(R.id.tv_count);
            tv_title.setText(data.getPrize_detail().getTitle());
            tv_price.setText(data.getPrize_detail().getPrice());
            tv_count.setText(data.getCount());
            tv_winner.setText(data.getUser().getNickname());
        }
    }
}
