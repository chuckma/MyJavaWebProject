package com.set;

import java.util.Set;
import java.util.TreeSet;

public class TreeSetDemo1 {


    public static void main(String[] args) {

        Set<String> treeSet = new TreeSet<>();

        treeSet.add("dfa f");
        treeSet.add("dfa f1");
        treeSet.add("dfa f2");
        treeSet.add("dfa f3");


        // TreeSet 里的元素都需要实现 Comparable 这个借口，或者自定义一个比较器
        // 由于String类实现了Comparable接口，
        // 它的compareTo方法是按照字典顺序来对字符串进行排序，所以结果如下：

        for (String s : treeSet) {
            System.out.println(s);
        }

    }
}
