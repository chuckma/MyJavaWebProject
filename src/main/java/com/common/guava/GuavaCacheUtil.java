package com.common.guava;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

/**
 * Created by mcg on 2017/4/24.
 */
public class GuavaCacheUtil {

    private static Logger logger = LoggerFactory.getLogger(GuavaCacheUtil.class);

    public static final String TOKEN_PREFIX = "token_";


    private static LoadingCache<String, String> localcache = CacheBuilder.newBuilder().initialCapacity(1000).maximumSize(10000).expireAfterAccess(2, TimeUnit.HOURS)
            .build(new CacheLoader<String, String>() {
                //默认的数据加载实现,当调用get取值的时候,如果key没有对应的值,就调用这个方法进行加载.
                @Override
                public String load(String s) throws Exception {
                    return "null";
                }
            });


    public static void setKey(String key,String value){
        localcache.put(key,value);
    }

    public static String getKey(String key){
        String value = null;
        try {
            value = localcache.get(key);
            if ("null".equals(value)){
                return null;
            }
            return value;
        }catch (Exception e){
            logger.error("localCache get error",e);
        }

        return null;
    }
    
    
    public static void main(String[] args) {
    	String str = "test";
//    	GuavaCacheUtil.setKey(GuavaCacheUtil.TOKEN_PREFIX+str,"test data12313123123");
    	String value = GuavaCacheUtil.getKey(GuavaCacheUtil.TOKEN_PREFIX+str);
    	System.out.print(value);
    }
}
