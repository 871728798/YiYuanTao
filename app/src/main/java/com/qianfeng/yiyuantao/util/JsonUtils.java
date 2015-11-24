package com.qianfeng.yiyuantao.util;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.qianfeng.yiyuantao.bean.FirstPageEntity;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class JsonUtils {

    private static final String TAG = "print";

    /**
     * 解析首页json的数据
     */
    public static FirstPageEntity parstFirstPageDatas(String json) {
        try {
            JSONObject object = new JSONObject(json);
            object = object.getJSONObject("data");
            FirstPageEntity firstPageEntity = JSON.parseObject(object.toString(), FirstPageEntity.class);
            return firstPageEntity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     *
     */
    public static List<NewPublishEntity> getNewPublishDatas(String json) {
        List<NewPublishEntity> list = new ArrayList<>();
        if (json != null) {

            try {
                JSONObject object = new JSONObject(json);
                JSONArray array = object.getJSONArray("data");
                Log.d(TAG,array.length()+"");
                for (int i = 0; i < array.length(); i++) {
                    JSONObject jsonObject = array.getJSONObject(i);

                    try{
                        NewPublishEntity newPublishEntity = JSON.parseObject(jsonObject.toString(), NewPublishEntity.class);
                        Log.d(TAG, i + "   " + jsonObject.toString());
                        list.add(newPublishEntity);
                    }catch (Exception e){
                        e.printStackTrace();
                    }

                }
                Log.d(TAG, "---------" + list.toString());
//                List<NewPublishEntity> newPublishEntities = JSON.parseArray(array.toString(), NewPublishEntity.class);
                return list;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return list;
    }
}
