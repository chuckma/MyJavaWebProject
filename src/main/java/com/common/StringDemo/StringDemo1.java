package com.common.StringDemo;

/**
 * @author Administrator
 */
public class StringDemo1 {


    public static void main(String[] args) {
        String str = "1231";
        str += "45678";
        System.out.println(str);


        String str1 = "a,b,c,,";
        String[] arr = str1.split(",");
        for (String s : arr) {
            System.out.println(s);
        }
        System.out.println(arr.length);
    }
}
