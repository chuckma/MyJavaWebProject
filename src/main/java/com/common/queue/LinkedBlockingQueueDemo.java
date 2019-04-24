package com.common.queue;

import java.util.concurrent.LinkedBlockingQueue;

/**
 * @Author mcg
 * @Date 2019/4/24 18:46
 **/

public class LinkedBlockingQueueDemo {


    public static void main(String[] args) throws InterruptedException {
        LinkedBlockingQueue queue = new LinkedBlockingQueue(5);
        testTake(queue);
    }

    // add() 添加成功返回 true，容纳不下，抛出异常
    private static void testAdd(LinkedBlockingQueue queue) {
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }
    }

    // offer() 如何添加成功 返回 true，如果容纳不下，返回 false
    private static void testOffer(LinkedBlockingQueue queue) {
        for (int i = 0; i < 5; i++) {
            queue.offer(i);
        }
    }

    // put 添加容量不够，当前线程就会被阻塞，知道有空间再继续
    private static void testPut(LinkedBlockingQueue queue) {
        for (int i = 0; i < 6; i++) {
            try {
                queue.put(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    // poll 获取并移除列表头，如果获取不到，返回 null
    private static void testPoll(LinkedBlockingQueue queue) {
//        testAdd(queue);
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.poll());
        }
    }

    // 获取BlockingQueue里排在首位的对象，若BlockingQueue为空，阻断进入等待状态直到BlockingQueue有新的对象被加入为止。
    private static void testTake(LinkedBlockingQueue queue) {
        for (int i = 0; i < 5; i++) {
            queue.add(i);
        }

        for (int i = 0; i < 5; i++) {
            try {
                System.out.println(queue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
