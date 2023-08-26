package com.booking.jpahotelbooking.entity.dto.employee;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

@Data
public class EmployeeResponseDTO {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotNull
    private String roles;
}
