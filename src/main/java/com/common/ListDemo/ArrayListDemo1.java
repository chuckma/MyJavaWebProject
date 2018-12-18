package com.common.ListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class ArrayListDemo1 {


    public static void main(String[] args) {
       // System.out.println(Integer.MAX_VALUE>>1);
       //  List<String> list = new ArrayList<>();

        List<String > list = new ArrayList<>(4000);
        System.out.println("list 大小："+list.size());
        System.out.println("list 是否为空："+list.isEmpty());



        List<String> list1 = new ArrayList<>();
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        System.out.println("==============");
//        list1.add("1");
        System.out.println(list1.size());
        System.out.println(list1.isEmpty());
        //list1.add(null);
        list1.add("12");
        System.out.println(list1.size());
        System.out.println(!list1.isEmpty());
        System.out.println(!list1.isEmpty()&& list1.size()>0);
        System.out.println("==============");


//        List<String> list =  null; //new ArrayList<>();
//        System.out.println(list);

    }
}
