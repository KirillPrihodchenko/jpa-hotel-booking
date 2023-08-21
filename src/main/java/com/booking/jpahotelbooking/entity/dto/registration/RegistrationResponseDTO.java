package com.booking.jpahotelbooking.entity.dto.registration;

import com.booking.jpahotelbooking.entity.Rooms;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationResponseDTO {


    @NotEmpty
    private Rooms rooms;
    private LocalDateTime tsCheckIn;
    private LocalDateTime tsCheckOut;
}