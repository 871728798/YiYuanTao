package com.qianfeng.yiyuantao.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.qianfeng.yiyuantao.R;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class NewPublishFragment extends Fragment{
    private PullToRefreshListView pullToRefresh;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_new_publish, container, false);
        return view;
    }
}
