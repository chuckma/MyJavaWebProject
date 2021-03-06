package com.common.guavademo;

import com.google.common.base.Charsets;
import com.google.common.io.Files;
import com.google.common.io.MoreFiles;
import com.google.common.io.RecursiveDeleteOption;
import com.google.common.io.Resources;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang.time.DateUtils;
import org.joda.time.DateTimeUtils;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @Author mcg
 * @Date 2019/11/30 19:03
 * <p>
 * <p>
 * Guava File 相关测试
 **/

public class GuavaFileTest {


    public static void main(String[] args) throws IOException, ParseException {
        File logs = new File("D:/jboss-4.2.3.GA-a/jboss-4.2.3.GA/server/default/log");
        String ss = "123123123ADADaccc";
        System.out.println(ss.contains("d"));
        File[] files = logs.listFiles();
        List<File> list1 = new ArrayList<>();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date parse = format.parse("2019-12-03");
        Date parse1 = format.parse("2019-12-13");
//        Date parse1 = format.parse("2019-12-17");
        for (File file : files) {
            if (Files.getFileExtension(file.getAbsolutePath()).equals("log")) {
                continue;
            }
            Date logDate = format.parse(Files.getFileExtension(file.getAbsolutePath()));
            if (logDate.getTime() >= parse.getTime() && logDate.getTime()<=parse1.getTime()) {
                list1.add(file);
            }
//            if (Files.getFileExtension(file.getAbsolutePath()).equals("2019-12-16")) {
//                list1.add(file);
//            }

        }

        for (File file : list1) {
            System.out.println(Files.getFileExtension(file.getAbsolutePath()));
//            System.out.println(Files.getNameWithoutExtension(file.getAbsolutePath()));
        }


        File from = new File("test/test1.txt");
        List<String> list = null;
        try {
            list = Files.readLines(from, Charsets.UTF_8);
        } catch (Exception e) {
        }
        File to = new File("test/test.txt");
        // 复制文件  会覆盖 to 文件，to文件最后和 from 一样
//        Files.copy(from,to);

        // 移动 from文件到 to 文件里，覆盖to文件，move 操作之后，to 文件就是 from 文件
//        Files.move(from,to);

        // 是否为文件夹
        System.out.println("from 是否为 文件夹"+Files.isDirectory().test(from));


        // 是否为文件
        System.out.println("是否为文件"+Files.isFile().test(from));

        // 判断两个文件是否相同，换行符，空格等特殊符合都会比较
        System.out.println("文件 from 和 to 是否相同 "+Files.equal(from, to));

        // 获取文件的扩展名 很有用的
        System.out.println(Files.getFileExtension("dsfds.hh.test.txt"));
        System.out.println(Files.getFileExtension("test.png"));
        System.out.println(Files.getFileExtension("test.jpg"));
        System.out.println(Files.getFileExtension("test.xls"));


        // 获取不带扩展名的文件名称
        System.out.println(Files.getNameWithoutExtension("test.test.dsfs.png"));


        Path path = Paths.get("test");

        System.out.println("231");
        //删除文件夹下的内容(包括文件与子文件夹)
//        MoreFiles.deleteDirectoryContents(path, RecursiveDeleteOption.ALLOW_INSECURE);

        //删除文件或者文件夹，文件夹下有文件也会被删除
//        MoreFiles.deleteRecursively(Paths.get("test/.serialtest1.txt"),RecursiveDeleteOption.ALLOW_INSECURE);
//        MoreFiles.deleteRecursively(path,RecursiveDeleteOption.ALLOW_INSECURE);
//        MoreFiles.createParentDirectories(path);  //创建父目录



    }
}
