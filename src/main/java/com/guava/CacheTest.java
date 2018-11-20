package com.guava;

import org.omg.CORBA.TIMEOUT;

import java.util.concurrent.TimeUnit;

public class CacheTest {


    public static void main(String[] args) throws Exception {

        // TODO: 2018/11/20 guava 缓存的问题还需要处理
        CacheUtil<String,String > cacheUtil = new CacheUtil<>();
        cacheUtil.setRefreshTimeUnit(TimeUnit.SECONDS);
        cacheUtil.setRefreshDuration(2);    // 异步刷新 2s
        cacheUtil.setExpireTimeUnit(TimeUnit.SECONDS);
        cacheUtil.setExpireDuration(5); // 过期时间 5s

        // 缓存一个值
        cacheUtil.setValue("123", "test123123");
        // 打印
        System.out.println(cacheUtil.getValue("123"));
        // 等待 3s
        TimeUnit.MILLISECONDS.sleep(4000);
        // 重新获取，由于还在有效期内，因此和上面设置的值一样
        System.out.println(cacheUtil.getValue("123"));
        // 继续等待 100 ms 此时上面设置的缓存值已经超过有效期，已经失效
        TimeUnit.MILLISECONDS.sleep(100);
        // 此时获取的值就是重新刷新的值
        System.out.println(cacheUtil.getValue("123"));

    }
}
