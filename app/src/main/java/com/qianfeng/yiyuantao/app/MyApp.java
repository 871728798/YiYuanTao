package com.qianfeng.yiyuantao.app;

import android.app.Application;
import android.graphics.Bitmap;

import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.qianfeng.yiyuantao.R;
import com.qianfeng.yiyuantao.util.ShareUtils;

/**
 * Created by Administrator on 2015/11/21 0021.
 */
public class MyApp extends Application{
    public static ImageLoader imageLoader;

    @Override
    public void onCreate() {
        super.onCreate();

        ShareUtils.init(this);

        //初始化ImageLoader和参数
        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        imageLoader.init(configuration);

    }
}