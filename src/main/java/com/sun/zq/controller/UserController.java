package com.sun.zq.controller;

import com.sun.zq.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: sunzheng
 * @date: 2013-06-13
 * @description:
 */
public class UserController {
    @Autowired
    private UserService userService;

    public void add() {
        System.out.println("UserController add...");
        int add = userService.add(2, 3);
        System.out.println("result: " + add);
    }

    public void getName() {
        userService.getName();
    }
}
