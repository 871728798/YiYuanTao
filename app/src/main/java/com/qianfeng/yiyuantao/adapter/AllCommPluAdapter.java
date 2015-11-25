package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.activity.RegisterActivity;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.util.NetUtils;

/**
 * Created by LXL on 2015/11/25.
 */
public class AllCommPluAdapter extends ABSBaseAdapter2<PrizeEntity>{
    Context context;
    public AllCommPluAdapter(Context context) {
        super(context,  R.layout.item_lv_allcom);
        this.context = context;
    }

    @Override
    public void bindDatas(View view, ViewHolder viewHolder, PrizeEntity data) {
        ImageView iv_thumb_nail_allomm = (ImageView) viewHolder.getView(R.id.iv_thumb_nail_allomm);
        TextView tv_peroid_allcomm = (TextView) viewHolder.getView(R.id.tv_peroid_allcomm);
        TextView tv_title_comm = (TextView) viewHolder.getView(R.id.tv_title_comm);
        TextView tv_price_allcomm = (TextView) viewHolder.getView(R.id.tv_price_allcomm);
        ProgressBar progressBar_comm = (ProgressBar) viewHolder.getView(R.id.progressBar_comm);
        TextView tv_count_else_allcomm = (TextView) viewHolder.getView(R.id.tv_count_else_allcomm);
        final ImageView all_ico_shopping_cart_2_1 = (ImageView) viewHolder.getView(R.id.all_ico_shopping_cart_2_1);

        NetUtils.disImageView(data.getThumb_nail(), iv_thumb_nail_allomm, R.mipmap.all_loading_1, R.mipmap.all_chacha);
        tv_peroid_allcomm.setText("第" + data.getPeroid() + "期  ");
        tv_title_comm.setText(data.getTitle());
        tv_price_allcomm.setText("总需" + data.getPrice());
        tv_count_else_allcomm.setText("剩余" + data.getCount_else());
        progressBar_comm.setMax(data.getPrice());
        progressBar_comm.setSecondaryProgress(data.getCount_else());

        all_ico_shopping_cart_2_1.setClickable(true);
        all_ico_shopping_cart_2_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, RegisterActivity.class);
//                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });
    }
}
