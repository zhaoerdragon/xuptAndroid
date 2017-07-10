package com.zhaoerdragon.xuptandroid.tools;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by willscorpio on 7/10/17.
 */
public class ConvertSafeUtilsTest {

    /**
     * 测试类的初期设置
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {

    }

    @Test
    public void convertToInt() throws Exception {
        assertEquals(4, ConvertSafeUtils.convertToInt(42.3, 0));
    }

    @Test
    public void convertToFloat() throws Exception {
        assertEquals(3.12, ConvertSafeUtils.convertToFloat(3.12f, 0));
    }

    @Test
    public void convertToDouble() throws Exception {
        assertEquals(42.2, ConvertSafeUtils.convertToDouble(42.2d, 0));
    }

    @Test
    public void convertToLong() throws Exception {
        assertEquals(1209L, ConvertSafeUtils.convertToLong(1209, 0));
    }

}