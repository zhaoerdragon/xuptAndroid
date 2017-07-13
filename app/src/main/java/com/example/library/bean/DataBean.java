package com.example.library.bean;

/**
 * 存储数据的Bean
 * 存储从后台获取的不同的数据
 */
public class DataBean {

    String time;            //存储数据的时间
    String A;               //温度
    String B;               //湿度
    String C;               //光照强度
    String D;               //紫外线
    String E;               //二氧化碳浓度
    String F;               //大气压
    String G;               //风速
    String H;               //风向

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getA() {
        return A;
    }

    public void setA(String a) {
        A = a;
    }

    public String getB() {
        return B;
    }

    public void setB(String b) {
        B = b;
    }

    public String getC() {
        return C;
    }

    public void setC(String c) {
        C = c;
    }

    public String getD() {
        return D;
    }

    public void setD(String d) {
        D = d;
    }

    public String getE() {
        return E;
    }

    public void setE(String e) {
        E = e;
    }

    public String getF() {
        return F;
    }

    public void setF(String f) {
        F = f;
    }

    public String getG() {
        return G;
    }

    public void setG(String g) {
        G = g;
    }

    public String getH() {
        return H;
    }

    public void setH(String h) {
        H = h;
    }

}
