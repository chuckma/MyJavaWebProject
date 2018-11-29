package com.common.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class test {


    public static void main(String[] args) {
//        FileOutputStream fos = null;
        try {
            FileOutputStream fos = new FileOutputStream("/Users/lucasma/Desktop/fos.txt");
            fos.write(97);
            fos.write(98);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
