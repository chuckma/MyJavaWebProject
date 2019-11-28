package com.common.pojo;

/**
 * @Author mcg
 * @Date 2019/11/28 22:04
 *
 * Builder 模式
 *
 * 如果类的构造器或者静态工厂中具有多个参数，设计这种类时，Builder 模式就是一种不错的选择
 *
 * 特别是当大多数参数都是可选或者类型相同的时候。
 *
 * 与使用重叠构造器模式相比，使用Builder 模式的客户端代码就更容易阅读和编写，构建器也比 JavaBeans 安全
 *
 *
 * Effective Java 第 2 条
 * 遇到多个构造器参数时要考虑使用构建器。
 *
 *
 * 如何合理的覆盖 toString 方法
 *
 *
 *
 * 对于排序敏感性的实体，要考虑实现 Comparable 接口
 **/


public class Users implements Comparable<Users>{

    private String username;
    private String nickname;
    private Integer sex;
    private Integer age;
    private String phone;

    @Override
    public int compareTo(Users users) {
        int result = Integer.compare(sex, users.sex);
        if (result == 0) {
            result = Integer.compare(age, users.age);
        }
        return result;
    }

    public static class Builder {
        private String username;
        private Integer age;

        private String nickname;
        private Integer sex ;
        private String phone;

        public Builder(String username, Integer age) {
            this.username = username;
            this.age = age;
        }

        public Builder nickname(String val) {
            nickname = val;
            return this;
        }

        public Builder sex(Integer val) {
            sex = val;
            return this;
        }

        public Builder phone(String val) {
            phone = val;
            return this;
        }


        public Users build() {
            return new Users(this);
        }

    }


    private Users(Builder builder) {
        username = builder.username;
        nickname = builder.nickname;
        sex = builder.sex;
        age = builder.age;
        phone = builder.phone;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    @Override
    public String toString() {
        return "Users{" +
                "username='" + username + '\'' +
                ", nickname='" + nickname + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", phone='" + phone + '\'' +
                '}';
    }
}
