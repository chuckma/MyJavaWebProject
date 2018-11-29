package com.common.type;

public class StringDemo {
    public static void main(String[] args) {

        String str = "12313.22";
        double v = Double.parseDouble(str);

        System.out.println(v);


        // String 转 int
        String s1 = "123";
        int i = Integer.parseInt(s1);
        System.out.println(i);

        String s2 = "0";
        String s3 = "0.11";
        String s4 = "1.0";
        String s5 = "1111111111";
        String s6 = "2147483647";
        boolean b1 = canParseInt(str);
        boolean b2 = canParseInt(s2);
        boolean b3 = canParseInt(s3);
        boolean b4 = canParseInt(s4);
        boolean b5 = canParseInt(s5);

        System.out.println("12313.22 是否可以转成 int "+b1);
        System.out.println("0 是否可以转成 int "+b2);
        System.out.println("0.11 是否可以转成 int "+b3);
        System.out.println("1.0 是否可以转成int "+b4);
        // 2147483647 超过最大的值得时候并不能转换为 int
        System.out.println("11111111111111111111111 是否可以转成int "+b5);

        int i1 = Integer.parseInt(s6);
        System.out.println(i1);


    }


    /**
     * 该方法是有问题的，它只考虑了 String 内容是否为数字，没有考虑 int 的范围
     * @param str
     * @return
     */
    public static boolean canParseInt(String str){
        if(str == null){ //验证是否为空
            return false;

        }
        //使用正则表达式判断该字符串是否为数字，
        // 第一个\是转义符，\d+表示匹配1个或 //多个连续数字，"+"和"*"类似，"*"表示0个或多个
        return str.matches("\\d+");

    }
}
