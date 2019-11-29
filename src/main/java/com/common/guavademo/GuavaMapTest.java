package com.common.guavademo;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

import java.util.Map;

/**
 * @Author mcg
 * @Date 2019/11/29 19:36
 *
 *
 * guava map 相关 方法测试
 **/

public class GuavaMapTest {


    public static void main(String[] args) {

        maptest1();
    }


    // 一个map中包含key为String类型，value为List类型
    public static void maptest1() {
        Multimap<String,Integer> map = ArrayListMultimap.create();
        map.put("aa", 1);
        map.put("aa", 2);
        map.put("bb", 3);

        // 是否包含某个key
        System.out.println("是否包含key aa ? "+map.containsKey("aa"));
        // 是否包含某个值
        System.out.println("是否包含值 2 ？"+map.containsValue(2));

        // 遍历 map
        for (Map.Entry<String, Integer> stringIntegerEntry : map.entries()) {
            System.out.println(stringIntegerEntry.getValue());
        }

        // 返回key, 相同的key 以 key ✖ n， n 为 key 出现的次数 eg.[aa x 2, bb]
        System.out.println(map.keys());
        System.out.println(map.get("aa"));  //[1, 2]


        // 返回去重后的 key 值
        System.out.println("去重后的key ："+map.keySet());

        System.out.println("判断 map 是否为 空，size 为0 ？"+map.isEmpty());


        // 移除 key ，相同的 key 会移除全部
        map.removeAll("aa");
        System.out.println("移除aa以后的map："+map);



        // Multimap 可以添加 null ，key 和 value 都可以为 null，并且可以多次添加
        // null 在这里相当于一个普通的key
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);
        map.put(null, null);
        map.put(null, 324);
        System.out.println("添加 key 为 null value 为 null 后的map "+map);

        System.out.println(map.get(null));
    }

}
