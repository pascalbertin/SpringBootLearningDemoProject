package com.spring.learning.customer;

import com.spring.learning.infoapp.InfoApp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;

@Configuration
public class CustomerConfiguration {

    @Value("${app.useFakeRepository:false}")
    private boolean useFakeRepository;

    @Value("${info.app.name}")
    private String appName;

    @Autowired
    private Environment environment;

    @Bean
    CommandLineRunner commandLineRunner(InfoApp infoApp) {
        return args -> {
            System.out.println("CommandLineRunner: Hello World!");
            System.out.println("Application name: " + appName);
            System.out.println("Application version: " + environment.getProperty("info.app.version"));
            System.out.println("InfoApp: " + infoApp);
        };
    }

    @Bean
    CustomerRepo customerRepo() {
        System.out.println("useFakeRepository = " + useFakeRepository);
        return new CustomerRepositoryFake();
    }
}
