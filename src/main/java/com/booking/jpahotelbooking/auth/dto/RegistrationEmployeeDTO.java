package com.booking.jpahotelbooking.auth.dto;

import lombok.Data;

@Data
public class RegistrationEmployeeDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
}