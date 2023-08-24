package com.booking.jpahotelbooking.entity.dto.registration;

import com.booking.jpahotelbooking.entity.Room;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationResponseDTO {


    @NotEmpty
    private Room rooms;
    private LocalDateTime tsCheckIn;
    private LocalDateTime tsCheckOut;
}