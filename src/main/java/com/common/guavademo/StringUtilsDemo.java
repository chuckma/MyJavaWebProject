package com.common.guavademo;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Andy on 2017/11/7.
 */
public class StringUtilsDemo {


    public static void main(String[] args) {

        // 判断某字符串是否为空，为空的标准是 str==null 或 str.length()==0
        System.out.println(StringUtils.isEmpty(""));
        System.out.println(StringUtils.isEmpty(" "));
        System.out.println(StringUtils.isEmpty(null));
        System.out.println(StringUtils.isEmpty("Charles"));

        System.out.println("**********************");

        //  判断某字符串是否非空，等于 !isEmpty(String str)

        System.out.println(StringUtils.isNotEmpty(null));
        System.out.println(StringUtils.isNotEmpty(""));
        System.out.println(StringUtils.isNotEmpty(" "));
        System.out.println(StringUtils.isNotEmpty("         "));
        System.out.println(StringUtils.isNotEmpty("bob"));
        System.out.println(StringUtils.isNotEmpty(" bob "));

        System.out.println("**********************");

        //判断某字符串是否为空或长度为0或由空白符(whitespace) 构成
        System.out.println(StringUtils.isBlank(null));
        System.out.println(StringUtils.isBlank(""));
        System.out.println(StringUtils.isBlank(" "));
        System.out.println(StringUtils.isBlank("         "));
        System.out.println(StringUtils.isBlank("bob"));
        System.out.println(StringUtils.isBlank(" bob "));

        System.out.println("**********************");
    }
}
