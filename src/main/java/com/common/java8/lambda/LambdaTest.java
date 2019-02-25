package com.common.java8.lambda;

import java.util.function.Consumer;

/**
 * @author Administrator
 *
 *
 *  Lambda 测试
 *  Lambda 允许把函数作为一个方法的参数（函数作为参数传递进方法中）。
 *
 *  Lambda 重要特征
 *  1. 可选的参数类型 (不需要声明参数类型，编译器可以统一识别参数值)
 *  2. 可选的参数圆括号 (一个参数无需定义圆括号，但是多个参数需要定义圆括号)
 *  3. 可选的大括号 (如果主题包含了一个语句，就不需要大括号)
 *  4. 可选的返回关键字 ( 如果主题只有一个表达式返回值则编译器会自动返回值，
 *      大括号需要指明表达式返回了一个数值)
 *
 *
 *
 *   简单例子
 *
 *  // 1. 不需要参数,返回值为 5
 *   () -> 5
 *
 *   // 2. 接收一个参数(数字类型),返回其2倍的值
 *   x -> 2 * x
 *
 *   // 3. 接受2个参数(数字),并返回他们的差值
 *   (x, y) -> x – y
 *
 *   // 4. 接收2个int型整数,返回他们的和
 *   (int x, int y) -> x + y
 *
 *   // 5. 接受一个 string 对象,并在控制台打印,不返回任何值(看起来像是返回void)
    (String s) -> System.out.print(s)
 *
 */
public class LambdaTest {


    public static void main(String[] args) {
        // 语法格式一：无参，无返回值，Lambda体只需要一条语句。
        Runnable r = () -> System.out.println("Hello Lambda!");
        r.run();
        // 语法格式二：Lambda需要一个参数
        Consumer<String> con = (x) -> System.out.println(x);

        // 语法格式三：Lambda只需要一个参数时，参数的小括号可以省略
        Consumer<String> con1 = x -> System.out.println(x);

    }
}
