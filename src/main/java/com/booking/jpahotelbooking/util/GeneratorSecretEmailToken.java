package com.booking.jpahotelbooking.util;

import org.springframework.stereotype.Component;

import java.util.Random;

@Component
public class GeneratorSecretEmailToken {

    private static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
    private static final int TOKEN_LENGTH = 12;

    public String generateEmployeeToken() {
        Random random = new Random();
        StringBuilder tokenBuilder = new StringBuilder();

        for (int i = 0; i < TOKEN_LENGTH; i++) {
            int randomIndex = random.nextInt(CHARACTERS.length());
            char randomChar = CHARACTERS.charAt(randomIndex);
            tokenBuilder.append(randomChar);
        }

        return tokenBuilder.toString();
    }
}