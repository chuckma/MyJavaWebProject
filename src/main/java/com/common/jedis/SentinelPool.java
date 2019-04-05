package com.common.jedis;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;

/**
 * @Author mcg
 * @Date 2019/4/5 20:22
 **/

public class SentinelPool {

    private static JedisSentinelPool pool;
    private static Set<String> sentinel = new HashSet<>();

    static {
        sentinel.add("47.99.198.77:26379");
        sentinel.add("47.99.198.77:26380");
        sentinel.add("47.99.198.77:26381");
        initPool();
    }

    private static void initPool() {
        pool = new JedisSentinelPool("mymaster",
                sentinel,
                new GenericObjectPoolConfig(),
                3000);
    }

    public static Jedis getJedis() {
        return pool.getResource();
    }

    public static void returnBrokenResource(Jedis jedis) {
        pool.returnBrokenResource(jedis);
    }

    public static void returnResource(Jedis jedis) {
        pool.returnResource(jedis);
    }
}
