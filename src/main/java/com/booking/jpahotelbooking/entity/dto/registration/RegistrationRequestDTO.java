package com.booking.jpahotelbooking.entity.dto.registration;

import com.booking.jpahotelbooking.entity.Rooms;
import com.booking.jpahotelbooking.entity.dto.guest.GuestResponseDTO;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RegistrationRequestDTO {

    private GuestResponseDTO responseDTO;
    @NotEmpty
    private Rooms rooms;
    private LocalDateTime tsCheckIn;
    private LocalDateTime tsCheckOut;
}
