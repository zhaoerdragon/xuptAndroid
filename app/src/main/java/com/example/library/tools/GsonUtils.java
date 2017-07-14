package com.example.library.tools;


import android.graphics.Typeface;
import android.support.annotation.NonNull;

import com.example.library.bean.DataBean;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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
     * 将Json字符串转变成为ArrayList对象
     *
     * @param jsonString
     * @param <T>
     * @return
     */
    public static <T> List<T> getListInfo(String jsonString) {
        Gson gson = new Gson();
        List<T> tList;
        tList = gson.fromJson(jsonString, new TypeToken<List<T>>() {
        }.getType());
        return tList;
    }
}
