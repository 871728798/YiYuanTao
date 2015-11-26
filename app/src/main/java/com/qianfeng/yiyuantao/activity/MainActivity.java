package com.qianfeng.yiyuantao.activity;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;

import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.util.ShareUtils;

public class MainActivity extends ActionBarActivity implements Runnable {

    private boolean isFirst;//判断是否是第一次安装应用
    private Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isFirst = ShareUtils.getIBoolean("isFirst");//去本地读取数据来
        handler.postDelayed(this, 3000);//停留在本界面3秒后跳转
    }

    @Override
    public void run() {
        if(isFirst){
            ShareUtils.putBoolean("isFirst", false);//第一次进入应用后写入共享参数
            Intent intent = new Intent(this, GuideActivity.class);//进入guide导航界面
            startActivity(intent);
        }else{
            Intent intent = new Intent(this, HomeActivity.class);//直接进入应用
            startActivity(intent);
        }
        this.finish();
    }
}
