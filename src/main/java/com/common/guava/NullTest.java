package com.common.guava;

import com.google.common.base.Optional;
import org.apache.xmlbeans.SchemaType;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author Administrator
 * <p>
 * <p>
 * Guava 处理 null
 */
public class NullTest {


    public static void main(String[] args) {
        Optional<Integer> possible = Optional.of(5);
        System.out.println(possible.asSet());
        System.out.println(possible.get());

        // guava optional 创建指定应用的 Optional 实例 如果为 null 抛出 NPE
//        Optional<String> optional = Optional.of(null);
//        System.out.println(optional);

        // 创建应用缺失的 Optional 实例
        Optional<String> optional1 = Optional.absent();
        System.out.println(optional1.isPresent());

        // 和 of 相比，可以传入 null ，不会抛出 NPE，如果是null 表示缺失，
        Optional<Object> optional2 =  Optional.fromNullable(null);

        if (optional2.isPresent()) {
            System.out.println(optional2.get());
        } else {
            System.out.println("optional2 是空的，缺失的");
        }

        // optional 包含 null 的情况下返回默认的值
        String object = (String) Optional.fromNullable(null).or("暂无值");
        System.out.println(object);

    }
}
