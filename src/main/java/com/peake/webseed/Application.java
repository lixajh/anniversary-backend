package com.peake.webseed;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@EnableTransactionManagement
@ServletComponentScan
@MapperScan("com.peake.**.mapper")
@SpringBootApplication
@EnableCaching
@EnableScheduling
@EnableSwagger2
//@ComponentScan("/")
@EnableWebMvc

public class Application {
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}

