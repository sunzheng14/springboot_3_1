package com.sun.zq;

import com.sun.test.Student;
import com.sun.zq.controller.UserController;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

@Slf4j
//@Import(Student.class)
@ComponentScan("com.sun")
@SpringBootApplication
public class Springboot31Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Springboot31Application.class, args);

		log.info("{} 启动成功！", "Springboot_3_1_Application");

		UserController userController = context.getBean(UserController.class);
		userController.add();

		Student student = context.getBean(Student.class);
		log.info("student name: {}", student.getName());
	}

}
