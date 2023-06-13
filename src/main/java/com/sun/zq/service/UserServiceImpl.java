package com.sun.zq.service;

/**
 * @author: sunzheng
 * @date: 2023-06-13
 * @description:
 */
public class UserServiceImpl implements UserService {
    @Override
    public int add(int a, int b) {
        System.out.println("UserService add...");
        return a + b;
    }
}
