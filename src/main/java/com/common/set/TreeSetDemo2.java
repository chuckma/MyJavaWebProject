package com.common.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo2 {


    public static void main(String[] args) {

        Set<String> ts = new TreeSet<>(new CompareByLen());

        ts.add("ewqe");
        ts.add("1");
        ts.add("21313123");
        ts.add("sd");

        // TreeSet 默认按照升序输出

        for (String t : ts) {
            System.out.println(t);
        }
    }
}
