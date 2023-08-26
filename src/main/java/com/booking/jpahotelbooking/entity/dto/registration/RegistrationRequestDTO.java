package com.booking.jpahotelbooking.entity.dto.registration;

import com.booking.jpahotelbooking.entity.Room;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationRequestDTO {

    @NotEmpty
    private Room rooms;
    @NotNull
    private LocalDateTime tsCheckIn;
    @NotNull
    private LocalDateTime tsCheckOut;
}