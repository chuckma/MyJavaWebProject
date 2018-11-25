package com.common.atomic;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Administrator
 */
public class AtomicIntegerDemo1 {

    public static void main(String[] args) {
        AtomicInteger atomicInteger = new AtomicInteger(45);
        int i = atomicInteger.get();
        atomicInteger.getAndAdd(2);
        i = atomicInteger.getAndIncrement();
//       i=  atomicInteger.incrementAndGet();

        /**
         * incrementAndGet（相当于 ++i） getAndIncrement（ 相当于 i++） 只做加 1 操作的时候没啥区别
         * 如果需要接受返回值就会有影响
         */
        System.out.println(atomicInteger.get()); // 结果为 48
        System.out.println(i);// 结果为 47

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


    }
}
