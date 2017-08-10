package com.example.library.tools;

/**
 * 类型安全转换函数
 */
public class ConvertSafeUtil {

    /**
     * 工具类不能被初始化
     */
    public ConvertSafeUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 将值安全转换成int类型，否则返回默认类型
     * @param value 被转换的值
     * @param defaultValue 默认的值
     * @return
     */
    public static int convertToInt(Object value, int defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Integer.valueOf(value.toString().trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将值安全转换成float类型，否则返回默认类型
     * @param value
     * @param defaultValue
     * @return
     */
    public static float convertToFloat(Object value, float defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Float.valueOf(value.toString().trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将值安全转换成double类型，否则返回默认类型
     * @param value
     * @param defaultValue
     * @return
     */
    public static double convertToDouble(Object value, double defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Double.valueOf(value.toString().trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 将值安全转换成long类型，否则返回默认类型
     * @param value
     * @param defauleValue
     * @return
     */
    public static long convertToLong(Object value, long defaultValue) {
        if (value == null || "".equals(value.toString().trim())) {
            return defaultValue;
        }
        try {
            return Long.valueOf(value.toString().trim());
        } catch (Exception e) {
            return defaultValue;
        }
    }

}
