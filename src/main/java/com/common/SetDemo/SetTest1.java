package com.common.SetDemo;

import java.util.HashSet;
import java.util.Set;

/**
 * @author Administrator
 */
public class SetTest1 {

    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < 10; i++) {
           set.add(i);
        }
        int a = 0;

        System.out.println(set.size());
        System.out.println(set.isEmpty());
        System.out.println(set.contains(3));
        set.remove(1);
        for (Integer integer : set) {
            System.out.println(integer);
        }


    }
}
