package com.example.library.tools;


import android.graphics.Typeface;

import com.example.library.bean.DataBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.List;

/**
 * Gson解析工具类
 */
public class GsonUtils {

    /**
     * 工具类不能被初始化
     */
    public GsonUtils(){
        throw new UnsupportedOperationException("cannot be instananed");
    }

    /**
     * 解析一个Json数据
     * @param jsonString
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T getInfo(String jsonString ,Class<T> tClass){
        T t = null;
        Gson gson =new Gson();
        t = gson.fromJson(jsonString,tClass);
        return t;
    }

    /**
     * 解析得到的JsonArray数据，并将其转换为数组
     * @param jsonString
     * @return
     */
    public static ArrayList<DataBean> getListDataByGson(String jsonString) {

        ArrayList<DataBean> arrayList = null;
        try {
            arrayList = new ArrayList<>();
            Gson gson = new Gson();
            arrayList = gson.fromJson(jsonString, new TypeToken<ArrayList<DataBean>>() {
            }.getType());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return arrayList;
    }

}
