package com.common.datedemo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author Administrator
 */
public class test {

    public static void main(String[] args) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
        String str = "2017-10-12";
        try {
            Date date = sdf.parse(str);
            String fmtDate = sdf.format(date);
            System.out.println(fmtDate);

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
