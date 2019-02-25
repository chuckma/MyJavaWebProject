package com.common.java8.optional;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

        // 创建一个空对象
        Optional<String> optStr = Optional.empty();
        System.out.println(optStr.isPresent());

        // user 测试
        testUser();

    }

    private static void testUser() {

        User user = null;
        User user1 = new User(1L, "张三", 23, Optional.of(1888L), Optional.of("xx.com"));
        // user 为空的时候返回 no name，不为空的时候返回 name
        System.out.println(Optional.ofNullable(user).map(User::getName).orElse("no name"));
        System.out.println(Optional.ofNullable(user1).map(User::getName).orElse("no name"));
    }

    /**
     * 手机和邮箱不是每个人必须有的，所以在此用Optional 定义
     */
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class User{
        private Long id;
        private String name;
        private Integer age;
        private Optional<Long> phone;
        private Optional<String> email;
    }



}
