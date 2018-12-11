package com.common.math;

/**
 * @author Administrator
 */
public class test1 {


    public static void main(String[] args) {
        System.out.println(getRatio(444, 2258));
    }

    private static String getRatio(int num1, int num2) {
        if (num2 == 0) {
            return "0";
        }
        double res =(double)num1/(double)num2 *100;
       return String.format("%.2f",res);
    }

}
