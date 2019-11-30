package com.common.guavademo;

import com.google.common.base.Joiner;
import com.google.common.base.Splitter;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * @Author mcg
 * @Date 2019/11/29 21:30
 * <p>
 * Joiner 方法测试
 **/

public class JoinerAndSplitterTest {


    private static final List<String> list1 = Arrays.asList
            ("google","guava","java","scala","kafka");

    private static final List<String> list2 = Arrays.asList
            ("google","guava","java",null,"scala","kafka");

    public static void main(String[] args) throws IOException {


        testJoiner1();
//        testGuavaSplitterAllTypeMethod();
    }


    public static void testJoiner1() throws IOException {

        String string = "a,bb,ccc,dddd";
        String[] strings = {"a", "b", "c"};


        // 数组需要进行转换成list集合比较安全，当然也可以直接join
        String newStrings = Joiner.on("-").join(Arrays.asList(strings));
        System.out.println(newStrings);



        List<Integer> list1 = Lists.newArrayList();
        for (int i = 0; i < 10; i++) {
            list1.add(i);
        }
        list1.add(null);
        System.out.println(list1);
        // skipNulls() 跳过 null
        System.out.println(Joiner.on("-").skipNulls().join(list1));


        // useForNull 替换 null
        System.out.println(Joiner.on("-").useForNull("我原来的值是null，不过被替换成现在的了").join(list1));


        System.out.println();
        ImmutableMap<String, String> of = ImmutableMap.of("id", "123", "name", "green");

        // withKeyValueSeparator 可以将一个 k v 结果的数据通过给定的符号链接起来
        System.out.println(Joiner.on(";").withKeyValueSeparator("=").join(of));



        //4.把集合变成一个stringBuilder 或者stringBuffer
        StringBuilder builder = Joiner.on("#").useForNull("DEFAULT").appendTo(new StringBuilder(), list2);
        StringBuffer buffer = Joiner.on("#").useForNull("DEFAULT").appendTo(new StringBuffer(), list2);
        System.out.println("拼接成的 builder是："+builder);
        System.out.println("拼接成的buffer是："+buffer);


    }

    public static void testGuavaSplitterAllTypeMethod() {
        String string = ",,2,apple,xiaomi,,,MeiZu,Mei Zu,,vivo-nex,,1231,";
        String string2 = "1-2-3-4-5-6";
        // 去掉无用的值，清除一些没有用的值,这个方法真的是太实用了，对于一些字符串的清洗整理很有用
        // omitEmptyStrings 去除结果中的空字符串
        // trimResults方法会去除元素中的左右空字符串，内容中间的空字符串不会去除  例子中 Mei Zu 之间的空格是没法去除的。
        Iterable<String> usefulString = Splitter.on(",").omitEmptyStrings().trimResults().split(string);
        usefulString.forEach(System.out::println);// apple xiaomi honour vivo-nex

        //
        System.out.println(usefulString);

        // fixedLength(3)：表示三个字符三个字符切断促成一个元素。
        Iterable<String> newString2 = Splitter.fixedLength(3).split(string2);
        System.out.println(newString2);// [1-2, -3]
        newString2.forEach(System.out::println);// 1-2 -3- 4-5 -6

        // 遍历字符串的每个字符： 如果含有匹配的字段，则剔除匹配的字段再输出字符；如果没匹配上，则输出元字符。
        Iterable<String> patternString = Splitter.onPattern("-").split(string2);
        System.out.println(patternString);// [1, 2, 3, 4, 5, 6]

        String string3 = "123456789";
        Iterable<String> result = Splitter.onPattern(",").split(string3);
        System.out.println(result);


        String string4 = "123 ,12,,affa ";
        System.out.println(Splitter.on(",").omitEmptyStrings().trimResults().split(string4));

        // splitToList 将处理后的结果转为一个 list，而 split 是返回一个 字符串迭代器
        List<String> list = Splitter.on(",").omitEmptyStrings().trimResults().splitToList(string4);
        System.out.println(list);


        // limit方法，最多分割limit个子字符串。 它只处理从头开始的 limit 个 子字符串，后面的就不管了，
        // 给人一种干活干了一半儿就忍下走了的感觉
        // 至于干多少货取决于你对 limit 的控制，
        List<String> list1 = Splitter.on(",").omitEmptyStrings().trimResults().limit(2).splitToList(string4);
        System.out.println(list1);


        // String 转为 map
        String str = "xiaoming=11,xiaohong=23";
        Map<String,String> map = Splitter.on(",").withKeyValueSeparator("=").split(str);
        System.out.println("String 转 map"+map);



        // guava 支持多个字符串的分割，或者特定正则的分割
        String input = "aa.。.dd,,ff,,.,.,../";
        List<String> result1 = Splitter.onPattern("[.|,|/|。]").omitEmptyStrings().splitToList(input);

        System.out.println("多个字符串分割"+result1);

    }
}
