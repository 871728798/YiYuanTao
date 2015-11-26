package com.qianfeng.yiyuantao.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by LXL on 2015/11/26.
 */
public abstract class AbsRecyclerAdapter<T> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private List<T> datas;
    private int count;
    private int resId;

    private OnItemClickListener onItemClickListener;
    private OnItemLongClickListener onItemLongClickListener;

    public AbsRecyclerAdapter(Context context, int resId){
        this.context = context;
        this.datas = new ArrayList();
        this.resId = resId;
    }

    public void setDatas(List<T> datas){
        this.datas = datas;
        this.count = this.datas.size();
        this.notifyDataSetChanged();
    }

    public void addDatas(List<T> datas){
        this.datas.addAll(datas);
        this.notifyItemRangeInserted(this.count, datas.size());
        this.count = this.datas.size();
    }

    public void addDatas(List<T> datas, int index){
        this.datas.addAll(index, datas);
        this.notifyItemRangeInserted(index, datas.size());
        this.count = this.datas.size();
    }

    public void addData(T data, int index){
        this.datas.add(index, data);
        this.notifyItemInserted(index);
    }

    public void removeData(int index){
        this.datas.remove(index);
        this.notifyItemRemoved(index);
    }

    @Override
    public int getItemCount() {
        return datas.size();
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(resId, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        bindDatas((MyViewHolder)holder, datas.get(position));
    }

    public abstract void bindDatas(MyViewHolder holder, T data);

    /**
     * 自定义ViewHolder
     */
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        private Map<Integer, View> mapCache = new HashMap();
        private View layoutView;

        public MyViewHolder(View layoutView) {
            super(layoutView);
            this.layoutView = layoutView;
            this.layoutView.setOnClickListener(this);
            this.layoutView.setOnLongClickListener(this);
        }

        public View getView(int id){
            View view;
            if(mapCache.containsKey(id)){
                view = mapCache.get(id);
            } else {
                view = layoutView.findViewById(id);
                mapCache.put(id, view);
            }
            return view;
        }

        @Override
        public void onClick(View v) {
            if(onItemClickListener != null){
                onItemClickListener.onItemClick(v, getAdapterPosition());
            }
        }

        @Override
        public boolean onLongClick(View v) {
            if(onItemLongClickListener != null){
                onItemLongClickListener.onItemLongClick(v, getAdapterPosition());
            }
            return false;
        }
    }

    public interface OnItemClickListener{
        void onItemClick(View v, int position);
    }

    public interface OnItemLongClickListener{
        void onItemLongClick(View v, int position);
    }

    public void setOnItemLongClickListener(OnItemLongClickListener onItemLongClickListener) {
        this.onItemLongClickListener = onItemLongClickListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }
}
