package com.map.hashmap;


import java.util.HashMap;
import java.util.Map;

/**
 * Created by Andy on 2017/9/7.
 */
public class MapDemo {
    public static void main(String[] args) {
        HashMap<String,String> map = new HashMap();
        int hc = map.hashCode();
        map.clear();
        map.entrySet();
        System.out.println(hc);


        Map<Integer, Integer> map1 = new HashMap<>();
        map1.put(null, 1);
        map1.put(2, null);
        System.out.println(map1.get(null));
        System.out.println(map1.get(1));


        // hashmap 的 key 可以使用自定义对象 只能是引用数据类型，不能是基本数据类型
        Map<Student, String> map2 = new HashMap();

        Student student1 = new Student("张三", "1", "1234", 23);
        Student student2 = new Student("李四", "1", "1", 23);
        Student student3 = new Student("王五", "1", "12", 23);
        Student student4 = new Student("我", "1", "0000", 23);

        map2.put(student1, "1");
        map2.put(student2, "2");
        map2.put(student3, "3");
        map2.put(student4, "4");

        for (Map.Entry<Student, String> entry : map2.entrySet()) {
            System.out.println(entry.getKey() + entry.getValue());
        }
    }

}
