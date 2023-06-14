package com.sun.zq.model;

import cn.hutool.json.JSONUtil;

import java.util.Optional;

/**
 * @author: sunzheng
 * @date: 2023-06-14
 * @description:
 * 有三种类型的构造方法分别：是紧凑的，规范的和定制构造方法
 *
 * 紧凑型构造方法没有任何参数，甚至没有括号。
 * 规范构造方法是以所有成员作为参数
 * 定制构造方法是自定义参数个数
 */
public record Teacher(String name, int age, String address) {
    public static String email = "afasf";

    /**
     * 紧凑型构造方法
     */
    public Teacher {
        System.out.println("Teacher init...");
    }

    public Teacher(String name, int age) {
        this(name, age, "beijing");
    }

    public String concat() {
        return String.format("name: %s, age: %d, address: %s", name, age, address);
    }

    public static String nameUpperCase(String name) {
        String a = "A";
        String b = null;
        String s = Optional.ofNullable(name).orElse(b=a.repeat(2)).toUpperCase();
        System.out.println(b);
        System.out.println(s);
        return s;
    }
}
