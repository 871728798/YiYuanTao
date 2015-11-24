package com.qianfeng.yiyuantao.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.ABSBaseAdapter2;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class FirstPageNewPublishView extends RelativeLayout{

    private GridView gridView;
    private GrideViewAdapter adapter;

    public FirstPageNewPublishView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        LayoutInflater.from(getContext()).inflate(R.layout.custom_first_page_new_publish_layout, this, true);
        gridView = (GridView) findViewById(R.id.gride_view);
        adapter = new GrideViewAdapter(getContext());
        gridView.setAdapter(adapter);
    }

    public void setDatas(List<NewPublishEntity> datas){
        adapter.setDatas(datas);
    }




    private class GrideViewAdapter extends ABSBaseAdapter2<NewPublishEntity>{

        public GrideViewAdapter(Context context) {
            super(context, R.layout.item_grideview_new_publish);
        }

        @Override
        public void bindDatas(ViewHolder viewHolder, NewPublishEntity data, int position) {
            ImageView iv = (ImageView) viewHolder.getView(R.id.iv_id);
            NetUtils.disImageView(data.getPrize_detail().getThumb_nail(),iv, R.drawable.loading_2, R.drawable.loading_2);

            TextView tv_title, tv_win, tv_user, tv_loading;
            tv_title = (TextView) viewHolder.getView(R.id.tv_title);
            tv_title.setText(data.getPrize_detail().getTitle());
            tv_win = (TextView) viewHolder.getView(R.id.tv_win);
            tv_user = (TextView) viewHolder.getView(R.id.tv_user);
            tv_loading = (TextView) viewHolder.getView(R.id.tv_loading);
            if(data.getCount() == -1){
                tv_win.setVisibility(GONE);
                tv_user.setVisibility(GONE);
                tv_loading.setVisibility(VISIBLE);
                int time = data.getRemain_sec();
                tv_loading.setText(time + "");
            }else{
                tv_loading.setVisibility(GONE);
                tv_win.setVisibility(VISIBLE);
                tv_user.setVisibility(VISIBLE);
                tv_user.setText(data.getUser().getNickname());
            }
        }
   }
}
