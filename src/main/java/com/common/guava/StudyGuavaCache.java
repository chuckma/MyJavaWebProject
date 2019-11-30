package com.common.guava;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.google.common.util.concurrent.ListenableFuture;

import java.util.UUID;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @Author mcg
 * @Date 2019/11/30 20:39
 * <p>
 * <p>
 * Guava cache
 **/

public class StudyGuavaCache {

    public static void main(String[] args) throws ExecutionException, InterruptedException {


        cacheBuilder();

//        setMaxCache();

//        testExpireAfterWrite();
//        testExpireAfterAccess();
    }

    private static String getValueWhenExpired() {
        return UUID.randomUUID().toString().toUpperCase();
    }
    /**
     * 构建一个 CacheBuilder
     */
    public static void cacheBuilder() throws ExecutionException, InterruptedException {

        LoadingCache<String, String> loadingCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(5, TimeUnit.SECONDS)
                .build(new CacheLoader<String, String>() {
                    @Override
                    public String load(String key) throws Exception {
                        return "null";
                    }

                    @Override
                    public ListenableFuture<String> reload(String key, String oldValue) throws Exception {
                        return super.reload(key, getValueWhenExpired());
                    }
                });

        loadingCache.put("key1", "121313");

        int time = 1;
        while (true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + loadingCache.getIfPresent("key1"));
            Thread.sleep(1000);
        }


    }

    /**
     * 设置最大的缓存
     * Guava Cache可以在构建缓存对象时指定缓存所能够存储的最大记录数量。
     * 当Cache中的记录数量达到最大值后再调用put方法向其中添加对象，
     * Guava会先从当前缓存的对象记录中选择一条删除掉，腾出空间后再将新的对象存储到Cache中
     * <p>
     * 执行结果
     * 第一个值：null
     * 第二个值：value2
     * 第三个值：value3
     */
    public static void setMaxCache() {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .build();
        cache.put("key1", "value1");
        cache.put("key2", "value2");
        cache.put("key3", "value3");
        System.out.println("第一个值：" + cache.getIfPresent("key1"));
        System.out.println("第二个值：" + cache.getIfPresent("key2"));
        System.out.println("第三个值：" + cache.getIfPresent("key3"));
    }


    /**
     * 设置过期时间
     * <p>
     * 在构建Cache对象时，可以通过 CacheBuilder 类的 expireAfterAccess 和 expireAfterWrite 两个方法为缓存中的对象指定过期时间，
     * 过期的对象将会被缓存自动删除。
     * 其中，expireAfterWrite方法指定对象被写入到缓存后多久过期，expireAfterAccess指定对象多久没有被访问后过期
     * <p>
     * 程序执行结果
     * <p>
     * 第1次取到key1的值为：value1
     * 第2次取到key1的值为：value1
     * 第3次取到key1的值为：value1
     * 第4次取到key1的值为：null
     * 第5次取到key1的值为：null
     * 第6次取到key1的值为：null
     * 第7次取到key1的值为：null
     * 第8次取到key1的值为：null
     */

    public static void testExpireAfterWrite() throws InterruptedException {
        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterWrite(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            System.out.println("第" + time++ + "次取到key1的值为：" + cache.getIfPresent("key1"));
            Thread.sleep(1000);
        }
    }


    public static void testExpireAfterAccess() throws InterruptedException {

        Cache<String, String> cache = CacheBuilder.newBuilder()
                .maximumSize(2)
                .expireAfterAccess(3, TimeUnit.SECONDS)
                .build();
        cache.put("key1", "value1");
        int time = 1;
        while (true) {
            Thread.sleep(time * 1000);
            System.out.println("睡眠" + time++ + "秒后取到key1的值为：" + cache.getIfPresent("key1"));
        }
    }
}
