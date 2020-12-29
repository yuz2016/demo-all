package com.example.beforeall;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com.example.beforeall.springcache.mapper")
@EnableCaching
@SpringBootApplication
@ConfigurationPropertiesScan("com.example.beforeall.testAll")
public class BeforeAllApplication {

    public static void main(String[] args) {
        SpringApplication.run(BeforeAllApplication.class, args);
    }

}
