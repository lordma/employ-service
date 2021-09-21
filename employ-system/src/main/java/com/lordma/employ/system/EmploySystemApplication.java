package com.lordma.employ.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.lordma.*.*.service")
@MapperScan("com.lordma.employ.system.mapper")
@ComponentScan(basePackages = "com.lordma.employ.*.*.component")
@ComponentScan(basePackages = "com.lordma.*.*.controller")
@ComponentScan(basePackages = "com.lordma.*.*.*.controller")
public class EmploySystemApplication {

    public static void main(String[] args) {
        SpringApplication.run(EmploySystemApplication.class, args);
    }

}
