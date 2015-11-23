package com.qianfeng.yiyuantao.util;

import com.alibaba.fastjson.JSON;
import com.qianfeng.yiyuantao.bean.FirstPageEntity;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class JsonUtils {

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

        if (json != null) {
            try {
                JSONObject object = new JSONObject(json);
                JSONArray array = object.getJSONArray("data");
                List<NewPublishEntity> newPublishEntities = JSON.parseArray(array.toString(), NewPublishEntity.class);
                return newPublishEntities;
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
        return null;
    }
}
