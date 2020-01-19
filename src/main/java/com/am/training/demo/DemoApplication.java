package com.am.training.demo;


import com.am.training.demo.ifs.StorageProperties;
import com.am.training.demo.ifs.StorageService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

@SpringBootApplication
@EnableAutoConfiguration
@AutoConfigurationPackage
@ComponentScan(excludeFilters =
@ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "com\\.am\\.training\\.demo\\.utils\\..*"))
@ComponentScan(excludeFilters =
@ComponentScan.Filter(type = FilterType.REGEX,
        pattern = "com\\.am\\.training\\.demo\\.dto\\..*"))
@EnableConfigurationProperties(StorageProperties.class)
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

    @Bean
    CommandLineRunner init(StorageService storageService) {
        return (args) -> {
            storageService.deleteAll();
            storageService.init();
        };
    }


}
