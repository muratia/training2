package com.am.training.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableAutoConfiguration
@ComponentScan(excludeFilters =
@ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "com\\.am\\.training\\.demo\\.utils\\..*"))
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run (DemoApplication.class, args);
    }
}
