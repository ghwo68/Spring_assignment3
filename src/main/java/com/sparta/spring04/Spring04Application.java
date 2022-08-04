package com.sparta.spring04;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@EnableJpaAuditing
@SpringBootApplication
public class Spring04Application {

    public static void main(String[] args) {
        SpringApplication.run(Spring04Application.class, args);
    }

}
