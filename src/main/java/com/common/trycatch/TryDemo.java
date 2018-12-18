package com.common.trycatch;

/**
 * @author Administrator
 */
public class TryDemo {

    public static void main(String[] args) {

        System.out.println(action());
    }

    private static String action() {
        try{
            System.out.println(1/1);
            return "try";
        }catch (Exception e){
            e.printStackTrace();
            return "catch";
        }finally {
            System.out.println("finally");
        }
    }
}
