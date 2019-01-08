package com.common.StringDemo;

/**
 * @author Administrator
 */
public class StringDemo1 {


    public static void main(String[] args) {


        String towYearAgo = String.valueOf(Integer.parseInt("2019")-2);
        System.out.println(towYearAgo);

        /**
         *  intern() 作用有 2 个
         *  1 把字面量放到 常量池中（如果池子里没有该常量）
         *  2 返回字面量的引用 （如果池子里有该常量）
         */
        String s1 = "Hello World";
        String s2 = new String("Hello World").intern();
        String s3 = new String("Hello World");

        // true
        System.out.println((s1 == s2));
        // false
        System.out.println((s1 == s3));

        String str = "1231";
        str += "45678";
        System.out.println(str);


        String str1 = "a,b,c,,";
        String[] arr = str1.split(",");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println(arr.length);


        String ss1 = "HHHSSS";
//        System.out.println(ss1.replace("H", "2"));
        System.out.println(ss1.replaceAll("H", "2"));
    }
}
