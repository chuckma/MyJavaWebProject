package com.common.object;

import com.common.set.Person;

/**
 * @author Administrator
 */
public class ObjectDemo1 {

    public static void main(String[] args) {
        Object obj = null;
        // System.out.println(obj.toString());
        System.out.println(String.valueOf(obj));

        Object o = "";
        System.out.println(" o = "+o);
        test();
        comparePerson();
    }


    private static void test() {
        Person person = new Person("张三", 16);
        Person person1 = new Person("李四", 23);
        System.out.println(person.toString());
        System.out.println(person1.toString());
    }

    private static void comparePerson() {
        Person1 p1 = new Person1("张三", 11);
        Person1 p2 = new Person1("张三", 11);
        System.out.println(p1.equals(p2));
        System.out.println(p1==p2);
        System.out.println(p1.hashCode());
        System.out.println(p2.hashCode());
    }

   /* @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Person1 {
        private String name;
        private Integer age;
    }*/
}

