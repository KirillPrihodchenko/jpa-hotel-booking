package com.booking.jpahotelbooking.entity.dto.guest;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class GuestResponseDTO {

    @NotEmpty
    private String firstName;
    @NotEmpty
    private String lastName;
}