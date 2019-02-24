package com.common.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author mcg
 * @Date 2018/2/24 16:26
 **/

public class Java8Tester {


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println(strings);
        System.out.println(filtered);

        // 截取前三个元素
        System.out.println(filtered.stream().limit(3).collect(Collectors.toList()));

        // 排序
        System.out.println(filtered.stream().sorted().collect(Collectors.toList()));

        List<String> list = new ArrayList<>();
        // 对 list 进行 forEach 遍历
        list.addAll(filtered);

        System.out.println(list);

        System.out.println("strings 中空的字符串个数是：" + strings.stream().filter(string -> string.isEmpty()).count());

        // 并行处理
        int count = (int) strings.parallelStream().filter(string -> string.isEmpty()).count();
        System.out.println(count);


        // Collectors 类实现了很多归约操作，例如将流转换成集合和聚合元素。Collectors 可用于返回列表或字符串：
        String mergedString = strings.stream().filter(string -> !string.isEmpty())
                .collect(Collectors.joining(", "));
        System.out.println("合并字符串: " + mergedString);


    }

}
