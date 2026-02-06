package com.northstar.northstar.store.service;

import com.northstar.northstar.store.service.configuration.AppConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(value = AppConfiguration.class)
public class NorthstarStoreServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(NorthstarStoreServiceApplication.class, args);
    }
}
