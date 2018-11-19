package com.ExcelEI;

import cn.afterturn.easypoi.excel.ExcelImportUtil;
import cn.afterturn.easypoi.excel.annotation.Excel;
import cn.afterturn.easypoi.excel.entity.ImportParams;
import cn.afterturn.easypoi.util.PoiPublicUtil;
import org.apache.commons.lang.builder.ReflectionToStringBuilder;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class test {

    public static void main(String[] args) throws FileNotFoundException  {
        /*String filePath = "/Users/lucasma/DeskTop/test.xls";

        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<Student> list = ExcelImportUtil.importExcel(
                new File("/Users/lucasma/DeskTop/test.xls"),
                Student.class, params);
//        System.out.println(new Date().getTime() - start);
        System.out.println(list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0).getName()));*/

        test1();
    }

    public static void test1(){
        String filePath = "/Users/lucasma/DeskTop/ExcelExportMsgClient.xlsx";

        ImportParams params = new ImportParams();
        params.setTitleRows(1);
        params.setHeadRows(1);
        long start = new Date().getTime();
        List<MsgClient> list = ExcelImportUtil.importExcel(
                new File(filePath),
                MsgClient.class, params);
        System.out.println(new Date().getTime() - start);
//        Assert.assertEquals(100,list.size());
        System.out.println(ReflectionToStringBuilder.toString(list.get(0)));
    }


}
