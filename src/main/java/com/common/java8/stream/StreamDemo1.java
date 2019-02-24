package com.common.java8.stream;

import org.openxmlformats.schemas.drawingml.x2006.spreadsheetDrawing.STEditAs;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author mcg
 * @Date 2019/2/24 20:15
 **/

public class StreamDemo1 {


    public static void main(String[] args) {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4, 5);
        List<Integer> squareNums = nums.stream().map(n -> n * n).collect(Collectors.toList());

        // findFirst 和 findAny 都是值获取一个 返回类型为 Optional 对象
        // 获取第一个
        System.out.println(nums.stream().findFirst().get());
        // 获取任何一个，在并行操作的情况下， 返回线程最先处理完毕的那个，
        // 在不考虑顺序的情况下，findAny 比 findFirst要快
        System.out.println(nums.stream().findAny().get());


        // reduce 主要将 Stream 元素组合起来

        // 整数相加,无起始值，由于可能没有足够的元素，返回的是 Optional 对象
        System.out.println(Stream.of(1, 2, 3, 4, 5).reduce( Integer::sum).get());

        // 字符串拼接
        String concat = Stream.of("A", "B", "C", "D").reduce("", String::concat);
        System.out.println(concat);

        // 求最小值
        double minValue = Stream.of(-1.5, 1.0, -3.0, -2.0).reduce(Double.MAX_VALUE, Double::min);
        System.out.println("最小值"+minValue);


        // limit 是返回前 n 个元素
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).limit(3).collect(Collectors.toList()));
        // 扔掉前 n 个元素
        System.out.println(Stream.of(1, 2, 3, 4, 5, 6, 7, 8, 9).skip(3).collect(Collectors.toList()));


    }
}
