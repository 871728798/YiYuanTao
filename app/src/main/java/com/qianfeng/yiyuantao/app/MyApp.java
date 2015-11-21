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
    public static DisplayImageOptions options;

    @Override
    public void onCreate() {
        super.onCreate();

        ShareUtils.init(this);

        //初始化ImageLoader和参数
        imageLoader = ImageLoader.getInstance();
        ImageLoaderConfiguration configuration = ImageLoaderConfiguration.createDefault(this);
        imageLoader.init(configuration);
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.mipmap.ic_launcher) //正在加载显示的图片
                .showImageOnFail(R.mipmap.img_cancel) //加载失败显示的图片
                .cacheInMemory(true) //开启内存缓存
                .cacheOnDisk(true)   //开启磁盘缓存
                        // 实际加载的时候，先去内存中找，找不到再去磁盘中找，最后再去网上下载
                .bitmapConfig(Bitmap.Config.ARGB_8888);
        options = builder.build();
    }
}