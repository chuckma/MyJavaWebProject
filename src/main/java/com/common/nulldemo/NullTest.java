package com.common.nulldemo;


import java.util.HashMap;
import java.util.Map;

/**
 *  null 是任何引用类型的默认值 可以说是 所有Object类型的默认值
 *  null 不是基本类型的默认值 如果将 null 赋值给基本类型，编译器就会报错
 */
public class NullTest {


    private static Object obj;
    public static void main(String[] args) {

        System.out.println(obj);

//        int i= null;

        // null 赋值给包装类型，包装类在拆箱成基本类型的时候就会报 NPE
        Integer integer = null;
        //int a = integer;

//        System.out.println(a);
//        test1();
        System.out.println(null == null);
        test2();
        test3();

    }

    private static void test1(){
        Map numberAndCount = new HashMap<>();
        int[] numbers = {3, 5, 7,9, 11, 13, 17, 19, 2, 3, 5, 33, 12, 5};

        for(int i : numbers){
            int count = (int) numberAndCount.get(i);
            numberAndCount.put(i, count++); // NullPointerException here
        }
    }


    // 如果使用了带有null值的引用类型变量，instanceof操作将会返回false
    private static void test2() {

        Integer iAmNull = null;
        if(iAmNull instanceof Integer){
            System.out.println("iAmNull is instance of Integer");

        }else{
            System.out.println("iAmNull is NOT an instance of Integer");
        }
    }

    // null 的变量不能调用非静态方法，但是可以调用静态方法
    private static void test3() {
        NullTest myObject = null;
        myObject.iAmStaticMethod();
        myObject.iAmNonStaticMethod();
    }


    private static void iAmStaticMethod(){
        System.out.println("I am static method, can be called by null reference");
    }

    private void iAmNonStaticMethod(){
        System.out.println("I am NON static method, don't date to call me by null");
    }
}
