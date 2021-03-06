package com.qianfeng.yiyuantao.util;

import android.util.Log;

import com.alibaba.fastjson.JSON;
import com.qianfeng.yiyuantao.bean.CommentEntity;
import com.qianfeng.yiyuantao.bean.FirstPageEntity;
import com.qianfeng.yiyuantao.bean.NewPublishEntity;
import com.qianfeng.yiyuantao.bean.PrizeDetailEntity;
import com.qianfeng.yiyuantao.bean.PrizeEntity;
import com.qianfeng.yiyuantao.bean.ShowPrizeEntity;
import com.qianfeng.yiyuantao.bean.ViewPagerEntity;

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

    /**
     * 解析全部商品页
     */
    public static List<PrizeEntity> parseAllCommodity(String data){
        List<PrizeEntity> list = new ArrayList<>();
        try {
            JSONObject obj1 = new JSONObject(data);
            JSONArray arr1 = obj1.getJSONArray("data");
            list = JSON.parseArray(arr1.toString(),PrizeEntity.class);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return  list;
    }

    /**
     * 解析搜索结果
     * @param json
     */
    public static List<PrizeEntity> parseSearchResult(String json) {
        try {
            JSONObject object = new JSONObject(json);
            int code = object.getInt("code");
            if (code == 0){
                JSONArray array = object.getJSONArray("data");
                List<PrizeEntity> datas = JSON.parseArray(array.toString(), PrizeEntity.class);
                return datas;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static  List<ShowPrizeEntity> parseShowDatas(String json) {
        try {
            JSONObject object = new JSONObject(json);
            int code = object.getInt("code");
            if(code == 0){
                object = object.getJSONObject("data");
                JSONArray array = object.getJSONArray("data1");
                List<ShowPrizeEntity> datas = JSON.parseArray(array.toString(), ShowPrizeEntity.class);
                return datas;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static List<CommentEntity> getCommentEntiyDatas(String json) {
        JSONObject object = null;
        try {
            object = new JSONObject(json);
            JSONArray array = object.getJSONArray("data");
            List<CommentEntity> commentEntities = JSON.parseArray(array.toString(), CommentEntity.class);
            return commentEntities;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static ViewPagerEntity getViewPagerEntityDatas(String json) {
        try {
            JSONObject object = new JSONObject(json);
            object = object.getJSONObject("data");
            ViewPagerEntity viewPagerEntity = JSON.parseObject(object.toString(), ViewPagerEntity.class);
            return viewPagerEntity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static PrizeDetailEntity getPrizeDetailEntityDatas(String json) {
        try {
            JSONObject object = new JSONObject(json);
            object = object.getJSONObject("data");
            PrizeDetailEntity prizeDetailEntity = JSON.parseObject(object.toString(), PrizeDetailEntity.class);
            return prizeDetailEntity;
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }

}
/**
 * for (int i = 0;i<arr1.length();i++){
 entity = new PrizeEntity();
 JSONObject obj2 = arr1.getJSONObject(i);
 entity.setCount_buyed((Integer) obj2.get("count_buyed"));
 entity.setCategory_id((Integer) obj2.get("category_id"));
 entity.setDescription((String) obj2.get("description"));
 entity.setGoods_id((Integer) obj2.get("goods_id"));
 entity.setLevel((Integer) obj2.get("level"));
 entity.setPrice((Integer) obj2.get("price"));
 }
 */
