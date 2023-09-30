package com.booking.jpahotelbooking.entity.dto.employee;

import com.booking.jpahotelbooking.entity.Hotel;
import com.booking.jpahotelbooking.entity.Role;
import lombok.Data;

@Data
public class EmployeeRequestDTO {

    private String firstName;
    private String lastName;
    private Role role;
    private Hotel hotel;
    private String phone;
    private String email;
    private String password;
    private String passportInfo;
}