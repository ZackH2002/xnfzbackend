package com.hwadee;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hwadee.mapper")
public class XnfzbackendApplication {

    public static void main(String[] args) {
        SpringApplication.run(XnfzbackendApplication.class, args);
    }

}
