package com.booking.jpahotelbooking.auth.dto;

import lombok.Data;

@Data
public class RegistrationGuestDTO {

    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private String phone;
}