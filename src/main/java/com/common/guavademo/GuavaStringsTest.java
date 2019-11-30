package com.common.guavademo;

import com.google.common.base.Strings;

/**
 * @Author mcg
 * @Date 2019/11/30 14:17
 * <p>
 * <p>
 * Guava Strings 测试
 **/

public class GuavaStringsTest {


    public static final String a = "12a345x";
    public static final String c = "12345x";

    public static void main(String[] args) {
        testStrings1();
    }


    public static void testStrings1() {

        // 1
        // 字符串尾部添加 (minLength - a.length())个 padChar x
        // padEnd 返回的长度是 minLength
        String b = Strings.padEnd(a, 10, 'x');
        System.out.println(b);

        // 2
        // padStart 就是在字符串前面添加 指定的字符串，添加后最小的长度为 minLength
        String x = Strings.padStart(a, 10, 'x');
        System.out.println(x);

        // 3
        // 校验控制空值  null or ""
        System.out.println(Strings.isNullOrEmpty(null));
        System.out.println(Strings.isNullOrEmpty(""));


        // 4
        // nullToEmpty() null to ""
        System.out.println(Strings.nullToEmpty(null));

        // 5 emptyToNull
        System.out.println(Strings.emptyToNull(""));


        // 6 重复字符串
        // 将指定字符串 复制 count 次，后合并
        System.out.println(Strings.repeat("321", 3));

        // 7 获取 a c 字符串左公共部分的字符串
        System.out.println(Strings.commonPrefix(a, c));


        // 8 获取 a c 字符串右公共部分的字符串
        System.out.println(Strings.commonSuffix(a,c));

    }
}
