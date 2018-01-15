package com.ThreadDemo;

public class MyThread2 extends Thread {
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
        try {
            MyThread2 t2 = new MyThread2();
            t2.start();
            Thread.sleep(200);
            t2.interrupt();
        } catch (InterruptedException e) {
            System.out.println("main catch");
            e.printStackTrace();
        }
        System.out.println("main end");
    }
}
