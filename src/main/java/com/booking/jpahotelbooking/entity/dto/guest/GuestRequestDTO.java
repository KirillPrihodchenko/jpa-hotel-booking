package com.booking.jpahotelbooking.entity.dto.guest;

import lombok.Data;

@Data
public class GuestRequestDTO {

    private String firstName;
    private String lastName;
    private String phone;
    private String email;
    private String password;
    private String passportInfo;
}