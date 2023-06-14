package com.sun.zq.service.impl;

import com.sun.zq.service.PrintService;

/**
 * @author: sunzheng
 * @date:
 * @description:
 */
public record Print(String id, String name) implements PrintService {
    @Override
    public void print() {
        System.out.println(String.join("-", id, name));
    }
}
