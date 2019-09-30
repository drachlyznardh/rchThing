package com.roundhousecode.gods.thing;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;

/**
 * A Camel application that does a thing with Spring Boot
 */
@SpringBootApplication
@ImportResource("classpath:rhc-thing.xml")
@PropertySource("classpath:rhc-thing.properties")
public class Application {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) {
        SpringApplication.run(Application.class, args);
    }
}

