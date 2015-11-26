package com.qianfeng.yiyuantao.fragment;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.activity.RegisterActivity;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class MineFragment extends Fragment implements View.OnClickListener {
    private Button btn_login_id,bt_zjremeb,bt_dbremeb,bt_showre,bt_address,bt_message_mine,bt_service_mine;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mine, container, false);
        initView(view);
        return view;
    }

    private void initView(View view) {
        btn_login_id = (Button) view.findViewById(R.id.btn_login_id);
        btn_login_id.setOnClickListener(this);

        bt_zjremeb = (Button) view.findViewById(R.id.bt_zjremeb);
        bt_zjremeb.setOnClickListener(this);

        bt_dbremeb = (Button) view.findViewById(R.id.bt_dbremeb);
        bt_dbremeb.setOnClickListener(this);

        bt_showre = (Button) view.findViewById(R.id.bt_showre);
        bt_showre.setOnClickListener(this);

        bt_address = (Button) view.findViewById(R.id.bt_address);
        bt_address.setOnClickListener(this);

        bt_message_mine = (Button) view.findViewById(R.id.bt_message_mine);
        bt_message_mine.setOnClickListener(this);

        bt_service_mine = (Button) view.findViewById(R.id.bt_service_mine);
        bt_service_mine.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(getActivity(), RegisterActivity.class);
        startActivity(intent);
    }
}
