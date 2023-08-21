package com.booking.jpahotelbooking.entity.dto.guest;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GuestRequestDTO {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
    @NotEmpty
    private String phone;
}