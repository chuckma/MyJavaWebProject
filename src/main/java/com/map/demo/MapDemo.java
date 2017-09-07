package com.map.demo;

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
    }

}
