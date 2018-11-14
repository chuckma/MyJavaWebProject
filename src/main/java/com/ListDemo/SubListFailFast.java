package com.ListDemo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 *
 */
public class SubListFailFast {

    public static void main(String[] args) {

        /**
         *
         *  ArrayList.subList 方法说明 fail-fast机制
         *
         */
        List masterList = new ArrayList();
        masterList.add("1");
        masterList.add("2");
        masterList.add("3");
        masterList.add("4");
        masterList.add("5");

        List branchList = masterList.subList(0, 3);

        // 下方三行代码不注释，则会导致 branchList 操作出现异常
        masterList.remove(0);
        masterList.add("6");
        masterList.clear();

        // 下面四行全部都能够正确运行
        branchList.clear();
        branchList.add("7");
        branchList.add("8");
        branchList.remove(0);

        // 正常遍历结束，只有一个元素 7
        for (Object t : branchList) {
            System.out.println(t);
        }

        // 子列表修改导致主列表也被修改，输出 [8,4,5]
        System.out.println(masterList);
    }


}
