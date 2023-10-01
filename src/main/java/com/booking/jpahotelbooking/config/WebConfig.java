package com.booking.jpahotelbooking.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan (basePackages = {
        "com.booking.jpahotelbooking.entity",
        "com.booking.jpahotelbooking.controller",
        "com.booking.jpahotelbooking.service"
    }
)
public class WebConfig {
}

