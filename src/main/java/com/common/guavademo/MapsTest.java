package com.common.guavademo;

import com.google.common.collect.*;

import java.util.List;

/**
 * 将具有唯主键的对象快速存入Map等
 * Created by Andy on 2017/11/7.
 */
public class MapsTest {

    public static void main(String[] args) {

        Person person1 = new Person("1","Charles");
        Person person2 = new Person("2","Angelia");

        List<Person> personList = Lists.newArrayList();
        personList.add(person1);
        personList.add(person2);


        /*//将主键作为 map 的 key
        Map<String,Person> personMap = Maps.uniqueIndex(personList.iterator(), new Function<Person, String>() {
            public String apply(Person person) {
                return person.getId();
            }
        });

        Person p3 = personMap.get(1);
        System.out.println("将主键当作Map的Key:" + personMap);



        // 可以说是Maps.uniqueIndex相反的作用
        Set<Person> personSet = Sets.newHashSet(person1, person2);
        @SuppressWarnings("unused")
        Map<Person, String> personAsMap= Maps.asMap(personSet, new Function() {
            public Object apply(Object input) {
                return ((Person)input).getId();
            }
        });

        System.out.println(personAsMap);



        // 转换Map中的value值
        Map<String, String> transformValuesMap = Maps.transformValues(personMap, new Function<Person, String>() {
            public String apply(Person input) {
                return input.getName();
            }
        });
        System.out.println("转换Map中的value值" + transformValuesMap);*/



        ImmutableSortedSet<String> immutableSortedSet = ImmutableSortedSet.of("a", "b", "c", "a", "d", "b");
        System.out.println(immutableSortedSet.asList().get(0));
        System.out.println(immutableSortedSet.last());
        System.out.println(immutableSortedSet.comparator());

     }
}
