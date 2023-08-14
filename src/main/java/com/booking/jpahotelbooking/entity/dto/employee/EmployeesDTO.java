package com.booking.jpahotelbooking.entity.dto.employee;

import com.booking.jpahotelbooking.entity.Hotel;
import com.booking.jpahotelbooking.entity.dto.role.RoleDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeesDTO {

    private Hotel hotel;

    @NotNull
    private RoleDTO roles;

    @NotEmpty
    private String firstName;

    @NotEmpty
    private String lastName;
}
