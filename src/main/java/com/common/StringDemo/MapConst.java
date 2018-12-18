package com.common.StringDemo;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class MapConst {
    private static Map<String, String> getField(Class obj) {
        Map<String, String> map = new HashMap<>();

        Field[] field1 = obj.getDeclaredFields();

        for (int i = 0; i < field1.length; i++) {

            field1[i].setAccessible(true);
            try {
                map.put(field1[i].get(obj).toString(), field1[i].get(obj).toString());
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        return map;
    }
    public static void main(String[] args) {
//        Field[] fields = Const.
        Map<String,String> map = getField(Const.class);
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println(JSON.toJSON(entry));
        }
    }



}

