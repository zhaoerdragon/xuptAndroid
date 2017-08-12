package com.example.library.tools;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v4.content.SharedPreferencesCompat;

import java.util.Map;
import java.util.Set;

/**
 * SharedPreferences工具类，简化对SharedPreferences的操作
 */
public class SharedPreferencesUtil {

    /**
     * 工具类不能被初始化
     */
    public SharedPreferencesUtil() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 获取SharedPreferences
     * @param context
     * @param fileName
     * @return
     */
    public static SharedPreferences getPreferences(Context context, String fileName) {
        return context.getSharedPreferences(fileName, Context.MODE_PRIVATE);
    }

    /**
     * 在SharedPreferences中保存一条数据
     *
     * @param sharedPreferences
     * @param key
     * @param data
     */
    public static void saveData(SharedPreferences sharedPreferences, String key, Object data) {

        SharedPreferences.Editor editor = sharedPreferences.edit();

        if (data instanceof Boolean) {
            editor.putBoolean(key, (Boolean) data);
        } else {

            if (data instanceof Float) {
                editor.putFloat(key, (Float) data);
            } else {

                if (data instanceof Integer) {
                    editor.putInt(key, (Integer) data);
                } else {

                    if (data instanceof Long) {
                        editor.putLong(key, (Long) data);
                    } else {

                        if (data instanceof String) {
                            editor.putString(key, (String) data);
                        }
                    }
                }
            }
        }

        editor.apply();
    }

    /**
     * 从SharedPreferences中获取数据
     * @param sharedPreferences
     * @param key
     * @return
     */
    public static Object getData(SharedPreferences sharedPreferences, String key,Object defaultObject) {

        if (defaultObject instanceof Boolean) {
            return sharedPreferences.getBoolean(key, (Boolean) defaultObject);
        } else {

            if (defaultObject instanceof Float) {
                return sharedPreferences.getFloat(key, (Float) defaultObject);
            } else {

                if (defaultObject instanceof Integer) {
                    return sharedPreferences.getInt(key, (Integer) defaultObject);
                } else {

                    if (defaultObject instanceof Long) {
                        return sharedPreferences.getLong(key, (Long) defaultObject);
                    } else {

                        if (defaultObject instanceof String) {
                            return sharedPreferences.getString(key, (String) defaultObject);
                        }
                    }
                }
            }
        }

        return null;
    }

    /**
     * 在SharedPreferences中删除一条数据
     * @param sharedPreferences
     * @param key
     */
    public static void remove(SharedPreferences sharedPreferences, String key) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(key);
        editor.apply();
    }

    /**
     * 删除SharedPreferences中的所有数据
     * @param sharedPreferences
     */
    public static void clear(SharedPreferences sharedPreferences) throws Exception {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.apply();
    }

    /**
     * 查询SharedPreferences中是否包含值
     * @param sharedPreferences
     * @param key
     * @return
     */
    public static boolean contains(SharedPreferences sharedPreferences, String key) {
        return sharedPreferences.contains(key);
    }

    /**
     * 返回SharedPreferences中的所有数据
     * @param sharedPreferences
     * @return
     */
    public static Map<String, ?> getAll(SharedPreferences sharedPreferences) {
        return sharedPreferences.getAll();
    }

}
