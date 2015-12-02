package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.activity.PrizeDetailActivity;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.util.NetUtils;

/**
 * Created by Administrator on 2015/11/24 0024.
 */
public class ReCommendGridViewAdapter extends ABSBaseAdapter2<PrizeEntity>{

    private Context context;
    public ReCommendGridViewAdapter(Context context) {
        super(context, R.layout.item_gridview_recommend);
        this.context = context;
    }

    @Override
    public void bindDatas(View view, ViewHolder viewHolder, final PrizeEntity data) {
        ImageView iv = (ImageView) viewHolder.getView(R.id.iv_id);
        NetUtils.disImageView(data.getThumb_nail(), iv, R.drawable.loading_2, R.drawable.loading_2);

        TextView tv_price, tv_need, tv_else, tv_buyed;
        tv_price  = (TextView) viewHolder.getView(R.id.tv_price);
        tv_buyed = (TextView) viewHolder.getView(R.id.tv_count_buyed);
        tv_need = (TextView) viewHolder.getView(R.id.tv_count_need);
        tv_else = (TextView) viewHolder.getView(R.id.tv_count_else);
        tv_price.setText("价值 : ￥" + data.getPrice());
        tv_buyed.setText(data.getCount_buyed()+"");
        tv_need.setText(data.getPrice() + "");
        tv_else.setText(data.getCount_else()+"");

        View red_view = viewHolder.getView(R.id.red_view_id);
        int width = (int) (data.getCount_buyed() * 150 / (float)data.getPrice() + 0.5);
        ViewGroup.LayoutParams layoutParams = red_view.getLayoutParams();
        layoutParams.width = width;
        red_view.setLayoutParams(layoutParams);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                Intent intent = new Intent(context, PrizeDetailActivity.class);
//                intent.putExtra("prize_id", data.getPrize_id()+"");
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
//                context.startActivity(intent);
            }
        });
    }
}
