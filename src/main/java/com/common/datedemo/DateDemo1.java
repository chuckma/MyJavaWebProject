package com.common.datedemo;

import org.apache.commons.lang.time.DateUtils;

import java.util.Date;

/**
 * @author Administrator
 */
public class DateDemo1 {

    public static void main(String[] args) {
//        System.out.println(DateUtils.getFragmentInDays(new Date(), 8));

        System.out.println(DateUtils.MILLIS_PER_SECOND);
        System.out.println(System.currentTimeMillis()+333);
        System.out.println(Math.random());
    }
}
