package com.sun.zq.model;

/**
 * @author: sunzheng
 * @date:
 * @description:
 */
public record Customer(String id, String name, PhoneNumber phoneNumber, Address address) {
}
