package com.booking.jpahotelbooking.entity.dto.employee;

import com.booking.jpahotelbooking.entity.dto.role.RoleDTO;
import lombok.Data;

@Data
public class EmployeesDTO {

    private RoleDTO roles;
    private String firstName;
    private String lastName;
}
