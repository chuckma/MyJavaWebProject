package com.common.guavademo;

import com.google.common.collect.*;
import com.google.common.net.InetAddresses;

import java.util.HashMap;
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

//        maptest1();

        // 不可变 map 测试
//        whenCreatingImmutableMap_thenCorrect();

        // 双向映射 BiMap 测试
//        whenCreateBiMap_thenCreated();

        whenCreatingTable_thenCorrect();
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


    /**
     * 不可变对象有很多的优点。例如：
     * 1. 当对象被不可信的库调用时，不可变形式是安全的；
     * 2. 不可变对象被多个线程调用时，不存在竞太条件问题
     * 3. 不可变结合不需要考虑变化，因此可以节省时间和空间。所有不可变的集合比
     *    它们的可变形式有更好的内存利用率
     * 4. 不可变对象因为固定不变，可以作为常量安全地使用。
     *
     * 特别注意，Guava 不可变集合的实现都不接受都不接受 null 值
     */
    public static void whenCreatingImmutableMap_thenCorrect() {

        // ImmutableMap 不可变 map，中途不可变，多线程操作下是安全的。
        // 不可变集合的 map 创建方式1 通过 Builder
        Map<String, Integer> salary = ImmutableMap.<String, Integer> builder()
                .put("John", 1000)
                .put("Jane", 1500)
                .put("Adam", 2000)
                .put("Tom", 2000)
                //.put(null,1231)
                //.put(null,null)
                .build();

        System.out.println(salary);



        // 创建方式 2 通过 of 这个静态方法创建
        ImmutableMap<String, Integer> map1 = ImmutableMap.of("s1", 1, "s2", 2,
                "s3", 3, "s4", 4);


        HashMap<String , Object> map2 = Maps.newHashMap();
        for (int i = 0; i < 5; i++) {
            map2.put(String.valueOf(i), i);
        }

        // 创建方式 3
        ImmutableMap<String, Object> copyOfMap2 = ImmutableMap.copyOf(map2);
        System.out.println(copyOfMap2);

    }


    /**
     * 演示guava 双向映射结构 BiMap
     */
    public static void whenCreateBiMap_thenCreated() {
        BiMap<String, Object> biMap = HashBiMap.create();

        biMap.put("First", 1);
        biMap.put("Second", 2);
        biMap.put("Third", 3);

        // BiMap 是双向映射的，但是要保证键和值唯一,所有的k and v 都是唯一的

//        biMap.put("First1", 4);
//        biMap.put("First", 3);
//        biMap.put("First12", 1);
//        biMap.put("Second", 22);
        biMap.inverse().put(3, "Third");
//        biMap.inverse().put(4, "Third");
        System.out.println(biMap);
        System.out.println(biMap.get("Second"));
        System.out.println(biMap.inverse().get(22));
    }


    /**
     * 当需要多余一个键索引值时，需要Table。下面示例中，我们使用Table存储城市之间距离：
     */
    public static void  whenCreatingTable_thenCorrect(){


        Table<String,String,Integer> distance = HashBasedTable.create();
        distance.put("London", "Paris", 340);
        distance.put("New York", "Los Angeles", 3940);
        distance.put("London", "New York", 5576);
        distance.put("London", "New York", 1200000);
        System.out.println(distance);

        System.out.println("双索引映射 London 距离 Paris "+distance.get("London", "Paris").intValue());


    }
}
