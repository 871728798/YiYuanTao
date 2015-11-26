package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.bean.ShowPrizeEntity;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class ShowPrizeListAdapter extends ABSBaseAdapter2<ShowPrizeEntity>{

    private final Context context;

    public ShowPrizeListAdapter(Context context) {
        super(context, R.layout.item_list_show_prize);
        this.context = context;
    }

    @Override
    public void bindDatas(View view, ViewHolder viewHolder, ShowPrizeEntity data) {
        ImageView iv = (ImageView) viewHolder.getView(R.id.iv_avatar);
        NetUtils.disImageView(data.getUser().getAvatar(), iv, R.drawable.loading_2, R.drawable.loading_2);

        TextView tv_nickname = (TextView) viewHolder.getView(R.id.tv_nickname);
        tv_nickname.setText(data.getUser().getNickname());

        TextView tv_time = (TextView) viewHolder.getView(R.id.tv_time);
        tv_time.setText(data.getTime());

        TextView tv_title = (TextView) viewHolder.getView(R.id.tv_title);
        tv_title.setText(data.getTitle());

        TextView tv_pricename = (TextView) viewHolder.getView(R.id.tv_pricename);
        tv_pricename.setText(data.getPrice_name());

        TextView tv_content = (TextView) viewHolder.getView(R.id.tv_content);
        tv_content.setText(data.getContent());

        LinearLayout layout = (LinearLayout) viewHolder.getView(R.id.layout_imgs);
        layout.removeAllViews();
        List<String> thumbs = data.getImages();
        for (int i = 0; i < thumbs.size(); i++){
            ImageView imgV = new ImageView(context);
            imgV.setScaleType(ImageView.ScaleType.CENTER_CROP);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(100, 90);
            imgV.setLayoutParams(params);

            NetUtils.disImageView(thumbs.get(i), imgV, R.drawable.loading_2, R.drawable.loading_2);
            layout.addView(imgV);
        }
    }
}
