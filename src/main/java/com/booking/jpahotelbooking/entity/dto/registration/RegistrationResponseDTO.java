package com.booking.jpahotelbooking.entity.dto.registration;

import com.booking.jpahotelbooking.entity.Room;
import com.booking.jpahotelbooking.entity.dto.guest.GuestResponseDTO;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationResponseDTO {

    @NotEmpty
    private GuestResponseDTO guestResponseDTO;
    @NotEmpty
    private Room room;
    @NotNull
    private LocalDateTime tsCheckIn;
    @NotNull
    private LocalDateTime tsCheckOut;
}