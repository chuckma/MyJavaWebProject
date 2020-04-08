package com.common.guavademo;

import com.google.common.base.Charsets;
import com.google.common.io.Files;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @Author mcg
 * @Date 2019/12/13 21:08
 **/

public class SearchLog {


    public static void main(String[] args) {


        File logs = new File("F:\\log");

        File[] files = logs.listFiles();
        for (File file : files) {
            List<String> list = new ArrayList<>(30000);
            try {
                list = Files.readLines(file, Charsets.UTF_8);
            } catch (Exception e) {
            }

            for (String s : list) {
                if (s.contains("delete from T_TASK_GOODS")) {
                    System.out.println(file.getName()+" >>> "+s);
                }


            }
        }




    }
}
