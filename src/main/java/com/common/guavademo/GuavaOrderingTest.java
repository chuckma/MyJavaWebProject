package com.common.guavademo;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import com.google.common.collect.Lists;
import com.google.common.collect.Ordering;
import org.apache.commons.lang.time.DateUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @author mcg
 * @create 2019-12-06-17:25
 */
public class GuavaOrderingTest {


    public static void main(String[] args) {
        List<String> list = Lists.newArrayList();
        list.add("10");
        list.add("11");
        list.add("18");
        list.add("14");
        list.add("13");

//        System.out.println("list:"+ list);

        Ordering<String> naturalOrdering = Ordering.natural();
        Ordering<Object> usingToStringOrdering = Ordering.usingToString();
        Ordering<Object> arbitraryOrdering = Ordering.arbitrary();

        System.out.println(naturalOrdering.sortedCopy(list).toString());
        System.out.println(list);

        DateTime parse = DateUtil.parse("2019-12-11 13:31");
        DateTime parse1 = DateUtil.parse("2019-12-12 13:31");
        List<DateTime> list1 = new ArrayList<>();
        list1.add(parse);
        list1.add(parse1);
//        System.out.println(naturalOrdering.sortedCopy(list1).toString());

//        System.out.println("naturalOrdering:"+ naturalOrdering.sortedCopy(list));
//        System.out.println("usingToStringOrdering:"+ usingToStringOrdering.sortedCopy(list));
//        System.out.println("arbitraryOrdering:"+ arbitraryOrdering.sortedCopy(list));
    }
}
