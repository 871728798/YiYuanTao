package com.qianfeng.yiyuantao.custom;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ListView;

/**
 * Created by Lee on 2015/11/25.
 */
public class MyListView extends ListView {
    public MyListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    //ListView和ScrollView滑动冲突的解决
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int exSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2, MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, exSpec);
    }
}
