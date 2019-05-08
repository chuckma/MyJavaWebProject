package com.common.reflectDemo;

import java.lang.reflect.Field;

/**
 * @Author mcg
 * @Date 2019/5/8 21:40
 **/

public class Test {


    public static void main(String[] args) {
        try {
            Class<?> aClass = Class.forName("com.common.reflectDemo.TaskInfoExcelVO");
            Object obj = aClass.newInstance();
            for (Field field : aClass.getDeclaredFields()) {
                field.setAccessible(true);
                if (field.getType().equals(String.class)){
                    if (field.getName().equalsIgnoreCase("amout")) {
                        field.set(obj, "21");
                    }
                    if (field.getName().equalsIgnoreCase("testContent")) {
                        field.set(obj, "testContent11");
                    }
                    if (field.getName().equalsIgnoreCase("executiveStandard")) {
                        field.set(obj, "executiveStandard123");
                    }
                    if (field.getName().equalsIgnoreCase("sampleDescription")) {
                        field.set(obj, "sampleDescription123");
                    }
                }
            }

            System.out.println(obj);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
