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
        //recordTest();

        //switchTest(3);
        //switchTest2(1);
        switchTest3(7);
    }

    static void recordTest() {
        Teacher teacher = new Teacher("zhangsan", 18, "beijing");
        String email = Teacher.email;
        log.info("teacher email: {}", email);
        log.info("teacher name: {}", teacher.name());

        Teacher.nameUpperCase(null);

        teacher = new Teacher("lisi", 20);
        log.info("teacher name: {}", teacher.concat());

        Print print = new Print("1", "zhangsan");
        print.print();

        record SaleRecord(Long id, String name, double money) {
        }
        ;
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

    static void switchTest(int i) {
        String memo = "";
        switch (i) {
            case 1 -> memo = "星期日，休息";
            case 2, 3, 4, 5, 6 -> memo = "工作日";
            case 7 -> memo = "星期六，休息";
            default -> throw new RuntimeException("无效的日期");
        }
        System.out.println("week=" + memo);
    }

    static void switchTest2(int i) {
        String memo = switch (i) {
            case 1:
                memo = "星期日，休息";
                yield memo;
            case 2, 3, 4, 5, 6:
                memo = "工作日";
                yield memo;
            case 7:
                memo = "星期六，休息";
                yield memo;
            default:
                throw new RuntimeException("无效的日期");
        };

        System.out.println("week=" + memo);
    }

    static void switchTest3(int i) {
        String memo = switch (i) {
            case 1 -> {
                memo = "星期日，休息";
                yield memo;
            }
            case 2, 3, 4, 5, 6 -> {
                memo = "工作日";
                yield memo;
            }
            case 7 -> {
                memo = "星期六，休息";
                yield memo;
            }
            default -> throw new RuntimeException("无效的日期");
        };

        System.out.println("week=" + memo);
    }

    /**
     * 本方法中的使用方式，在jdk19才能使用
     */
    static void switchTest4() {
        record Line(int x, int y){};
        record Rectangle(int width,int height){};
        record Shape(int width,int height){};

        Shape shape = new Shape(10, 20);
        /*int result = switch(shape){
            case Line(int x, int y) -> {
                System.out.println("图形是线：x="+x+",y="+y);
                yield x + y;
            }
            case Rectangle(int w, int h) -> {
                System.out.println("图形是矩形：w="+w+",h="+h);
                yield w * h;
            }

            case Shape(int w, int h) -> {
                System.out.println("图形是其他形状：w="+w+",h="+h);
                yield 2*(w + h);
            }
            default -> throw new RuntimeException("无效的图形");
        };*/
        System.out.println("图形的周长是："+result);
    }

}
