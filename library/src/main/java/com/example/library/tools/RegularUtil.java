package com.example.library.tools;

import java.util.regex.Matcher;
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
     * 判断字符串是否英文
     * @param string
     * @return
     */
    public static boolean isAllEnglish(String string){
        return Pattern.matches("^[A-Za-z]+$",string);
    }

    /**
     * 判断字符串是否数字
     * @param string
     * @return
     */
    public static boolean isAllNumber(String string){
        return Pattern.matches("^[0-9]*$",string);
    }

    /**
     * 判断email格式是否正确
     * @param email
     * @return
     */
    public static boolean isEmailAddress(String email) {
        String str = "^([a-zA-Z0-9_\\-\\.]+)@((\\[[0-9]{1,3}\\.[0-9]{1,3}\\.[0-9]{1,3}\\.)|(([a-zA-Z0-9\\-]+\\.)+))([a-zA-Z]{2,4}|[0-9]{1,3})(\\]?)$";
        Pattern p = Pattern.compile(str);
        Matcher m = p.matcher(email);
        return m.matches();
    }
}
