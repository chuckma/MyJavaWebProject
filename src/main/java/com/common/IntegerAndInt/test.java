package com.common.IntegerAndInt;

/**
 * @author Administrator
 */
public class test {

    public static void main(String[] args) {
        int a = 2;
        Integer b = 2;
        int c = 128;
        Integer d = 128;
        Integer e = 128;
        Integer f = new Integer(128);

        System.out.println(a == b);
        // 对于两个非new生成的Integer对象,在缓存里的 为 true，在缓存外的为 false , valueOf()
        System.out.println("d = e ? " +(d == e));
        System.out.println("d equals e ? " +(d.equals(e)));

        // 包装类Integer和基本数据类型int比较时，java会自动拆包装为int，
        // 然后进行比较，实际上就变为两个int变量的比较
        System.out.println("c = f ? "+(c == f)); //
        System.out.println("c = d ? "+(c== d));


        Integer i = new Integer(123);
        Integer j = new Integer(123);
        System.out.println("i = j ? "+(i == j));// 内存地址不一样，不可能相等
        System.out.println("i equals j ? "+i.equals(j));


        // String.valueOf(int i) 与 Integer.toString(int i) 没区别 String.valueOf 调用的就是  Integer.toString
        System.out.println(" Integer.MIN_VALUE 通过 Integer.toString 转为 string 类型值为 =" +Integer.toString(Integer.MIN_VALUE));
        System.out.println(" 12312 转为 string 类型值为 =" +Integer.toString(12312));
        System.out.println(" Integer.MIN_VALUE 通过 String.valueOf 转为 string 类型值为 =" +String.valueOf(Integer.MIN_VALUE));
        System.out.println(" Integer.MIN_VALUE 通过 String.valueOf 转为 string 类型值为 =" +String.valueOf(2147483646));

        String s = String.valueOf(Integer.MIN_VALUE);
        if (s instanceof  String){
            System.out.println(s + "是 String 类型");
        }

    }
}
