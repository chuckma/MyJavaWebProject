package com.common.ListDemo;

import java.util.ArrayList;
import java.util.List;

public class List1 {


    public static void main(String[] args) {
//        List list = new ArrayList();
//        list.add(1);
//        list.add("123");
//        System.out.println(list);
//        List<Integer> list1 = new ArrayList<>();
//        list1.add(12);
//        System.out.println(list1);

        test();


    }

    public static <T> void show1(List<T> list){
        for (Object object : list) {
            System.out.println(object.toString());
        }
    }


    public static void show2(List<?> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    // List<? extends Teacher>
    // list这种写法表示可以接收Teacher和它的子类数据类型的list集合
    public static void show3(List<? extends Teacher> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }


    public static void show4(List<? extends Student> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    // List<? super Student>
    // 这种写法表示只接收指定的数据类型及它的父类类型
    public static void show5(List<? super Student> list) {
        for (Object object : list) {
            System.out.println(object);
        }
    }

    public static void test(){
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("zhangsan",18,0));
        list1.add(new Student("lisi",28,0));
        list1.add(new Student("wangwu",24,1));
        //这里如果add(new Teacher(...));就会报错，因为我们已经给List指定了数据类型为Student
        show1(list1);

        System.out.println("************分割线**************");

        //这里我们并没有给List指定具体的数据类型，可以存放多种类型数据
        List list2 = new ArrayList<>();
        list2.add(new Student("zhaoliu",22,1));
        list2.add(new Teacher("sunba",30,0));
        show2(list2);

        // 正常输出
        show3(list2);


        List<Teacher> list3 = new ArrayList<>();
        list3.add(new Teacher("zhaoliu",22,1));
        list3.add(new Teacher("sunba",30,0));
        show3(list3);
//        show4(list3); 错误



        List list4 = new ArrayList<>();
        list4.add(new Student("sunba",30,0));
        list4.add(new Teacher("zhaoliu",22,1));
        show5(list4);

        // 如果传递的是 Student 的子类会如何？
    }


}
