package com.common.jedis;

import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author mcg
 * @Date 2019/2/26 19:15
 **/

public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.97.177.125", 6380);

//        testKey(jedis);
        System.out.println("所有的key" + jedis.keys("*"));
//        testString(jedis);
        testHash(jedis);
    }

    /**
     *  redis key 操作
     * @param jedis
     */
    private static void testKey(Jedis jedis) {
        System.out.println("是否存在该 key ：" +jedis.exists("12"));
        System.out.println("所有的key "+jedis.keys("*"));
        System.out.println("Goods 开头的 key " + jedis.keys("Good*"));

        // -1 表示永久不过期
        System.out.println("key 12 值的过期时间是 "+jedis.ttl("12"));

        System.out.println("key 12 值的数据类型是 "+jedis.type("12"));
        jedis.close();

    }


    /**
     * 字符串操作
     */
    private static void testString(Jedis jedis) {
        // 设置 key 1 值为 1111 200 秒后过期
        jedis.setex("1", 200, "1111");

        // 只有在 key 不存在时设置 key 的值。
        jedis.setnx("2", "2222");

        System.out.println("key 2 对应的  value ："+jedis.get("2"));


        // 如果 key 已经存在并且是一个字符串， APPEND 命令将 value 追加到 key 原来的值的末尾。
//        jedis.append("2", "333");
//        System.out.println("key 2 append 333 之后的  value ："+jedis.get("2"));

//        jedis.set("3", "3333");

        // 将 key 中储存的数字值增一。
        jedis.incr("3");
        System.out.println("key 3 加1 之后对应的  value ："+jedis.get("3"));

        jedis.decr("3");
        System.out.println("key 3 减1 之后对应的  value ："+jedis.get("3"));

        jedis.incrBy("3", 3);
        System.out.println("key 3 加指定的值 3 之后对应的  value ："+jedis.get("3"));
    }


    /**
     * hash 操作
     * @param jedis
     */
    private static void testHash(Jedis jedis) {

        Map<String, String> map = new HashMap();
        map.put("h1", "v1");
        map.put("h2", "v2");
        map.put("h3", "v3");
        jedis.hmset("kh1", map);
        // hkeys 获取 hashmap 里的所有 key
        System.out.println("key [kh1] 对应的 map 的key 为 "+jedis.hkeys("kh1"));

        // hvals 获取 hashmap 里的所有 val
        System.out.println("key [kh1] 对应的 map 的val 为 "+jedis.hvals("kh1"));

        jedis.hset("kh1", "h4", "v4");
        System.out.println("添加过之后的key ");
        System.out.println("key [kh1] 对应的 map 的key 为 "+jedis.hkeys("kh1"));
        // 删除一个或多个哈希表字段
        jedis.hdel("kh1", "h4");

        System.out.println("hashmap kh1 中字段数量为 "+jedis.hlen("kh1"));

        System.out.println("hashmap kh1 中是否存在 h1 字段 "+jedis.hexists("kh1", "h1"));


    }
}