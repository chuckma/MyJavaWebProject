package com.common.guavademo;


import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

/**
 * @Author mcg
 * @Date 2019/11/29 19:55
 **/

public class GuavaSetTest {


    public static void main(String[] args) {
        setTest1();
    }


    public static void setTest1() {

        Multiset<String> set = HashMultiset.create();
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("1");
        set.add("2");
        set.add("3");

        System.out.println(set);
        // Multiset count 统计相同元素的个数
        System.out.println(set.count("1"));

        // 移除其中一个元素，如果是被移除的元素有多个，则只移除一个
        set.remove("1");
        set.remove("2");
        System.out.println(set.entrySet().size());

        // Multiset elementSet 返回去重后的元素
        System.out.println(set.elementSet());

        for (String s : set) {
//            System.out.println(s);
        }
    }
}
