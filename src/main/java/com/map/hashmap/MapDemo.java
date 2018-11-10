package com.map.hashmap;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 2017/9/7.
 */
public class MapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap();
        int hc = map.hashCode();
        map.clear();
        map.entrySet();
        System.out.println(hc);


        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(null, 1);
        map1.put(2, null);
        System.out.println(map1.get(null));
        System.out.println(map1.get(1));
    }

}
