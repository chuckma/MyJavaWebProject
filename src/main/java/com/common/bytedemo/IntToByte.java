package com.common.bytedemo;

/**
 * @Author mcg
 * @Date 2019/5/13 21:50
 **/

public class IntToByte {


    public static void main(String[] args) {
        int a =160;
        byte b = (byte) a;
        int c =b;
        System.out.println(b);
        System.out.println(c);
        System.out.println(intToByteArray(166));
    }


    public static byte[] intToByteArray(int i) {
        byte[] result = new byte[4];
        result[0] = (byte)((i >> 24) & 0xFF);
        result[1] = (byte)((i >> 16) & 0xFF);
        result[2] = (byte)((i >> 8) & 0xFF);
        result[3] = (byte)(i & 0xFF);
        return result;
    }

}
