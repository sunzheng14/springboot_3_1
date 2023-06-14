package com.sun.zq;

import com.sun.test.Student;
import com.sun.zq.controller.UserController;
import com.sun.zq.model.Address;
import com.sun.zq.model.Customer;
import com.sun.zq.model.PhoneNumber;
import com.sun.zq.model.Teacher;
import com.sun.zq.service.impl.Print;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.ComponentScan;

import java.lang.reflect.RecordComponent;

/**
 * @author : sunzheng
 */
@Slf4j
//@Import(Student.class)
@ComponentScan("com.sun")
@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(Application.class, args);

		log.info("{} 启动成功！", "Springboot_3_1_Application");
		UserController userController = context.getBean(UserController.class);
		userController.add();

		userController.getName();

		Student student = context.getBean(Student.class);
		log.info("student name: {}", student.getName());

		/** Record 类测试 */
		Teacher teacher = new Teacher("zhangsan", 18, "beijing");
		String email = Teacher.email;
		log.info("teacher email: {}", email);
		log.info("teacher name: {}", teacher.name());

		Teacher.nameUpperCase(null);

		teacher = new Teacher("lisi", 20);
		log.info("teacher name: {}", teacher.concat());

		Print print = new Print("1", "zhangsan");
		print.print();

		record SaleRecord(Long id, String name, double money) {};
		SaleRecord product = new SaleRecord(1L, "商品1", 10.02);
		System.out.println("商品销售记录：" + product.toString());

		Address address = new Address("beijing", "beijing");
		PhoneNumber phoneNumber = new PhoneNumber("021", "12345678");
		Customer customer = new Customer("1", "zhangsan", phoneNumber, address);
		System.out.println(customer.toString());

		boolean record = address.getClass().isRecord();
		System.out.println("address is record: " + record);

		RecordComponent[] recordComponents = customer.getClass().getRecordComponents();
		for (RecordComponent recordComponent : recordComponents) {
			System.out.println("recordComponent=" + recordComponent);
		}

		/**Record 类测试结束*/


	}

}
