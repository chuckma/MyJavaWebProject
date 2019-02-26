package com.common.java8.lambda;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

/**
 * @author Administrator
 * <p>
 * <p>
 * Lambda 测试
 * Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 * <p>
 * Lambda 重要特征
 * 1. 可选的参数类型 (不需要声明参数类型，编译器可以统一识别参数值)
 * 2. 可选的参数圆括号 (一个参数无需定义圆括号，但是多个参数需要定义圆括号)
 * 3. 可选的大括号 (如果主题包含了一个语句，就不需要大括号)
 * 4. 可选的返回关键字 ( 如果主题只有一个表达式返回值则编译器会自动返回值，
 * 大括号需要指明表达式返回了一个数值)
 * <p>
 * <p>
 * <p>
 * 简单例子
 * <p>
 * // 1. 不需要参数,返回值为 5
 * () -> 5
 * <p>
 * // 2. 接收一个参数(数字类型),返回其2倍的值
 * x -> 2 * x
 * <p>
 * // 3. 接受2个参数(数字),并返回他们的差值
 * (x, y) -> x – y
 * <p>
 * // 4. 接收2个int型整数,返回他们的和
 * (int x, int y) -> x + y
 * <p>
 * // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
 * (String s) -> System.out.print(s)
 */
public class LambdaTest {


    public static void main(String[] args) {
        // 语法格式一：无参，无返回值，Lambda体只需要一条语句。
        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();
        // 语法格式二：Lambda需要一个参数
        Consumer<String> con = (x) -> System.out.println(x);

        // 语法格式三：Lambda只需要一个参数时，参数的小括号可以省略
        Consumer<String> con1 = x -> System.out.println(x);


//        testForEach();
//        testMap();
        testReduce();
        testFilter();
        System.out.println("对列表的每个元素使用 函数");
        testUseFunctions();
        System.out.println("使用distinct进行去重");
        testDistinct();
        System.out.println("获取数字的个数、最小值、最大值、总和以及平均值");
        testCalculate();
    }

    private static void testForEach() {
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        // 直接取值
        list.forEach(System.out::print);
        // 遍历取值
        list.forEach(l -> System.out.println(l));


    }

    private static void testMap() {
        // 可改变对象
        System.out.println("可改变对象");
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.stream().map((i) -> i * 3).forEach(System.out::println);

        // 不可改变原有对象
        System.out.println("不可改变原有对象");
        list1.forEach(i -> i = i * 3);
        list1.forEach(System.out::println);
    }

    private static void testReduce() {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        Integer integer = list.stream().map((i) -> i = i * 3)
                .reduce((sum, count) -> sum += count).get();

        System.out.println(integer);
    }

    /**
     * 过滤 筛选
     */
    private static void testFilter() {
        List<String> strList = Arrays.asList("abc", "eqwr", "bcd", "qb", "ehdc", "jk");
        List<String> filtered = strList.stream().filter(x -> x.length() > 2).collect(Collectors.toList());
        System.out.printf("Original List : %s, filtered list : %s %n", strList, filtered);
    }


    /**
     *  对列表的每个元素使用 函数
     */
    private static void testUseFunctions() {
        List<String> strList = Arrays.asList("abc", "eqwr", "bcd", "qb" , "ehdc", "jk");
        String collect = strList.stream().map(x -> x.toUpperCase()).collect(Collectors.joining(", "));
        System.out.printf("filtered list : %s %n",  collect);
    }

    /**
     * 使用distinct进行去重
     */
    private static void testDistinct() {
        List<Integer> numbers = Arrays.asList(9, 10, 3, 4, 7, 3, 4);
        List<Integer> distinct = numbers.stream().map( i -> i*i).distinct().collect(Collectors.toList());
        System.out.printf("Original List : %s,  Square Without duplicates : %s %n", numbers, distinct);
    }


    /**
     * IntStream LongStream DoubleStream 等流的类中，有一个非常有用的方法 summaryStatistics
     * 可以返回 IntSummaryStatistics、LongSummaryStatistics 或者 DoubleSummaryStatistics，描述流中元素的各种摘要数据
     */
    private static void testCalculate() {
        //获取数字的个数、最小值、最大值、总和以及平均值
        List<Integer> primes = Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29);
        IntSummaryStatistics stats = primes.stream().mapToInt((x) -> x).summaryStatistics();
        System.out.println("Highest prime number in List : " + stats.getMax());
        System.out.println("Lowest prime number in List : " + stats.getMin());
        System.out.println("Sum of all prime numbers : " + stats.getSum());
        System.out.println("Average of all prime numbers : " + stats.getAverage());
    }
}
