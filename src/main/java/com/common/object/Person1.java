package com.common.object;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @Author mcg
 * @Date 2019/3/3 18:29
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person1 {
    private String name;
    private Integer age;
}
