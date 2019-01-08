package com.common.ListDemo;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * @author Administrator
 */
public class ArrayListDemo1 {


    public static void main(String[] args) {
        List<String> ls = new LinkedList<>();
        List<String> lss = new LinkedList<>();
        int max = 2584;
        for (int i = 0; i < max; i++) {
            ls.add(String.valueOf(i));
        }
        long start = System.nanoTime();
        for (int i = 0; i < 3; i++) {
            ls.addAll(ls);
        }
        long end = System.nanoTime();
        System.out.println((end - start) / 1000000);
        System.out.println(ls.size());

//        for (int i = 0; i < ls.size(); i++) {
//            System.out.println(ls.get(i));
//        }
/*       // System.out.println(Integer.MAX_VALUE>>1);
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
        System.out.println("==============");*/


//        List<String> list =  null; //new ArrayList<>();
//        System.out.println(list);

    }
}
