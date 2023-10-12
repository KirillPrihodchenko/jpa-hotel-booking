package com.booking.jpahotelbooking.auth.dto;

import lombok.Data;

@Data
public class JWTRequestDTO {

    private String email;
    private String password;
}