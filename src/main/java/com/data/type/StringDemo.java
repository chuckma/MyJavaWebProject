package com.data.type;

public class StringDemo {
    public static void main(String[] args) {
        String str1 = "123";
        String str2 = "123";
        String str3 = new String("123");
        System.out.println(str2.hashCode());
        System.out.println(str1.equals(str2));
        System.out.println(str1==str2);
        System.out.println(str1.equals(str3));
        System.out.println(str1==str3);
    }
}
