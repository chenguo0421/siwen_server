package com.xqkj.siwencat;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.xqkj.siwencat.dao")
public class SiwencatApplication {

    public static void main(String[] args) {
        SpringApplication.run(SiwencatApplication.class, args);
    }

}
