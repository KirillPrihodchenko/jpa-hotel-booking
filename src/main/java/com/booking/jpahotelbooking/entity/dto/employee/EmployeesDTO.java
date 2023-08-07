package com.booking.jpahotelbooking.entity.dto;

import com.booking.jpahotelbooking.entity.Roles;
import lombok.Data;

@Data
public class EmployeesDTO {

    private Roles roles;
    private String firstName;
    private String lastName;
}
