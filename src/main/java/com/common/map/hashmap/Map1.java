package com.common.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mcg
 * @Date 2019/3/3 19:32
 **/

public class Map1 {


    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap();

        for (int i = 0; i < 10; i++) {
            map.put(i, i);
        }

        System.out.println(map);
    }
}
