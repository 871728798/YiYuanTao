package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public abstract class ABSBaseAdapter2<T> extends BaseAdapter{

    private List<T> datas;
    private Context context;
    private int resId;

    public ABSBaseAdapter2(Context context, int resId) {
        this.datas = new ArrayList<>();
        this.context = context;
        this.resId = resId;
    }

    public void setDatas(List<T> datas){
        this.datas.clear();
        addDatas(datas);
    }

    public void addDatas(List<T> datas) {
        this.datas.addAll(datas);
        this.notifyDataSetChanged();
    }

    public List<T> getDatas(){
        return datas;
    }


    @Override
    public int getCount() {
        return datas.size();
    }

    @Override
    public T getItem(int i) {
        return datas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }



    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(resId, viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        bindDatas(view, viewHolder, datas.get(position));

        return view;
    }

    public abstract void bindDatas(View view, ViewHolder viewHolder, T data);

    public class ViewHolder{
        View layoutView;
        Map<Integer, View> mapCache = new HashMap<>();

        public ViewHolder(View layoutView) {
            this.layoutView = layoutView;
        }

        public View getView(int id){
            View view = null;
            if(mapCache.containsKey(id)){
                view = mapCache.get(id);
            }else{
                view = layoutView.findViewById(id);
                mapCache.put(id, view);
            }
            return  view;
        }
    }
}
