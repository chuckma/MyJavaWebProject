package com.common.guava;

import java.util.UUID;
import java.util.concurrent.TimeUnit;

public class CacheUtil<K, V> extends BaseGuavaCache<K, V> {


    /*// 缓存自动刷新周期
    private int refreshDuration;
    // 缓存刷新周期时间格式
    private TimeUnit refreshTimeunit;
    // 缓存过期时间（可选择）
    private int expireDuration;
    // 缓存刷新周期时间格式
    private TimeUnit expireTimeunit;
    // 缓存最大容量
    private int maxSize;

    public CacheUtil(int refreshDuration, TimeUnit refreshTimeunit,
                     int expireDuration, TimeUnit expireTimeunit, int maxSize) {
        this.refreshDuration = refreshDuration;
        this.refreshTimeunit = refreshTimeunit;
        this.expireDuration = expireDuration;
        this.expireTimeunit = expireTimeunit;
        this.maxSize = maxSize;
    }*/

    @Override
    public void loadValueWhenStarted() {
        System.out.println("启动时候加载");

    }

    @Override
    protected V getValueWhenExpired(K key) throws Exception {
        return (V) UUID.randomUUID().toString().toUpperCase();
    }

    @Override
    public V getValue(K key) throws Exception {
        return super.getValue(key);
    }

    @Override
    public void setValue(K key, V value) throws Exception {
        super.setValue(key, value);
    }

    public CacheUtil<K, V> setRefreshDuration(int refreshDuration) {
        this.refreshDuration = refreshDuration;
        return this;
    }

    public CacheUtil<K, V> setRefreshTimeUnit(TimeUnit refreshTimeunit) {
        this.refreshTimeunit = refreshTimeunit;
        return this;
    }

    public CacheUtil<K, V> setExpireDuration(int expireDuration) {
        this.expireDuration = expireDuration;
        return this;
    }

    public CacheUtil<K, V> setExpireTimeUnit(TimeUnit expireTimeunit) {
        this.expireTimeunit = expireTimeunit;
        return this;
    }
}
