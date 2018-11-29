package com.common.keywords;

import java.io.*;

/**
 * @author Administrator
 *
 * 1. 一旦变量被 transient 修饰，该变量将不再是持久化的部分，被序列化后无法获得访问
 * 2. 被transient关键字修饰的变量不再能被序列化，一个静态变量不管是否被transient修饰，均不能被序列化
 */
public class TransientKey {

    public static void main(String[] args) {

        User user = new User();
        user.setUsername("Alexia");
        user.setPasswd("123456");

        System.out.println("read before Serializable: ");
        System.out.println("username: " + user.getUsername());
        System.err.println("password: " + user.getPasswd());

        try {
            ObjectOutputStream os = new ObjectOutputStream(
                    new FileOutputStream("E:\\basejava/user.txt"));
            os.writeObject(user); // 将User对象写进文件
            os.flush();
            os.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            // 在反序列化之前改变username的值
           //  User.username = "jmwang";
            ObjectInputStream is = new ObjectInputStream(new FileInputStream(
                    "E:\\basejava/user.txt"));
            user = (User) is.readObject(); // 从流中读取User的数据
            is.close();

            System.out.println("\nread after Serializable: ");
            System.out.println("username: " + user.getUsername());
            System.err.println("password: " + user.getPasswd());

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}


class User implements Serializable {
    private static final long serialVersionUID = 8294180014912103005L;

    public static String username;
    private transient String passwd;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPasswd() {
        return passwd;
    }

    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }

}