package com.sun.zq.config;

import com.sun.zq.controller.UserController;
import com.sun.zq.service.UserService;
import com.sun.zq.service.impl.UserServiceImpl;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: sunzheng
 * @date: 2023-06-13
 * @description:
 */
@Configuration
@EnableConfigurationProperties(MyProperties.class)
public class Config {
    @Bean
    public UserController userController() {
        return new UserController();
    }

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

}
