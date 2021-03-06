package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2015/11/16 0016.
 */
public abstract class ABSBaseAdapter<T> extends BaseAdapter{

    private List<T> datas;
    private Context context;
    private int[] resId;

    public ABSBaseAdapter( Context context, int... resId) {
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

    /**
     * 强制要求使用这个封装适配器的数据源的实体类中必须有一个名字叫做"type"的属性
     * @param position
     * @return
     */
    @Override
    public int getItemViewType(int position) {

        T data = datas.get(position);
        Class c = data.getClass();
        try {
            Field field = c.getDeclaredField("type");
            field.setAccessible(true);
            return field.getInt(data);
        }catch (Exception e){
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int getViewTypeCount() {
        return resId.length;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder = null;
        if(view == null){
            view = LayoutInflater.from(context).inflate(resId[getItemViewType(position)], viewGroup, false);
            viewHolder = new ViewHolder(view);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) view.getTag();
        }
        bindDatas(viewHolder, datas.get(position), position);

        return view;
    }

    public abstract void bindDatas(ViewHolder viewHolder, T data, int position);

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
