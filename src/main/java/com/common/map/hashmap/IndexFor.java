package com.common.map.hashmap;

/**
 * hashMap indexFor 方法
 *
 * indexFor 只有在 jdk7以下
 */
public class IndexFor {


    public static void main(String[] args) {

        /**
         * HashMap的底层数组长度总是2的n次方，在构造函数中存在：capacity <<= 1;这样做总是能够保证HashMap的底层数组长度为2的n次方。
         * 当length为2的n次方时，h&(length - 1)就相当于对length取模，而且速度比直接取模快得多，这是HashMap在速度上的一个优化。
         * 至于为什么是2的n次方下面解释。
         *
         * 我们回到indexFor方法，该方法仅有一条语句：h&(length - 1)， h 为 hash 值
         * 这句话除了上面的取模运算外还有一个非常重要的责任：均匀分布table数据和充分利用空间。
         *
         * 这里我们假设length为16(2^n)和15，h为5、6、7。
         */

        System.out.println(indexFor(5,16));
        System.out.println(indexFor(6,16));
        System.out.println(indexFor(7,16));

        System.out.println("------------------");

        System.out.println(indexFor(5,15));
        System.out.println(indexFor(6,15));
        System.out.println(indexFor(7,15));

        /**
         * 当n=15时，6和7的结果一样，这样表示他们在table存储的位置是相同的，也就是产生了碰撞，6、7就会在一个位置形成链表，
         * 这样就会,显得比较拥挤，导致空间浪费并且查询速度降低。诚然这里只分析三个数字不是很多，那么我们就看0-15。
         */

        System.out.println("==================");
        for (int i = 0; i <= 100; i++) {
            System.out.println(indexFor(i,134));
        }

        /**
         * 可以看到上面的循环输出后，碰撞发生了 8 次 ，很多空间没有被利用，这显然是不行的。
         */



    }

    public static int indexFor(int h, int length){
        System.out.println(h & (length - 1));
        return h & (length - 1);
    }
}
