package com.common.guava;

import java.util.concurrent.TimeUnit;

public class CacheTest {


    public static void main(String[] args) throws Exception {

        // TODO: 2018/11/20 guava 缓存的问题还需要处理
        CacheUtil<String,String > cacheUtil = new CacheUtil<>();
        cacheUtil.setRefreshTimeUnit(TimeUnit.SECONDS);
        cacheUtil.setRefreshDuration(2);    // 异步刷新    10s
//        cacheUtil.setExpireTimeUnit(TimeUnit.SECONDS);
//        cacheUtil.setExpireDuration(3); // 过期时间 60s

        // 缓存一个值
        cacheUtil.setValue("123", "test123123");
        // 打印
        System.out.println(cacheUtil.getValue("123"));
        // 等待 4s
        TimeUnit.MILLISECONDS.sleep(4000);
        // 重新获取，由于还在有效期内，因此和上面设置的值一样
        System.out.println("等待一段时间后获取到的值："+ cacheUtil.getValue("123"));
        // 继续等待 100 ms ,缓存还未失效，刷新后缓存的值都会被新值替换
         TimeUnit.MILLISECONDS.sleep(1000);
        // 此时获取的值就是重新刷新的值
        System.out.println("第 3 次获取" +cacheUtil.getValue("123"));

    }
}
