package com.common.io.SeriaTest;

/**
 * “基本类型” 和 “java自带的实现Serializable接口的类” 对序列化的支持
 *
 * @author skywang
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

public class SerialTest2 {
    private static final String TMP_FILE = ".serialabletest2.txt";

    public static void main(String[] args) {
        testWrite();
        testRead();
    }

    /**
     * ObjectOutputStream 测试函数
     */
    private static void testWrite() {
        try {
            ObjectOutputStream out = new ObjectOutputStream(
                    new FileOutputStream(TMP_FILE));
            out.writeBoolean(true);    // 写入Boolean值
            out.writeByte((byte)65);// 写入Byte值
            out.writeChar('a');     // 写入Char值
            out.writeInt(20131015); // 写入Int值
            out.writeFloat(3.14F);  // 写入Float值
            out.writeDouble(1.414D);// 写入Double值
            // 写入HashMap对象
            HashMap map = new HashMap();
            map.put("one", "red");
            map.put("two", "green");
            map.put("three", "blue");
            out.writeObject(map);

            out.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    /**
     * ObjectInputStream 测试函数
     */
    private static void testRead() {
        try {
            ObjectInputStream in = new ObjectInputStream(
                    new FileInputStream(TMP_FILE));
            System.out.printf("boolean:%b\n" , in.readBoolean());
            System.out.printf("byte:%d\n" , (in.readByte()&0xff));
            System.out.printf("char:%c\n" , in.readChar());
            System.out.printf("int:%d\n" , in.readInt());
            System.out.printf("float:%f\n" , in.readFloat());
            System.out.printf("double:%f\n" , in.readDouble());
            // 读取HashMap对象
            HashMap map = (HashMap) in.readObject();
            Iterator iter = map.entrySet().iterator();
            while (iter.hasNext()) {
                Map.Entry entry = (Map.Entry)iter.next();
                System.out.printf("%-6s -- %s\n" , entry.getKey(), entry.getValue());
            }

            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
