package com.common.map.hashmap;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Author mcg
 * @Date 2019/3/3 19:32
 **/

public class Map1 {


    public static void main(String[] args) {
//        Map<Integer,Integer> map = new HashMap();
//
//        for (int i = 0; i < 10; i++) {
//            map.put(i, i);
//        }
//
//        System.out.println(map);

        Map<String,String> map= new HashMap<>();
        map.put("11", "1231");
        System.out.println(map.containsKey("1"));
        System.out.println(map.containsValue("1231"));

        System.out.println(Calendar.getInstance().getTimeInMillis());
        System.out.println(getPKid());
    }

    public static String getPKid() {
        java.util.Date d = Calendar.getInstance().getTime();
        SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
        long rid=Math.round(Math.random()*1000);
        String str="001";
        if(rid>9&&rid<99){
            str="0"+rid;
        }else if(rid<10){
            str="00"+rid;
        }else{
            str=String.valueOf(rid);
        }
        return f.format(d)+str;
    }
}
