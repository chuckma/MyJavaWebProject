package com.common.gsondemo;

import com.google.gson.Gson;

import java.util.Map;

/**
 * @author Administrator
 */
public class test {

    private static final Gson gson = new Gson();

    public static void main(String[] args) {
        String str = "{\"0\":\"zhangsan\",\"1\":\"lisi\",\"2\":\"wangwu\",\"3\":\"maliu\"}";
        String sss =  "{\"errcode\": 40014, \"errmsg\": \"invalid access_token\"}";

//        Gson gson = new Gson();
        Map map = gson.fromJson(sss, Map.class);
        System.out.println(Double.parseDouble(map.get("errcode").toString()) == 40014);
        for (Object obj : map.keySet()){
            System.out.println("key为："+obj+"值为："+map.get(obj));
        }


        double d1 = 2.33;
        double d2 = 3.22;
        double d3 = 3.22;
        double d4 = 3.0;
        double d5 = 3;
        System.out.println(d1 == d2);
        System.out.println(d2 == d3);
        System.out.println(d4 == d5);

    }
}
