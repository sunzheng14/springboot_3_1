package com.sun.zq.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * @author: sunzheng
 * @date: 2023-06-14
 * @description:
 */
@Data
@ConfigurationProperties(prefix = "my")
public class MyProperties {
    private String name;

    private String password;

}
