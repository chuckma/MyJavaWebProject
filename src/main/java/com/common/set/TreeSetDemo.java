package com.common.set;

import java.util.Collections;
import java.util.Set;
import java.util.TreeSet;


public class TreeSetDemo {

    public static void main(String[] args) {
        Set<Person> ts = new TreeSet<>(Collections.<Person>reverseOrder());
        ts.add(new Person("张三", 23));
        ts.add(new Person("李四", 13));
        ts.add(new Person("周七", 15));
        ts.add(new Person("王五", 43));
        ts.add(new Person("赵六", 33));

        for (Person t : ts) {
            System.out.println(t.getAge());
        }
    }

}
