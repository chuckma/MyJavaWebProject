package com.common.java8;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Author mcg
 * @Date 2018/2/24 16:26
 **/

public class Java8Tester {


    public static void main(String[] args) {
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");

        List<String> filtered = strings.stream().filter(string -> !string.isEmpty()).collect(Collectors.toList());

        System.out.println(strings);
        System.out.println(filtered);
    }

}
