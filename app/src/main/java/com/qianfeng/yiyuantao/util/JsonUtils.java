package com.qianfeng.yiyuantao.util;

import com.alibaba.fastjson.JSON;
import com.qianfeng.yiyuantao.bean.FirstPageEntity;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.List;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class JsonUtils {

    /**
     *解析首页json的数据
     */
    public static FirstPageEntity parstFirstPageDatas(String json){
        try {
            JSONObject object = new JSONObject(json);
            object = object.getJSONObject("data");
            FirstPageEntity firstPageEntity = JSON.parseObject(object.toString(), FirstPageEntity.class);
            return  firstPageEntity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}
