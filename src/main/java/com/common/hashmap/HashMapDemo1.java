package com.common.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Administrator
 */
public class HashMapDemo1 {


    public static void main(String[] args) {
        Map<Integer,String> map = new HashMap<>();
        map.put(5, "A");
        map.put(7, "B");
        map.put(3, "C");
        System.out.println(map);
      /*  for (int i = 0; i < 94; i++) {
            map.put(i, i);
        }
        System.out.println(map.size());

        int i = 1;
        int j = i++;
        System.out.println(j);*/
    }
}
