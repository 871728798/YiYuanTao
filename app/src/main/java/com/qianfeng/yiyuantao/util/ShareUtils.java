package com.qianfeng.yiyuantao.util;

import android.content.Context;
import android.content.SharedPreferences;import java.lang.String;

/**
 * Created by Administrator on 2015/11/17 0017.
 */
public class ShareUtils {

    private static SharedPreferences sharedPreferences;
    private static SharedPreferences.Editor editor;

    public static void init(Context context){
        sharedPreferences = context.getSharedPreferences("config", 0);
        editor = sharedPreferences.edit();
    }

    public static String getString(String key){
        return sharedPreferences.getString(key, null);
    }

    public static void putString(String key, String value){
        editor.putString(key, value);
        editor.commit();
    }

    public static int getInt(String key){
        return sharedPreferences.getInt(key, -1);
    }

    public static void putInt(String key, int value) {
        editor.putInt(key, value);
        editor.commit();
    }

}
