package com.qianfeng.yiyuantao.util;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest;import java.lang.String;

/**
 * Created by Administrator on 2015/11/15 0015.
 */
public class NetUtils {

    /**
     * 请求网络网络数据
     * @param requestCallBack 网络数据返回时回调的接口
     * @param url
     */
    public static void getDataFromNet(final RequestCallBack requestCallBack,String url){
        HttpUtils httpUtils = new HttpUtils();
        httpUtils.send(HttpRequest.HttpMethod.POST, url, new RequestCallBack<String>() {
            @Override
            public void onSuccess(ResponseInfo<String> responseInfo) {
                requestCallBack.onSuccess(responseInfo);
            }

            @Override
            public void onFailure(HttpException e, String s) {
                requestCallBack.onFailure(e, s);
            }
        });
    }

    public interface RequestCallCack{
        void onSuccess(ResponseInfo<String> responseInfo);
        void onFailure(HttpException e, String s);
    }
}
