package com.common.jedis;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisSentinelPool;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * @Author mcg
 * @Date 2019/4/4 22:19
 **/
@Slf4j
public class JedisSentinelDemo {

    public static void main(String[] args) {

        try {
            for (int i = 0; i < 50; i++) {
//                log.info("key {}, value {}",i,jedis.get(String.valueOf(i)));
//                JedisSentinelUtil.set(String.valueOf(i),UUID.randomUUID().toString());
            }

            System.out.println(JedisSentinelUtil.getDbSize());
//            System.out.println(JedisSentinelUtil.setNx("66","8888"));
            System.out.println(JedisSentinelUtil.get("1"));
        } catch (Exception e) {
            log.error("获取 jedis 异常", e);
        }

     }

}
