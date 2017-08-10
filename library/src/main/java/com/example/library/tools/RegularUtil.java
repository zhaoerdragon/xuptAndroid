package com.example.library.tools;

import java.util.regex.Pattern;

/**
 * 正则表达式工具类
 */
public class RegularUtil {

    /**
     * 工具类不能初始化
     */
    public RegularUtil(){
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 判断一个字符串是不是由英文构成
     */
    public static boolean isAllEnglish(String string){
        return Pattern.matches("^[A-Za-z]+$",string);
    }

    /**
     * 判断一个字符串是不是由数字构成
     */
    public static boolean isAllNumber(String string){
        return Pattern.matches("^[0-9]*$",string);
    }
}
