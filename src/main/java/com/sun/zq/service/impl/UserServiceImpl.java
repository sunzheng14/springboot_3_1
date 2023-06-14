package com.sun.zq.service.impl;

import com.sun.zq.config.MyProperties;
import com.sun.zq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * @author: sunzheng
 * @date: 2023-06-13
 * @description:
 */
public class UserServiceImpl implements UserService {
    /*@Value("${name}")
    private String name;

    @Value("${password}")
    private String password;*/

    @Autowired
    private MyProperties myProperties;

    @Override
    public int add(int a, int b) {
        System.out.println("UserService add...");
        return a + b;
    }

    @Override
    public void getName() {
        System.out.println("name: " + myProperties.getName() + ",password: " + myProperties.getPassword());
    }


}
