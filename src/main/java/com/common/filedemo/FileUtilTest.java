package com.common.filedemo;

import org.apache.commons.io.FilenameUtils;
import org.apache.commons.lang.StringUtils;

/**
 * @author Administrator
 */
public class FileUtilTest {


    public static void main(String[] args) {
        String name = "20102-1-1.pdf";
        System.out.println(StringUtils.substringBefore(name,"-"));
//        System.out.println(StringUtils.substringBeforeLast(name,"-"));
//        System.out.println(StringUtils.substringAfter(name,"-"));
//        System.out.println(StringUtils.substringAfterLast(name,"."));
    }
}
