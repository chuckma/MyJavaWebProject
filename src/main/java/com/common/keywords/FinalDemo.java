package com.common.keywords;

public class FinalDemo {
    public static void main(String[] args) {
        final int a = 13;
        // final 是不能被修改值的，当如同下面写的时候，编译器就会提示你 make "a" not final
//        a = 14;


        /*
        * final 修饰的变量 都被jvm 放在了 常量池
        *
        * final 修饰的方法无法被子类重写
        *
        * final 修饰的类无法被继承
        * */
    }
}
