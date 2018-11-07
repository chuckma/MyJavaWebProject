package com.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 */
public class AtomicIntegerDemo1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(45);
//        atomicInteger.addAndGet(2);
        int i = atomicInteger.get();
        i = atomicInteger.getAndAdd(2);
        i = atomicInteger.getAndIncrement();
//        atomicInteger.getAndIncrement();
//        atomicInteger.getAndDecrement();
//        atomicInteger.getAndSet(33);

        // addAndGet
//        for (;;) {
//            int current = get();
//            int next = current + delta;
//            if (compareAndSet(current, next))
//                return next;
//        }

        // getAndAdd
//        for (;;) {
//            int current = get();
//            int next = current + delta;
//            if (compareAndSet(current, next))
//                return current;
//        }

        System.out.println(atomicInteger.get());

    }
}
