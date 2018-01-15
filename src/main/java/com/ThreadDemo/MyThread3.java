package com.ThreadDemo;

public class MyThread3 extends Thread{
    @Override
    public void run() {
        try {
            System.out.println("run start");
            Thread.sleep(20000);
            System.out.println("run end");
        } catch (InterruptedException e) {
            System.out.println("run catch "+this.isInterrupted());
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        MyThread3 t3 = new MyThread3();
        t3.start();
        t3.interrupt();
    }
}
