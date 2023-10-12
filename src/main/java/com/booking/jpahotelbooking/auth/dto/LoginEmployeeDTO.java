package com.booking.jpahotelbooking.auth.dto;

import lombok.Data;

@Data
public class LoginEmployeeDTO {

    private String email;
    private String password;
}