package com.common.collection;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @Author mcg
 * @Date 2019/2/24 15:19
 **/

public class demo1 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        System.out.println(CollectionUtils.isEmpty(list));

        List<String> list1 = new ArrayList<>();
        list1.add("1");

        System.out.println(CollectionUtils.isEmpty(list1));

        List<String> list2 = null;
        System.out.println(CollectionUtils.isEmpty(list2));

        System.out.println("list1 是 list 的子集："+ CollectionUtils.isSubCollection(list1, list));

        // 求 list 和 list1 的并集
        System.out.println("list 和 list1 的并集是："+CollectionUtils.union(list, list1));
        // 求 list 和 list1 的交集
        System.out.println("list 和 list1 的交集是： "+CollectionUtils.intersection(list, list1));

        System.out.println("-------------------");
        test1();
    }


    private static void test1() {

        /**
         * singleton ,singletonList ,singletonMap 返回的容器都是不可修改的
         * 如果调用修改接口 会抛出 UnsupportedOperationException
         */
        List<Integer> list = Collections.singletonList(1);
        System.out.println(list.contains(1));

        // 下面两行会抛出异常
//        list.add(3);
//        list.clear();
        System.out.println(list);

        /**
         * emptyList，emptySet emptyMap 返回的集合都是不可修改的，
         * 如果调用修改接口，也会抛出 UnsupportedOperationException
         */
        List<Object> objects = Collections.emptyList();
//        objects.add(2);
        System.out.println(objects);
    }

}
