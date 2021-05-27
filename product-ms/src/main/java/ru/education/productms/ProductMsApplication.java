package ru.education.productms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication(scanBasePackages = "ru.education")
public class ProductMsApplication {

    public static void main(String[] args) {
        SpringApplication.run(ProductMsApplication.class, args);
    }

}