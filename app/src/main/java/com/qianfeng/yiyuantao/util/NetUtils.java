package com.qianfeng.yiyuantao.util;

import android.graphics.Bitmap;
import android.widget.ImageView;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.client.HttpRequest;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.qianfeng.yiyuantao.app.MyApp;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.lang.String;

/**
 * Created by Administrator on 2015/11/15 0015.
 */
public class NetUtils {

    /**
     * 请求网络网络数据
     *  @param requestCallBack 网络数据返回时回调的接口
     * @param url
     */
    public static String getDataFromNet(final RequestCallCack requestCallBack, String url) {
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.GET, url, new com.lidroid.xutils.http.callback.RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                requestCallBack.onSuccess(responseInfo);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                requestCallBack.onFailure(e, s);
            }
        });
        return url;
    }

    public static interface RequestCallCack {
        void onSuccess(ResponseInfo<String> responseInfo);
        void onFailure(HttpException e, String s);
    }

    public static void disImageView(String imgUrl, ImageView iv, int resId, int errorResId){
        DisplayImageOptions.Builder builder = new DisplayImageOptions.Builder()
                .showImageOnLoading(resId) //正在加载显示的图片
                .showImageOnFail(errorResId) //加载失败显示的图片
                .cacheInMemory(true) //开启内存缓存
                .cacheOnDisk(true)   //开启磁盘缓存
                        // 实际加载的时候，先去内存中找，找不到再去磁盘中找，最后再去网上下载
                .bitmapConfig(Bitmap.Config.ARGB_8888);
        DisplayImageOptions options = builder.build();
        MyApp.imageLoader.displayImage(imgUrl, iv, options);
    }

    /**
     * 下载Json数据
     * @param url
     * @return
     */
    public static String getJsonDatas(String url){
        HttpClient client = new DefaultHttpClient();
        HttpGet get = new HttpGet(url);
        try {
            HttpResponse response = client.execute(get);
            if (response.getStatusLine().getStatusCode() == 200){
                return EntityUtils.toString(response.getEntity());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
