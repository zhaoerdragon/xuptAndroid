package com.example.library.tools;


import com.google.gson.Gson;

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
     * 解析一组Json，转换为数组形式的数据
     * @param jsonString
     * @param tClass
     * @param <T>
     * @return
     */
    public static <T> T[] getArrayInfo(String jsonString, Class<T[]> tClass) {
        Gson gson = new Gson();
        T[] t = gson.fromJson(jsonString, tClass);

        return t;
    }

}
