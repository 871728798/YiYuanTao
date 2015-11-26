package com.qianfeng.yiyuantao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.adapter.ShopCarLikeAdapter;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.util.Constants;
import com.qianfeng.yiyuantao.util.JsonUtils;
import com.qianfeng.yiyuantao.util.NetUtils;

import java.util.List;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class ShoppingCartFragment extends Fragment implements NetUtils.RequestCallCack {
    private RecyclerView rv;
    private ShopCarLikeAdapter adapter;
    private Button bt_imd_shoppcar;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_shopping_cart, container, false);
        initView(view);
        dowmloaddata();
        return view;
    }

    private void dowmloaddata() {
        NetUtils.getDataFromNet(this, Constants.URL.SHOPPING_URL);
    }

    private void initView(View view) {
        bt_imd_shoppcar = (Button) view.findViewById(R.id.bt_imd_shoppcar);
        rv = (RecyclerView) view.findViewById(R.id.rv_id);
        //设置布局管理器
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        rv.setLayoutManager(linearLayoutManager);
        adapter =new  ShopCarLikeAdapter(getActivity(),R.layout.shopcarlike_layout);
        rv.setAdapter(adapter);
        /**
         * 对“马上夺宝”按钮设置监听
         */
        bt_imd_shoppcar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getActivity(),"夺宝。。",Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onSuccess(ResponseInfo<String> responseInfo) {
        List<PrizeEntity> entities = JsonUtils.parseAllCommodity(responseInfo.result);
        adapter.setDatas(entities);
    }

    @Override
    public void onFailure(HttpException e, String s) {
    }
}
