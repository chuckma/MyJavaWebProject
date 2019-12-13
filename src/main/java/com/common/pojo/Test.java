package com.common.pojo;

import java.util.*;

/**
 * @Author mcg
 * @Date 2019/11/28 22:16
 **/

public class Test {

    private static String a = "123";
    private final String b = "123";
    private static final String c = "123";

    public static void main(String[] args) {


        Users users = new Users.Builder("lucas", 12)
                .phone("324423424").sex(1).build();

        Users users1 = new Users.Builder("shuke", 13).sex(0).build();

        Set<Users> set = new HashSet<>();
        set.add(users);
        set.add(users1);

        List<Users> list = new ArrayList<>();
        list.add(users);
        list.add(users1);

        Collections.sort(list);
        System.out.println(list);

//        System.out.println(users);
    }
}
