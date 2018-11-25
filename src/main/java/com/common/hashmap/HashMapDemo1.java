package com.common.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class HashMapDemo1 {


    public static void main(String[] args) {
        Map<Integer,Integer> map = new HashMap<>(128);
        for (int i = 0; i < 94; i++) {
            map.put(i, i);
        }
        System.out.println(map.size());

        int i = 1;
        int j = i++;
        System.out.println(j);
    }
}
