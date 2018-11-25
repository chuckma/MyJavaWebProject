package com.common.math;

import java.text.NumberFormat;

/**
 * @author Administrator
 */
public class testr {

    public static void main(String[] args) {
//        System.out.println(getPercent(7, 9));
        long n1 = 44;
        int a =(int) n1;
        System.out.println(a);

        String s1 = "21.33";
        String s2 = "41.03";
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        double d3 = 33.12;
        double d4 = 50;
        double d5 = 21.33/100;
        double d6 = 41.03/100;
        double d7 = 3333.331;
        String s3 = String.format("%.2f", d7);
        System.out.println(s3);
        System.out.println(d4);
//        System.out.println(d3);
//        System.out.println(d1);
//        System.out.println(d2);
        double f = 0;
        double w = 50;
        f = d5 * w + d6 * (100 - w);
        System.out.println(f);
    }

    private static String getPercent(int num1, int num2) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setMaximumFractionDigits(2);

        String result = numberFormat.format((float) num1 / (float) num2 * 100);
        return result;
    }




}
