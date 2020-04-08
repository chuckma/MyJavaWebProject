package com.common.datedemo;


import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;

import java.util.Date;

/**
 * @author mcg
 * @create 2019-12-19-15:50
 */
public class JodaTimeDemo {


    private static final DateTimeFormatter formatter = DateTimeFormat.forPattern("yyyy-MM-dd HH:mm:ss");
    private static final DateTimeFormatter formatterweek = DateTimeFormat.forPattern("yyyyMM");
    public static void main(String[] args) {
       /* System.out.println("文本输出当前星期数，："+DateTime.now().dayOfWeek().getAsText());
        System.out.println(DateTime.now().centuryOfEra().getAsText());
        System.out.println(DateTime.now().dayOfWeek().addToCopy(-7));
        System.out.println(DateTime.now().plusDays(-1).toString(formatter));
        System.out.println(DateTime.now().withDayOfWeek(7).toString(formatter));*/

         String date = "2019-12-30 01:00:00";
//        String date = "202001";
        DateTime parse = DateTime.parse(date, formatter);
        System.out.println(parse.weekyear().get());
        System.out.println(DateTime.now().plusMonths(-11).weekOfWeekyear().getAsText());
        System.out.println("-----------");
        System.out.println(parse.year().get()+"年"+parse.monthOfYear().get()+"月");
        System.out.println(parse.year().get()+"年"+parse.weekOfWeekyear().get()+"周");
        System.out.println(parse.year().getAsString());
//        System.out.println(parse.plusDays(-1).withDayOfWeek(1).toString(formatterweek));
//        System.out.println(parse.plusDays(-1).withDayOfWeek(7).toString(formatterweek));

    }
}
