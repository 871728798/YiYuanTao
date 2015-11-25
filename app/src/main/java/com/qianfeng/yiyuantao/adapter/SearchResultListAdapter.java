package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.util.NetUtils;

/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class SearchResultListAdapter extends ABSBaseAdapter2<PrizeEntity>{

    public SearchResultListAdapter(Context context) {
        super(context, R.layout.item_list_search_result);
    }

    @Override
    public void bindDatas(View view, ViewHolder viewHolder, PrizeEntity data) {
        ImageView iv = (ImageView) viewHolder.getView(R.id.iv_id);
        NetUtils.disImageView(data.getThumb_nail(), iv, R.drawable.loading_2, R.drawable.loading_2);

        TextView tv_title = (TextView) viewHolder.getView(R.id.tv_title);
        tv_title.setText("第"+ data.getPeroid()+"期 "+data.getTitle());

        TextView tv_price = (TextView) viewHolder.getView(R.id.tv_price);
        tv_price.setText(data.getPrice()+"");

        View gray_line = viewHolder.getView(R.id.view_id);
        View red_line = viewHolder.getView(R.id.red_view_id);
        ViewGroup.LayoutParams params = red_line.getLayoutParams();
        params.width = (int) ((float)data.getCount_buyed() / data.getPrice() * gray_line.getWidth());
        red_line.setLayoutParams(params);

        TextView tv_count_else = (TextView) viewHolder.getView(R.id.tv_count_else);
        tv_count_else.setText(data.getCount_else()+"");
    }
}
