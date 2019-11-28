package com.common.pojo;

/**
 * @Author mcg
 * @Date 2019/11/28 22:16
 **/

public class Test {

    public static void main(String[] args) {


        Users users = new Users.Builder("lucas", 12)
                .phone("324423424").build();


        System.out.println(users);
    }
}
