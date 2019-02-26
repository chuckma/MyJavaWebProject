package com.common.jedis;

import redis.clients.jedis.Jedis;

/**
 * @Author mcg
 * @Date 2019/2/26 19:15
 **/

public class JedisTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("47.97.177.125", 6380);
        jedis.set("12", "21");
        System.out.println(jedis.get("13"));
        jedis.close();
    }
}
