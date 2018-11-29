package com.common.set;

/**
 * 为什么返回0，只会存一个元素，返回-1会倒序存储，返回1会怎么存就怎么取呢？原因在于TreeSet底层其实是一个二叉树机构，
 * 且每插入一个新元素(第一个除外)都会调用```compareTo()```方法去和上一个插入的元素作比较，并按二叉树的结构进行排列。
 *
 * 1. 如果将```compareTo()```返回值写死为0，元素值每次比较，都认为是相同的元素，
 *    这时就不再向TreeSet中插入除第一个外的新元素。所以TreeSet中就只存在插入的第一个元素。
 *
 * 2. 如果将```compareTo()```返回值写死为1，元素值每次比较，都认为新插入的元素比上一个元素大，
 *    于是二叉树存储时，会存在根的右侧，读取时就是正序排列的。
 *
 * 3. 如果将```compareTo()```返回值写死为-1，元素值每次比较，都认为新插入的元素比上一个元素小，
 *    于是二叉树存储时，会存在根的左侧，读取时就是倒序序排列的。
 */
public class Person implements Comparable<Person> {
    private String name;
    private int age;

    public Person(String name, int age) {
        super();
        this.age=age;
        this.name=name;
    }

    public int compareTo(Person o) {
//        return 0;                //当compareTo方法返回0的时候集合中只有一个元素
//        return 1;                //当compareTo方法返回正数的时候集合会怎么存就怎么取
//        return -1;                //当compareTo方法返回负数的时候集合会倒序存储

        // 23,13,15,43,33 岁的 person 对象 插入 TreeSet
        // 13 - 23 < 0


        int age = this.age - o.age;
        return age == 0 ? this.name.compareTo(o.name) : age;//姓名是比较的次要条件
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}