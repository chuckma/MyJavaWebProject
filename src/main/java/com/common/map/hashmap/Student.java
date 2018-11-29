package com.common.map.hashmap;

public class Student {

    private String name;
    private String sex;
    private String phone;
    private int age;

    public Student() {
    }

    public Student(String name, String sex, String phone, int age) {
        this.name = name;
        this.sex = sex;
        this.phone = phone;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", phone='" + phone + '\'' +
                ", age=" + age +
                '}';
    }
}
