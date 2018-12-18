package com.common.StringDemo;

import org.apache.commons.lang.StringUtils;

/**
 * Created by Andy on 2017/11/7.
 */
public class StringUtilsDemo {


    public static void main(String[] args) {
        System.out.println(StringUtils.isNotBlank(""));

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

        String s1 = "";
        String s2 = " ";
        String s3 = null;

        System.out.println(StringUtils.isNotBlank(s2));
        String s = StringUtils.trimToEmpty(s2);
        System.out.println(s.length()==s1.length());


        String s4 = " 231 2 ";
        String s5 = " 12331";
        String s6 = "213213 ";
        System.out.println(s4);
        System.out.println(s4.length());
        System.out.println(s5);
        System.out.println(s6);
        System.out.println(StringUtils.trimToEmpty(s4));
        System.out.println(StringUtils.trimToEmpty(s4).length());
        System.out.println(StringUtils.trimToEmpty(s5));
        System.out.println(StringUtils.trimToEmpty(s6));
    }
}
