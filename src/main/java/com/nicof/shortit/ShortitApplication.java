package com.nicof.shortit;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.reactive.config.EnableWebFlux;

@EnableWebFlux
@SpringBootApplication
public class ShortitApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShortitApplication.class, args);
    }

}
