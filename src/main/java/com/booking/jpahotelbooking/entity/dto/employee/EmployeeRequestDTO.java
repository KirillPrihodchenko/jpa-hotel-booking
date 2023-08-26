package com.booking.jpahotelbooking.entity.dto.employee;

import com.booking.jpahotelbooking.entity.Hotel;
import com.booking.jpahotelbooking.entity.Role;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeRequestDTO {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private Role roles;
    private Hotel hotel;
    private String phone;
    private Double salary;
}