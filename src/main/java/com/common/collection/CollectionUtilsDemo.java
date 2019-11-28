package com.common.collection;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
public class CollectionUtilsDemo {


    public static void main(String[] args) {
//        cu1();
        List<Integer> list1 = new ArrayList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(3);
        List<Integer> list2 = new ArrayList<>();
        list2.add(1);
        list2.add(3);
        list2.add(4);
        cu2(list1, list2,"subtract");
        System.out.println(list1);
        System.out.println(list2);
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    private static class Student {
        private String name;
        private String age;
    }

    /**
     * 集合处理
     */
    private static void cu2(List<Integer> list1, List<Integer> list2, String type) {
        switch (type) {
            case "union":
                CollectionUtils.union(list1, list2);
                break;
            case "intersection":
                CollectionUtils.intersection(list1, list2);
                break;
            case "disjunction":
                CollectionUtils.disjunction(list1, list2);
                break;
            case "subtract":
                CollectionUtils.subtract(list1, list2);
                break;
            default:
                break;
        }
    }

    private static void cu1() {
        List<Student> stuList = new ArrayList<Student>();
        stuList.add(new Student("wang", "18"));
        stuList.add(new Student("li", "19"));
        stuList.add(new Student("li", "20"));
        CollectionUtils.filter(
                stuList,
                s -> s.name.equals("li")
        );

        System.out.println(stuList);
    }
}
