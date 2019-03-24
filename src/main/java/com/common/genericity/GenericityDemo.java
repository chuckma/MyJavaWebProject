package com.common.genericity;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @Author mcg
 * @Date 2019/3/23 17:34
 **/

@Slf4j
public class GenericityDemo {


    public static void main(String[] args) {

        badCase1();
    }

    private static void badCase1() {

        List arrayList = new ArrayList();
        arrayList.add("aaaa");
        arrayList.add(100);

//        for (int i = 0; i < arrayList.size(); i++) {
//            String item = (String) arrayList.get(i);
//            log.info("泛型测试", "item = " + item);
//        }

        Set<User> exa = new HashSet();
        exa.add(new User());
    }

    static class User{

    }
}
