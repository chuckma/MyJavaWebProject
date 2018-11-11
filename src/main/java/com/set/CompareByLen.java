package com.set;

import java.util.Comparator;

/**
 * 制定TreeSet中按照String长度比较String。
 *
 * TreeSet 传入比较的方式来比较
 */
public class CompareByLen implements Comparator<String> {

    @Override
    public int compare(String s1, String s2) {        //按照字符串的长度比较
        int num = s1.length() - s2.length();        //长度为主要条件
        return num == 0 ? s1.compareTo(s2) : num;    //内容为次要条件
    }
}