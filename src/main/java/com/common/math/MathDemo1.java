package com.common.math;

import java.util.Random;

public class MathDemo1 {


    public static void main(String[] args) {

        // Math.random() 返回的值是 double 类型的，取值范围  0 ≤ x < 1 ,注意除 0 异常
        System.out.println(Math.random());

        // 要是想获取整型类型的随机数 直接使用 Random 对象的 nextInt nextLong

        Random random = new Random();
        System.out.println(random.nextInt(100));
    }
}
