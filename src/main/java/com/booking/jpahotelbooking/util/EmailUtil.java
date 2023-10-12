package com.booking.jpahotelbooking.util;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor

@Component
public class EmailUtil {

    private final GeneratorSecretEmailToken generatorSecretEmailToken;

    public String getEmailMessage(String fullName) {

        return "Hello, " + fullName +
                "!\n\nYour new account has been created.\n\nEnter this token: " +
                generatorSecretEmailToken.generateEmployeeToken();
    }
}