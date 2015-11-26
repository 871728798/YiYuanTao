package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.util.NetUtils;

/**
 * Created by LXL on 2015/11/26.
 */
public class ShopCarLikeAdapter extends AbsRecyclerAdapter<PrizeEntity> {
    public ShopCarLikeAdapter(Context context, int resId) {
        super(context, resId);
    }

    @Override
    public void bindDatas(MyViewHolder holder, PrizeEntity data) {
        ImageView iv_shoppcarlike = (ImageView) holder.getView(R.id.iv_shoppcarlike);
        TextView tv_shoppcarlike = (TextView) holder.getView(R.id.tv_shoppcarlike);
        ProgressBar pgb_shoppcarlike = (ProgressBar) holder.getView(R.id.pgb_shoppcarlike);

        NetUtils.disImageView(data.getThumb_nail(), iv_shoppcarlike, R.mipmap.all_loading_1, R.mipmap.all_chacha);
        tv_shoppcarlike.setText(data.getTitle());
        pgb_shoppcarlike.setMax(data.getPrice());
        pgb_shoppcarlike.setSecondaryProgress(data.getCount_else());
    }
}
