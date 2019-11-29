package com.common.guavademo;

import com.google.common.base.Joiner;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author mcg
 * @Date 2019/11/29 19:49
 * <p>
 * <p>
 * guava list 测试
 **/

public class GuavaListTest {


    public static void main(String[] args) {

        listTest1();
    }


    // 将集合转换为特定规则的字符串
    public static void listTest1() {

        //use java
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");
        String str = "";
        for(int i=0; i<list.size(); i++){
            str = str + "-" +list.get(i);
        }
        System.out.println(str);
        //str 为-aa-bb-cc

        //use guava
        List<String> list1 = new ArrayList<>();
        list1.add("aa");
        list1.add("bb");
        list1.add("cc");


        String result = Joiner.on(",").join(list);
        System.out.println(result);
        //result为  aa-bb-cc
    }


    public static void listTest2() {

    }
}
