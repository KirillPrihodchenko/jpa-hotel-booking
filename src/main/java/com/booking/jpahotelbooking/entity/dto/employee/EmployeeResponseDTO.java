package com.booking.jpahotelbooking.entity.dto.employee;

import lombok.Data;

@Data
public class EmployeeResponseDTO {

    private String firstName;
    private String lastName;
    private String role;

    public EmployeeResponseDTO(String firstName, String lastName) {

        this.firstName = firstName;
        this.lastName = lastName;
    }
}