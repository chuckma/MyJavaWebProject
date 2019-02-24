package com.common.java8.optional;

import java.util.Optional;

/**
 * @Author mcg
 * @Date 2019/2/24 21:15
 * <p>
 * <p>
 * Optional 新特性测试
 **/

public class OptionalTest {

    public static void main(String[] args) {
        // 下面这行代码会抛出 NPE ，of 方法创建 Optional 类时，不能传入 null
//        Optional<String> someNull = Optional.of(null);

        // 为指定的值创建一个Optional，如果指定的值为 null 返回一个 Optional，不会抛出 NPE
        // ofNullable 类似，唯一就是可以传入 null
        Optional<Integer> optional = Optional.ofNullable(null);
        //
        if (optional.isPresent()) {
            // 判断存在后获取对象值; optional 如果有值就返回，否则抛出 NoSuchElementException
            System.out.println(optional.get());
        }
    }
}
